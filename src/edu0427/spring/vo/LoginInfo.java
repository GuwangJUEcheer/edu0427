package edu0427.spring.vo;

public class LoginInfo {
    //´æ´¢µÇÂ¼ÐÅÏ¢
	private String loginId;
	// µÇÂ¼ÃÜÂë
	private String password;
	//ÅÐ”àÊÇ·ñµÇä› î‘B
	private boolean remember;
	//ÓÃ»§êÇ³Æ
	private String username;
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
