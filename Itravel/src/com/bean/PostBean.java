package com.bean;


import java.sql.Date;

public class PostBean {
	private int post;
	private Date date_post;
	private String text; 
	private int user;
	private int likes;
	private String state;
	private String city;
	private int zip_code;
	private String image; // AGREGADO DESPUES DE DIEGO
	
	public String getImage() { // AGREGADO DESPUES DE DIEGO
		return image;
	}
	public void setImage(String image) {// AGREGADO DESPUES DE DIEGO
		this.image = image;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	
	
	
}
