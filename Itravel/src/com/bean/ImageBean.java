package com.bean;

import java.io.InputStream;



public class ImageBean {
	private int post;
	private int id_image;
	private InputStream image;
	private String imageString ;
	
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	
	public String getImageString() {
		return imageString;
	}
	public void setImageString(String imageString) {
		this.imageString = imageString;
	}
	public int getId_image() {
		return id_image;
	}
	public void setId_image(int id_image) {
		this.id_image = id_image;
	}
	
	
}
