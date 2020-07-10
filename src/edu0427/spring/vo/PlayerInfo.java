package edu0427.spring.vo;

public class PlayerInfo {
	private Integer rowId;
	private Integer pid;
	private Integer overall;
	private Integer age;
	private Integer nid;
	private String photo;
	private String pname;
	private Integer potential;
	private Integer cid;
	private NationInfo nation;
	private ClubInfo club;
	public NationInfo getNation() {
		return nation;
	}

	public void setNation(NationInfo nation) {
		this.nation = nation;
	}

	public ClubInfo getClub() {
		return club;
	}

	public void setClub(ClubInfo clubInfo) {
		this.club = clubInfo;
	}

	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getOverall() {
		return overall;
	}

	public void setOverall(Integer overall) {
		this.overall = overall;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPotential() {
		return potential;
	}

	public void setPotential(Integer potential) {
		this.potential = potential;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
}
