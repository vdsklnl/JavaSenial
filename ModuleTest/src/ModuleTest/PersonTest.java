package ModuleTest;

import PersonClass.Person;
import org.junit.Test;

/**
 * @author vdsklnl
 * @create 2022-04-28 21:00
 * @Description
 */

public class PersonTest {

    public static void main(String[] args) {
        Person p = new Person("Tom",12);
        System.out.println(p.toString());
    }

    @Test
    public void test() {
        Person p = new Person("Tom",12);
        p.toString();
    }

}
