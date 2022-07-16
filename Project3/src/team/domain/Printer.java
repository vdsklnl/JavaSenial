package team.domain;

public class Printer implements Equipment {

	private String model;  //机器型号
	private String type;   //机器类型
	
	public Printer() {
		super();
	}

	public Printer(String model, String type) {
		super();
		this.model = model;
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getDescription() {
		return model + "(" + type + ")";
	}
	
	
}
