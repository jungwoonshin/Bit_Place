package com.shin.vo;

import java.util.Date;

public class Content {
	private int content_no;
	private Date edited_date;
	private int mno;
	private int participants;
	private char open_or_close;
	private int validation;
	private int locker;
	private int title_no;
	private char open_to;
	private String content_title;
	private int count;
	private Date edited_date_f;
	private Date edited_date_l;
	private String content;
	private int group_no;
	private String git_repository;
	private String git_id;
	private String git_pwd;
	private String git_oauthtoken;
	public int getContent_no() {
		return content_no;
	}
	public void setContent_no(int content_no) {
		this.content_no = content_no;
	}
	public Date getEdited_date() {
		return edited_date;
	}
	public void setEdited_date(Date edited_date) {
		this.edited_date = edited_date;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getParticipants() {
		return participants;
	}
	public void setParticipants(int participants) {
		this.participants = participants;
	}
	public char getOpen_or_close() {
		return open_or_close;
	}
	public void setOpen_or_close(char open_or_close) {
		this.open_or_close = open_or_close;
	}
	public int getValidation() {
		return validation;
	}
	public void setValidation(int validation) {
		this.validation = validation;
	}
	public int getLocker() {
		return locker;
	}
	public void setLocker(int locker) {
		this.locker = locker;
	}
	public int getTitle_no() {
		return title_no;
	}
	public void setTitle_no(int title_no) {
		this.title_no = title_no;
	}
	public char getOpen_to() {
		return open_to;
	}
	public void setOpen_to(char open_to) {
		this.open_to = open_to;
	}
	public String getContent_title() {
		return content_title;
	}
	public void setContent_title(String content_title) {
		this.content_title = content_title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getEdited_date_f() {
		return edited_date_f;
	}
	public void setEdited_date_f(Date edited_date_f) {
		this.edited_date_f = edited_date_f;
	}
	public Date getEdited_date_l() {
		return edited_date_l;
	}
	public void setEdited_date_l(Date edited_date_l) {
		this.edited_date_l = edited_date_l;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}
	public String getGit_repository() {
		return git_repository;
	}
	public void setGit_repository(String git_repository) {
		this.git_repository = git_repository;
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
	public String getGit_oauthtoken() {
		return git_oauthtoken;
	}
	public void setGit_oauthtoken(String git_oauthtoken) {
		this.git_oauthtoken = git_oauthtoken;
	}
	@Override
	public String toString() {
		return "Content [content_no=" + content_no + ", edited_date="
				+ edited_date + ", mno=" + mno + ", participants="
				+ participants + ", open_or_close=" + open_or_close
				+ ", validation=" + validation + ", locker=" + locker
				+ ", title_no=" + title_no + ", open_to=" + open_to
				+ ", content_title=" + content_title + ", count=" + count
				+ ", edited_date_f=" + edited_date_f + ", edited_date_l="
				+ edited_date_l + ", content=" + content + ", group_no="
				+ group_no + ", git_repository=" + git_repository + ", git_id="
				+ git_id + ", git_pwd=" + git_pwd + ", git_oauthtoken="
				+ git_oauthtoken + "]";
	}
	
	

}

