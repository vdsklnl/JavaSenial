package threadcommunicate;

/**
 * @author vdsklnl
 * @create 2022-04-01 15:31
 * @Description 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 *              取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 *              生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 *              知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 *              果店中有产品了再通知消费者来取走产品。
 */

class Clerk {
    //生产产品
    private int product = 0;

    public synchronized void produce() {
        if (product < 20) {
            product++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + product + "号产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品


    public synchronized void consume() {
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + product + "号产品");
            product--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产产品~~");
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produce();
        }
    }
}

class Customer extends Thread {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费产品~~");
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consume();
        }
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");
        p1.start();

        Customer c1 = new Customer(clerk);
        c1.setName("消费者1");
        c1.start();
        //多消费者
//        Customer c2 = new Customer(clerk);
//        c2.setName("消费者1");
//        c2.start();

    }
}
