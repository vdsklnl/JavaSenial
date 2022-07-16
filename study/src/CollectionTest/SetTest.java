package CollectionTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author vdsklnl
 * @create 2022-04-07 21:01
 * @Description
 * 练习一：在List内去除重复数字值，要求尽量简单（利用set不可重复性）
 * 练习二：面试题
 */



public class SetTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    public static List duplicateList(List list) {
        HashSet hashSet = new HashSet(list);
        return new ArrayList(hashSet);
    }
}

//    HashSet set = new HashSet();
//    Person p1 = new Person(1001,"AA");
//    Person p2 = new Person(1002,"BB");
//    set.add(p1);
//    set.add(p2);
//    p1.name = "CC";
//    set.remove(p1);
// remove需判断对象hash值，p1.name改变后，p1 hash值改变，但存储位置不变
// 因此remove无法找到hash值对应元素，无法移除p1
//    System.out.println(set);                      // "BB" "CC"
//    set.add(new Person(1001,"CC"));
// add后新元素存储位置为其对应hash值位置，通常不会在p1位置，不触发比较，可以存储
//    System.out.println(set);                      // "BB" "CC" "CC"
//    set.add(new Person(1001,"AA"));
// add后新元素存储位置为p1对应hash值位置，触发比较，但二者为不同对象，因此可以存储，链在"CC"之后
//    System.out.println(set);                      // "BB" "CC" "CC" "AA"
//    其中Person类中重写了hashCode()和equal()方法


