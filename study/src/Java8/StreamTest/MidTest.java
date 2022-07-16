package Java8.StreamTest;

import Java8.data.Employee;
import Java8.data.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author vdsklnl
 * @create 2022-04-28 11:11
 * @Description  Stream中间操作
 */

public class MidTest {

    @Test
    public void test1() {

        List<Employee> employees = EmployeeData.getEmployees();
        // 映射
        // 获取员工姓名长度大于3的员工姓名
//        Stream<String> namesStream = employees.stream().map(e -> e.getName());
        Stream<String> namesStream = employees.stream().map(Employee::getName);
        namesStream.filter(name -> name.length() > 3).forEach(System.out::println);

    }

    @Test
    public void test2() {

        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        // 使用map
        // 输出大写字符串
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        // 使用map
        // 需要双重嵌套foreach才能遍历所有元素
        Stream<Stream<Character>> streamStream = list.stream().map(MidTest::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));

        // 使用flatMap
        // 单层foreach即可遍历所有元素
        Stream<Character> stream = list.stream().flatMap(MidTest::fromStringToStream);
        stream.forEach(System.out::println);

    }

    // 将多字符串构成集合转换为Stream实例
    public static Stream<Character> fromStringToStream(String str) {

        ArrayList<Character> list = new ArrayList<>();
        for (Character c:str.toCharArray()) {
            list.add(c);
        }
        return list.stream();

    }

    // 排序
    @Test
    public void test3() {

        // sorted自然排序
        List<Integer> list = Arrays.asList(12, 44, 13, 5, 73, -54, 0);
        list.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com)定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->{
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0) {
                return ageValue;
            } else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);

    }

}
