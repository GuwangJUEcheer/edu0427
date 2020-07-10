package edu0427.spring.vo;

public class ClubInfo {
private Integer cid;
private String cname;
private String Logo;
public ClubInfo(Integer cid, String cname, String Logo) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.Logo = Logo;
}
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getLogo() {
	return Logo;
}
public void setLog(String Logo) {
	this.Logo = Logo;
}
}
