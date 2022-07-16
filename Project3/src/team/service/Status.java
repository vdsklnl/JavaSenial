package team.service;

/**
 * @Description  开发成员状态
 * @author vdsklnl	Email:vdsklnl@qq.com
 * @version
 * @date 2022年4月20日下午3:46:43
 *
 */

//public class Status {
//
//	private final String NAME;
//
//	public Status(String name) {
//		super();
//		this.NAME = name;
//	}
//
//	//创建三个可被直接调用不改变对象
//	public static final Status FREE = new Status("FREE");
//	public static final Status BUSY = new Status("BUSY");
//	public static final Status VOCATION = new Status("VOCATION");
//
//	public String getNAME() {
//		return NAME;
//	}
//
//	@Override
//	public String toString() {
//		return NAME;
//	}
//
//}

public enum Status {
	FREE,BUSY,VOCATION;
}
