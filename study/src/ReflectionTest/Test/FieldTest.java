package ReflectionTest.Test;

import ReflectionTest.Prepare.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author vdsklnl
 * @create 2022-04-26 11:18
 * @Description 属性获取测试
 */

public class FieldTest {

    @Test
    public void test1() {

        Class clazz = Person.class;

        // 获取属性结构
        Field[] fields = clazz.getFields();
        for (Field f:fields) {
            System.out.println(f);
        }

        System.out.println("---------------------------------");

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field:declaredFields) {
            System.out.println(field);
        }

    }

    //权限修饰符 数据类型 变量名...
    @Test
    public void test2() {

        Class clazz = Person.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field f:fields) {
            // 权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            // 数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            // 变量名
            String name = f.getName();
            System.out.print(name);
            System.out.println();

        }

    }

}
