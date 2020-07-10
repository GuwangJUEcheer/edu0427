package edu0427.spring.vo;

public class NationInfo {
	private Integer nid;
	private String nation;
	private String flag;
	public NationInfo(Integer nid, String nation, String flag) {
		super();
		this.nid = nid;
		this.nation = nation;
		this.flag = flag;
	}
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

}
