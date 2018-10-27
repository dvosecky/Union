package com.revature.messages;

import java.sql.Timestamp;

public class Message {
	private Integer author;
	private String content;
	private Timestamp origin;
	private Character delimiter;
	
	public Character getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(Character delimiter) {
		this.delimiter = delimiter;
	}
	public Integer getAuthor() {
		return author;
	}
	public void setAuthor(Integer author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getOrigin() {
		return origin;
	}
	public void setOrigin(Timestamp origin) {
		this.origin = origin;
	}
	@Override
	public String toString() {
		return "" + author + delimiter + origin.toString() + delimiter + content;
	}
	public Message() {
		author = null;
		content = "";
		origin = new Timestamp(0);
		origin.setTime(System.currentTimeMillis());
		delimiter = null;
	}
	public Message(Integer author, String content, Timestamp origin, Character delimiter) {
		super();
		this.author = author;
		this.content = content;
		this.origin = origin;
		this.delimiter = delimiter;
	}
}
