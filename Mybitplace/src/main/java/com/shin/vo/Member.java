package com.shin.vo;

public class Member {

	private	int mno;
	private String email;
	private String pwd;
	private String git_id;
	private	String git_pwd;
	private String name;
	
	
	
	@Override
	public String toString() {
		return "Member [mno=" + mno + ", email=" + email + ", pwd=" + pwd
				+ ", git_id=" + git_id + ", git_pwd=" + git_pwd + ", name="
				+ name + "]";
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGit_id() {
		return git_id;
	}
	public void setGit_id(String git_id) {
		this.git_id = git_id;
	}
	public String getGit_pwd() {
		return git_pwd;
	}
	public void setGit_pwd(String git_pwd) {
		this.git_pwd = git_pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
