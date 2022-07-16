package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author vdsklnl
 * @create 2022-04-27 10:25
 * @Description  动态代理举例
 *
 */

interface Human {
    String getBelief();
    void eat(String food);
}

// 被代理类
class Superman implements Human {

    @Override
    public String getBelief() {
        return "Kryptonian";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like " + food);
    }
}

/*
   动态代理问题：
   一、如何根据加载到内存的被代理类，
       动态创建代理类和对象
   二、通过代理类对象调用方法，如何动态
       调用同名方法
 */

class ProxyFactory {

    // 调用方法返回代理类对象，解决问题一
    // 声明为Object类
    public static Object getProxyInstance(Object o) {

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(o);

        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), handler);
    }

}

class MyInvocationHandler implements InvocationHandler {

    // 需要使用被代理类对象赋值
    private  Object o;

    public void bind(Object o) {
        this.o = o;
    }

    // 通过代理类对象，调用方法a，自动调用下列方法：invoke()
    // 将被代理类执行方法a声明在invoke()方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // method:即为代理类对象调用方法，也作为被代理类要调用方法
        // o:被代理类对象
        Object returnValue = method.invoke(o, args);
        // 上述方法返回值作为当前类invoke()方法返回值
        return returnValue;

    }

}

public class DynamicProxyTest {

    public static void main(String[] args) {
        Superman superman = new Superman();
        // proxyInstance:代理类对象
        // 需强转为具体接口Human，才可以调用对应方法，不能是Superman，否则被代理与代理类一致
        Human proxyInstance =(Human) ProxyFactory.getProxyInstance(superman);
//        Object proxyInstance = ProxyFactory.getProxyInstance(superman);
        // 代理类对象调用方法自动调用对应被代理类方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("麻辣烫");

        System.out.println("--------------------------");
        AntaClothFactory antaClothFactory = new AntaClothFactory();
        ClothFactory clothFactory =(ClothFactory) ProxyFactory.getProxyInstance(antaClothFactory);
        clothFactory.produceCloth();

    }

}
