package org.bhupinder.zversal.messenger.model;


import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType
public class Message {
     
	private long id;
	private String message;
	private int created;
	private String author;
	
	public Message() {}
	
	public Message(long id, String message,  String author) {
		this.id = id;
		this.message = message;
		this.created =2;
		this.author = author;
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
	public  Integer getCreated() {
		return created;
	}
	public void setCreated(Integer created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}

