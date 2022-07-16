package ReflectionTest.Prepare;

import java.io.Serializable;

/**
 * @author vdsklnl
 * @create 2022-04-26 10:54
 * @Description  reflection 测试类
 */

public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸！");
    }

    public void eat() {
        System.out.println("生物吃饭！");
    }
}



