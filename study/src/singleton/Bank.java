package singleton;

/**
 * @author vdsklnl
 * @create 2022-03-31 16:43
 * @Description  单例模式
 */

public class Bank {
    //饿汉式
//    public Bank(){}
//
//    private static Bank instance = new Bank();
//
//    public static Bank getInstance(){
//        return instance;
//    }

    //懒汉式
    public Bank(){}

    private static Bank instance = null;

    public static Bank getInstance(){
        //不加外层效率稍差，减少线程排队等锁情况
        //多次调用也会产生线程安全问题 synchronized解决
        if(instance == null){
            synchronized (Bank.class) {
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }


}
