package edu.web.homework;

import java.util.Arrays;

public class MemberVO {
	// 주의) useBean을 위한 VO를 생성할 경우, parameter name과 변수명이 같아야 함
	private String userId;
	private String password;
	private String email;
	private String emailAgree;
	private String[] interest;
	private String phone;
	private String introduce;
	
	public MemberVO() {
		System.out.println("MemberVO 생성자 성공");
	}
	
	public MemberVO(String userId, String password, String email, String emailAgree, String[] interest, String phone,
			String introduce) {
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.emailAgree = emailAgree;
		this.interest = interest;
		this.phone = phone;
		this.introduce = introduce;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailAgree() {
		return emailAgree;
	}
	public void setEmailAgree(String emailAgree) {
		this.emailAgree = emailAgree;
	}
	public String[] getInterest() {
		return interest;
	}
	
	public String getInterestJoin() {
		String interest = null;
		if(getInterest() == null){
			interest = "";
		} else {
			interest = String.join(", ", getInterest());
		}
		return interest;
	}
	
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", password=" + password + ", email=" + email + ", emailAgree="
				+ emailAgree + ", interest=" + Arrays.toString(interest) + ", phone=" + phone + ", introduce="
				+ introduce + "]";
	}

	
}// end MemberVO
