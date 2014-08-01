package bitplace.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

public class Bean implements Serializable{
	private static final long serialVersionUID = 1L;
	Integer memno;
	String gitid, email, photo, email_serial;
	
	boolean admin;
	String groupname, title;	
	
	String content_title, content;
	
	Date edited_date;
	int titleno;

	String pageUrl;
	
	
	
	
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public Date getEdited_date() {
		return edited_date;
	}
	public void setEdited_date(Date edited_date) {
		this.edited_date = edited_date;
	}
	public String getContent_title() {
		if(content_title.length()>15){
		this.content_title = content_title.substring(0,15);
		this.content_title+="...";
		}
		return content_title;
	}
	public void setContent_title(String content_title) {
		this.content_title = content_title;
	}
	public String getContent() {
		if(content.length()>15){
		this.content = content.substring(0,15);
		this.content+="...";
		}
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTitleno() {
		return titleno;
	}
	public void setTitleno(int titleno) {
		this.titleno = titleno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public Integer getMemno() {
		return memno;
	}
	public void setMemno(Integer memno) {
		this.memno = memno;
	}
	public String getGitid() {
		return gitid;
	}
	public void setGitid(String gitid) {
		this.gitid = gitid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail_serial() {
		return email_serial;
	}
	public void setEmail_serial(String email_serial) {
		this.email_serial = email_serial;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}	
}