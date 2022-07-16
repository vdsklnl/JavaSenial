package ReflectionTest.Test;

import ReflectionTest.Prepare.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author vdsklnl
 * @create 2022-04-26 16:57
 * @Description  调用运行时类的指定结构：属性、方法、构造器
 */

public class ReflectionTest {

    @Test
    public void testField() {

        try {
            Class<Person> clazz = Person.class;
            Person p = clazz.newInstance();
            Field name = clazz.getDeclaredField("name");
            name.setAccessible(true);
            name.set(p,"T-Virus");
            System.out.println(name.get(p));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testMethod() {

        try {
            Class clazz = Person.class;
            Person p =(Person) clazz.newInstance();
            Method show = clazz.getDeclaredMethod("show", String.class);
            show.setAccessible(true);
            String nation =(String) show.invoke(p, "China");
            System.out.println("国籍：" + nation);
            System.out.println("------------------------");
            Method showDesc = clazz.getDeclaredMethod("showDesc");
            showDesc.setAccessible(true);
            Object invoke = showDesc.invoke(null);
            System.out.println(invoke);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testConstructor() {

        try {
            Class clazz = Person.class;
            Constructor constructor = clazz.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            Object hhhh = constructor.newInstance("HHHH");
            Person p =(Person) hhhh;
            System.out.println(p);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
