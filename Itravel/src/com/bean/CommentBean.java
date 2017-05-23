package com.bean;

import java.sql.Date;


public class CommentBean {
private int id_comment;
private int post;
private RegisterBean id_user;
private String comment;
private Date date_comment;

public int getId_comment() {
	return id_comment;
}
public void setId_comment(int id_comment) {
	this.id_comment = id_comment;
}
public int getPost() {
	return post;
}
public void setPost(int id_post) {
	this.post = id_post;
}
public RegisterBean getId_user() {
	return id_user;
}
public void setId_user(RegisterBean id_user) {
	this.id_user = id_user;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public Date getDate_comment() {
	return date_comment;
}
public void setDate_comment(Date date_comment) {
	this.date_comment = date_comment;
}


}
