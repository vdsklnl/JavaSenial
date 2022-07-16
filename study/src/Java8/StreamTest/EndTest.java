package Java8.StreamTest;

import Java8.data.Employee;
import Java8.data.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author vdsklnl
 * @create 2022-04-28 12:56
 * @Description  Stream终止操作测试
 */

public class EndTest {

    //匹配与查找
    @Test
    public void test1() {

        // allMatch(Predicate p)
        List<Employee> employees = EmployeeData.getEmployees();
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        // anyMatch(Predicate p)
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

        // noneMatch(Predicate p)
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        // findFirst()
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        // findAny()
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);

    }

    @Test
    public void test2() {

        List<Employee> employees = EmployeeData.getEmployees();
        // count()
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        // max(Comparator c)
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = doubleStream.max(Double::compare);
        System.out.println(max);

        // min(Comparator c)
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

        // forEach(Consumer c)
        employees.stream().forEach(System.out::println);

        // 集合
        employees.forEach(System.out::println);

    }

    // 归约
    @Test
    public void test3() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // identity为初始值，后面接BiFunction(T T T)
        Integer integer = list.stream().reduce(0, Integer::sum);
        System.out.println(integer);

        List<Employee> employees = EmployeeData.getEmployees();
//        Optional<Double> aDouble = employees.stream().map(e -> e.getSalary()).reduce(Double::sum);
        Optional<Double> aDouble = employees.stream().map(e -> e.getSalary()).reduce((d1,d2) -> d1 + d2);
        System.out.println(aDouble);

    }

    // 收集
    @Test
    public void test4() {

        // collect(Collector c)
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println();

        Set<Employee> set = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        set.forEach(System.out::println);

    }

}
