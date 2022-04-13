package model;

import java.sql.Timestamp;

public class BookAdminDTO {
	
	private String admin_id;
	private String admin_pw;
	private int admin_mile;
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pw() {
		return admin_pw;
	}
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	public int getAdmin_mile() {
		return admin_mile;
	}
	public void setAdmin_mile(int admin_mile) {
		this.admin_mile = admin_mile;
	}
	
	
}
