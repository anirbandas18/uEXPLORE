package com.ufl.geoaccessibility.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ConveyancePolygon")
public class ConveyancePolygonEntity {
	
	@Id
	private String id;
	private String mode;
	private Requestor requestor;
	@Field(value = "timeArea")
	private List<TimeArea> timeAreas;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Requestor getRequestor() {
		return requestor;
	}
	public void setRequestor(Requestor requestor) {
		this.requestor = requestor;
	}
	public List<TimeArea> getTimeAreas() {
		return timeAreas;
	}
	public void setTimeAreas(List<TimeArea> timeAreas) {
		this.timeAreas = timeAreas;
	}
	@Override
	public String toString() {
		return "ConveyancePolygonEntity [id=" + id + ", mode=" + mode + ", requestor=" + requestor + ", timeAreas="
				+ timeAreas + "]";
	}
	
}