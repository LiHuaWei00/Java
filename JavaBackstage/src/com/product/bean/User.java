package com.product.bean;

public class User {
	public static final int PAGE_SIZE=12; 
	private String uid;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	private String uname;
	private String upass;
	private String uphone;
	private String ue_mail;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUe_mail() {
		return ue_mail;
	}
	public void setUe_mail(String ue_mail) {
		this.ue_mail = ue_mail;
	}
}
