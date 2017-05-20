package com.bean;


import java.sql.Date;

public class PostBean {
	private int post;
	private Date date_post;
	private String text; 
	private int user;
	private String location;
	private int likes;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public Date getDate_post() {
		return date_post;
	}
	public void setDate_post(Date date_post) {
		this.date_post = date_post;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
}
