package Java8.data;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

/**
 * 方法引用的使用
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {

		Consumer<String> con = s -> System.out.println(s);
		con.accept("hhh");
		System.out.println("--------------");
		Consumer<String> con1 = System.out::println;
		con1.accept("HHH");
		
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {

		Employee employee = new Employee(1111,"Tom",23,4444);
		Supplier<String> sup = () -> employee.getName();
		System.out.println(sup.get());

		System.out.println("--------------");

		Supplier<String> sup1 = employee::getName;
		System.out.println(sup1.get());

	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {

		Comparator<Integer> com = (t1,t2) -> t1.compareTo(t2);
		System.out.println(com.compare(12,4));

		System.out.println("--------------");

		Comparator<Integer> com1 = Integer::compareTo;
		System.out.println(com1.compare(12,14));

	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {

		Function<Double,Long> func = d -> Math.round(d);
		System.out.println(func.apply(12.3));

		System.out.println("--------------");

		Function<Double,Long> func1 = Math::round;
		System.out.println(func1.apply(12.6));

	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {

		Comparator<String> com = (t1,t2) -> t1.compareTo(t2);
		System.out.println(com.compare("abc","abd"));

		System.out.println("--------------");

		Comparator<String> com1 = String::compareTo;
		System.out.println(com1.compare("abc","abm"));

	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {

		BiPredicate<String,String> bi = (t1, t2) -> t1.equals(t2);
		System.out.println(bi.test("abc","abc"));

		System.out.println("--------------");

		BiPredicate<String,String> bi1 = String::equals;
		System.out.println(bi1.test("abc","abd"));

	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {

		Employee emp = new Employee(1001,"Tom",33,5545);
		Function<Employee,String> func = e -> e.getName();
		System.out.println(func.apply(emp));

		System.out.println("--------------");

		Function<Employee,String> func1 = Employee::getName;
		System.out.println(func1.apply(emp));

	}

}
