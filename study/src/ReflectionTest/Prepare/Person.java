package ReflectionTest.Prepare;

/**
 * @author vdsklnl
 * @create 2022-04-26 10:59
 * @Description
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String>
        implements Comparable<String>, MyInterface {

    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests, int age) throws NullPointerException, ClassCastException {
        return interests + age;
    }

    private static void showDesc() {
        System.out.println("我是个好人！");
    }

    @Override
    public void info() {
        System.out.println("我是一个人!");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

}