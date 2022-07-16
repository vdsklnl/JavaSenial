package Java8.StreamTest;

import Java8.data.Employee;
import Java8.data.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author vdsklnl
 * @create 2022-04-27 17:24
 * @Description
 */

public class StreamTest {

    @Test
    public void test1() {

        List<Employee> employees = EmployeeData.getEmployees();

        // 返回顺序流
        Stream<Employee> stream = employees.stream();
        // 过滤
        stream.filter(e -> e.getSalary() < 7000).forEach(System.out::println);
        System.out.println("-------------------------------------");
        // 截断
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println("-------------------------------------");
        // 跳过
        employees.stream().skip(5).forEach(System.out::println);
        System.out.println("-------------------------------------");
        // 去重
        employees.add(new Employee(1010,"张一鸣",40,9000.0));
        employees.add(new Employee(1010,"张一鸣",40,9000.0));
        employees.add(new Employee(1010,"张一鸣",40,9000.0));
        employees.stream().distinct().forEach(System.out::println);
        System.out.println("-------------------------------------");

        // 返回并行流
//        Stream<Employee> parallelStream = employees.parallelStream();

    }

    @Test
    public void test2() {

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] es = new Employee[]{e1,e2};

        Stream<Employee> stream = Arrays.stream(es);

    }

    @Test
    public void test3() {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

    }

    @Test
    public void test4() {

        // 遍历前十个偶数
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);

    }

    @Test
    public void test5() {

        // 输出十个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

}
