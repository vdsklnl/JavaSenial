package Java8.data;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *
 * 二、数组引用
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){

        Supplier<Employee> sup = () -> new Employee();
        System.out.println(sup.get());

        System.out.println("--------------");

        Supplier<Employee> sup1 = Employee::new;
        System.out.println(sup1.get());

    }

	//Function中的R apply(T t)
    @Test
    public void test2(){

        Function<Integer,Employee> func = id -> new Employee(id);
        System.out.println(func.apply(1001));

        System.out.println("--------------");

        Function<Integer,Employee> func1 = Employee::new;
        System.out.println(func1.apply(1002));

    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){

        BiFunction<Integer,String,Employee> func = (id,name) -> new Employee(id,name);
        System.out.println(func.apply(1001,"Tom"));

        System.out.println("--------------");

        BiFunction<Integer,String,Employee> func1 = Employee::new;
        System.out.println(func1.apply(1002,"Jerry"));

    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){

        Function<Integer,String[]> func = length -> new String[length];
        System.out.println(Arrays.toString(func.apply(5)));

        System.out.println("--------------");

        Function<Integer,String[]> func1 = String[]::new;
        System.out.println(Arrays.toString(func1.apply(8)));

    }
}
