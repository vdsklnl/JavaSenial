package team.domain;

import team.service.Status;

public class Programmer extends Employee {

	private int memberId;  //开发团队ID
	//默认赋值
	private Status status = Status.FREE;  //成员状态
    private Equipment equipment;
    
	public Programmer(int id, String name, int age, double salary,Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public Programmer() {
		super();
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	@Override
	public String toString() {
		return getDetails() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}
	
	public String detailsForTeam() {
		return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + 
				getAge() + "\t" + getSalary();
	}
	
	public String getDetailsForTeam() {
		return detailsForTeam() + "\t程序员";
	}
	
}
