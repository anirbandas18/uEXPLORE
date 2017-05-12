package com.ufl.geoaccessibility.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
public class ConveyancePolygonCompoundId implements Serializable{

	private String requestedBy;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date requestedAt;
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public Date getRequestedAt() {
		return requestedAt;
	}
	public void setRequestedAt(Date requestedAt) {
		this.requestedAt = requestedAt;
	}
	@Override
	public String toString() {
		return "ConveyancePolygonCompoundId [requestedBy=" + requestedBy + ", requestedAt=" + requestedAt + "]";
	}
	public ConveyancePolygonCompoundId(String requestedBy, Date requestedAt) {
		super();
		this.requestedBy = requestedBy;
		this.requestedAt = requestedAt;
	}
	public ConveyancePolygonCompoundId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
