package team.service;

// 引入Data下所有静态结构，可在下方直接调用
import static team.service.Data.ARCHITECT;
import static team.service.Data.DESIGNER;
import static team.service.Data.EMPLOYEE;
import static team.service.Data.EMPLOYEES;
import static team.service.Data.EQUIPMENTS;
import static team.service.Data.NOTEBOOK;
import static team.service.Data.PC;
import static team.service.Data.PRINTER;
import static team.service.Data.PROGRAMMER;

import team.domain.Architect;
import team.domain.Designer;
import team.domain.Employee;
import team.domain.Equipment;
import team.domain.NoteBook;
import team.domain.PC;
import team.domain.Printer;
import team.domain.Programmer;

/**
 * 
 * @Description 负责将Data中的数据封装到Employee[]数组中，
 * 				同时提供相关操作Employee[]的方法
 * @author vdsklnl	Email:vdsklnl@qq.com
 * @version
 * @date 2022年4月20日下午4:11:18
 *
 */

public class NameListService {

	private Employee[] employees;

	/*
	 * 给employees及数组元素初始化
	 */
	
	public NameListService() {
//		根据项目提供的Data类构建相应大小的employees数组
//		再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
//		将对象存于数组中
		employees = new Employee[EMPLOYEES.length];
		for(int i = 0;i < employees.length;i++) {
			//获取员工类型
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			//获取员工基本信息,全部员工均含有
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			//防止员工无设备，先声明后处理，更加方便
			Equipment equipment;
			double bonus;
			int stock;
			
			switch(type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}
	
	//获取指定位置员工设备
	private Equipment createEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);
		switch(type) {
		case PC:
			return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		case NOTEBOOK:
			return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));
		case PRINTER:
			return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		}
		return null;
	}

	public Employee[] getAllEmployee() {
		return employees;
	}
	
	public Employee getEmployee(int id) throws TeamException {
		for(int i = 0;i < employees.length;i++) {
			//如果是对象，需要调用equals
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工！");
	}
	
}
