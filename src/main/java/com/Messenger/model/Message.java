package com.Messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

public class Message {

	private long id;
	private String message;
	private Date createdDate;
	private String author;
	//every message has comments
	private Map<Long, Comment> comments = new HashMap<>();
	
	public Message() {}
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.createdDate = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	//not display comments when getting messages
	@XmlTransient
	//Ignore comments when accessing messages only for xml
	public Map<Long, Comment> getComments(){
		return comments;
	}
	
	public void setComments() {
		this.comments = comments;
	}
	
}
