package com.tarena.entity.page;

public class AccountPage extends Page{
	private String idcard_no;
	private String real_name;
	private String login_name;
	private String status;
	public String getIdcard_no() {
		return idcard_no;
	}
	public void setIdcard_no(String idcard_no) {
		this.idcard_no = idcard_no;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
