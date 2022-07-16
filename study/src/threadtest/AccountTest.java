package threadtest;

/**
 * @author vdsklnl
 * @create 2022-03-31 20:40
 * @Description
 *  银行 有一 个账户。
 *  有两个储户 分别向同一个账户存3000 元， 每次存1000 ， 存3 次 。每次存完打
 *  印账户余额。
 */

class Account {
    private double balance = 0;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    //同步方法：public synchronized void deposit(double amt){}
    public void deposit(double amount) {
        balance += amount;
    }

}

// 继承Thread 采用lock锁
//class Customer extends Thread {
//    private Account acct;
//    //创建锁需保证只有一把
//    private static ReentrantLock lock = new ReentrantLock();
//
//    public Customer(Account acct) {
//        this.acct = acct;
//    }
//
//    @Override
//    public void run() {
//        try {
//            lock.lock();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            for (int i = 0; i < 3; i++) {
//                acct.deposit(1000);
//                System.out.println(Thread.currentThread().getName() + "存储了1000元");
//                System.out.println("账户余额：" + acct.getBalance());
//            }
//        } finally {
//            lock.unlock();
//        }
//    }
//
//}
//
//public class AccountTest {
//    public static void main(String[] args) {
//        Account acct = new Account();
//        Customer c1 = new Customer(acct);
//        Customer c2 = new Customer(acct);
//
//        c1.setName("甲");
//        c2.setName("乙");
//
//        c1.start();
//        c2.start();
//
//    }
//}

// 实现Runnable 采用synchronized
class Customer implements Runnable {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        synchronized(this){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 3; i++) {
                acct.deposit(1000);
                System.out.println(Thread.currentThread().getName() + "存储了1000元");
                System.out.println("账户余额：" + acct.getBalance());
            }
        }
    }

}

public class AccountTest {
    public static void main(String[] args) {
        Customer customer = new Customer(new Account());

        Thread c1 = new Thread(customer);
        Thread c2 = new Thread(customer);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();

    }
}
