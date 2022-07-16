package CollectionTest;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author vdsklnl
 * @create 2022-04-07 20:28
 * @Description
 * 1. 定义一个 Employee 类。
 * 该类包含：private 成员变量 name,age,birthday，其中 birthday 为
 * MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 *
 * MyDate 类包含:
 * private 成员变量 year,month,day；并为每一个属性定义 getter, setter
 * 方法；
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：
 * TreeSet 需使用泛型来定义）
 *
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1). 使 Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
 */

/*
 * 未使用泛型
 */

public class TreeSetTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("Jack", 22, new MyDate(2000, 6,9));
        Employee e2 = new Employee("Mary", 48, new MyDate(1974, 7,26));
        Employee e3 = new Employee("Alan", 33, new MyDate(1989, 4,4));
        Employee e4 = new Employee("Smith", 97, new MyDate(1925, 12,31));
        Employee e5 = new Employee("Ashley", 12, new MyDate(2010, 6,6));

        TreeSet treeSet = new TreeSet();
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("*****************");

        TreeSet treeSet1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee employee1 = (Employee) o1;
                    Employee employee2 = (Employee) o2;
                    if (Integer.compare(employee1.getBirthday().getMonth(), employee2.getBirthday().getMonth()) != 0) {
                        return Integer.compare(employee1.getBirthday().getMonth(), employee2.getBirthday().getMonth());
                    } else {
                        return Integer.compare(employee1.getBirthday().getDay(), employee2.getBirthday().getDay());
                    }
                } else {
                    throw new RuntimeException("输入数据类型不匹配！");
                }
            }
        });
        treeSet1.add(e1);
        treeSet1.add(e2);
        treeSet1.add(e3);
        treeSet1.add(e4);
        treeSet1.add(e5);

        Iterator iterator1 = treeSet1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

    }
}

class Employee implements Comparable {
    private int age;
    private String name;
    private MyDate birthday;

    public Employee( String name,int age, MyDate birthday) {
        this.age = age;
        this.name = name;
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee employee = (Employee) o;
            return this.getName().compareTo(employee.getName());
        } else {
            throw new RuntimeException("输入数据类型不匹配！");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday.toString() +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
