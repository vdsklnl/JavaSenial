package team.service;

import team.domain.Architect;
import team.domain.Designer;
import team.domain.Employee;
import team.domain.Programmer;

/**
 * 
 * @Description  功能：关于开发团队成员的管理：添加、删除等。
 * @author vdsklnl	Email:vdsklnl@qq.com
 * @version
 * @date 2022年4月20日下午7:46:37
 *
 */

public class TeamService {
	
	/*
	 * counter为静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
	 * MAX_MEMBER：表示开发团队最大成员数
	 * team数组：用来保存当前团队中的各成员对象 
	 * total：记录团队成员的实际人数
	 */
	
	private static int counter = 1;
	private final int MAX_MEMBER = 5;
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total = 0;
	
	public TeamService() {
		super();
	}

	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i = 0;i < team.length;i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	
	public void addMember(Employee e) throws TeamException {
		if(total >= MAX_MEMBER) {
			throw new TeamException("开发团队成员已满，无法添加！");
		}
		
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加！");
		}
		
		if(isExist(e)) {
			throw new TeamException("该成员已在开发团队内，无法添加！");
		}
		
		Programmer p = (Programmer)e;
		//减少空指针异常风险
//		if("BUSY".equals(p.getStatus().getNAME())) {
//			throw new TeamException("该成员已在其它开发团队中，无法添加！");
//		} else if("VOCATION".equals(p.getStatus().getNAME())) {
//			throw new TeamException("该成员正在休假中，无法添加！");
//		} else {
//			p.getStatus();
//		}
		switch(p.getStatus()){
			case BUSY:
				throw new TeamException("该成员已在其它开发团队中，无法添加！");
			case VOCATION:
				throw new TeamException("该成员正在休假中，无法添加！");
		}
		
		//获取团队中架构师、设计师、程序员人数
		int numOfArch = 0,numOfDes = 0,numOfPro = 0;
		for(int i = 0;i < total;i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			} else if(team[i] instanceof Designer) {
				numOfDes++;
			} else {
				numOfPro++;
			}
		}
		
		//嵌套写正确，否则可能信息报错
		if(p instanceof Architect) {
			if(numOfArch >= 1) {
				throw new TeamException("开发团队只能有一位架构师！");
			}
		} else if(p instanceof Designer) {
			if(numOfDes >= 2) {
				throw new TeamException("开发团队只能有两位设计师！");
			}
		} else {
			if(numOfPro >= 3) {
				throw new TeamException("开发团队只能有三位程序员！");
			}
		}
		
		//将p添加到团队中
		team[total++] = p;
		//更改属性
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
		
	}

	//判断指定员工是否在团队中
	private boolean isExist(Employee e) {
		for(int i = 0;i < total;) {
			return team[i].getId() == e.getId();
		}
		return false;
	}

	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for(;i < total;i++) {
			if(team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		//未找到指定成员
		if(i == total) {
			throw new TeamException("找不到指定memberId成员。");
		}
		//后一元素覆盖前一元素
		for(int j = i + 1;j < total;j++) {
			team[j - 1] = team[j];
		}
		team[--total] = null;
		
	}

}
