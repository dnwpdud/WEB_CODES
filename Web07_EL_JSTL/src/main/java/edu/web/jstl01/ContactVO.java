package edu.web.jstl01;

public class ContactVO {
	
	private String neme;
	private String phone;
	private String email;
	public ContactVO() {}
	public ContactVO(String neme, String phone, String email) {
		this.neme = neme;
		this.phone = phone;
		this.email = email;
	}
	
	public String getNeme() {
		return neme;
	}
	public void setNeme(String neme) {
		this.neme = neme;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "ContactVO [neme=" + neme + ", phone=" + phone + ", email=" + email + "]";
	}
	
}


