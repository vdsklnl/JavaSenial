package team.junit;

import org.junit.Test;

import team.domain.Employee;
import team.service.NameListService;
import team.service.TeamException;

/**
 * 
 * @Description  对NameListServiceTest类测试
 * @author vdsklnl	Email:vdsklnl@qq.com
 * @version
 * @date 2022年4月20日下午6:58:21
 *
 */

public class NameListServiceTest {
	
	@Test
	public void testGetAllEmployees() {
		NameListService test = new NameListService();
		Employee[] employees = test.getAllEmployee();
		for(int i = 0;i < employees.length;i++) {
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee() {
		NameListService test = new NameListService();
		int id;
		id = 101;
		try {
			Employee employee = test.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
