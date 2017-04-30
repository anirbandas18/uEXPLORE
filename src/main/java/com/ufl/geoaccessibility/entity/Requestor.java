package com.ufl.geoaccessibility.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Requestor {

	private String id;
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private Date timestamp;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Requestor [id=" + id + ", timestamp=" + timestamp + "]";
	}
	public Requestor(String id, Date timestamp) {
		super();
		this.id = id;
		this.timestamp = timestamp;
	}
	public Requestor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
