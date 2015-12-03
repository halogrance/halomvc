package cn.springmvc.model;



import java.io.Serializable;

@SuppressWarnings("serial")
public class TblOprInfo implements Serializable {
	
	private String oprId;
	private String oprName;
	private String ownBrhId;
	public String getOprId() {
		return oprId;
	}
	public void setOprId(String oprId) {
		this.oprId = oprId;
	}
	public String getOprName() {
		return oprName;
	}
	public void setOprName(String oprName) {
		this.oprName = oprName;
	}
	public String getOwnBrhId() {
		return ownBrhId;
	}
	public void setOwnBrhId(String ownBrhId) {
		this.ownBrhId = ownBrhId;
	}

	

}