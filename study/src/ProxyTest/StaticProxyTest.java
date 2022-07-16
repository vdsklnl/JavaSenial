package ProxyTest;

/**
 * @author vdsklnl
 * @create 2022-04-26 20:14
 * @Description  静态代理举例
 *               代理类与被代理类均确定
 */

interface ClothFactory {

    void produceCloth();

}

// 代理类
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory; //用于被代理类实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备生产...");
        factory.produceCloth();
        System.out.println("代理工厂生产完成...");
    }

}

// 被代理类
class AntaClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Anta工厂生产体育用品...");
    }

}

public class StaticProxyTest {
    public static void main(String[] args) {

        ClothFactory anta = new AntaClothFactory();
        ProxyClothFactory factory = new ProxyClothFactory(anta);

        factory.produceCloth();

    }
}
