package ReflectionTest.Test;

import ReflectionTest.Prepare.Person;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author vdsklnl
 * @create 2022-04-26 11:31
 * @Description
 */

public class InstanceTest {

    @Test
    public void test() {

        Class<Person> clazz = Person.class;
        try {
            Person instance = clazz.getDeclaredConstructor().newInstance();
            instance.eat();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
