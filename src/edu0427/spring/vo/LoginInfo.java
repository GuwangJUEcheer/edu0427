package edu0427.spring.vo;

public class LoginInfo {
    //�洢��¼��Ϣ
	private String loginId;
	// ��¼����
	private String password;
	//�Д��Ƿ��䛠�B
	private boolean remember;
	//�û��ǳ�
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