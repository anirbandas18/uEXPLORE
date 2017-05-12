package com.ufl.geoaccessibility.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@CompoundIndex(name = "id", def = "{'id.requestedBy' : 1, 'id.requestedAt' : -1}", unique = true, sparse = true)
@Document(collection = "ConveyancePolygon")
public class ConveyancePolygonEntity {

	@Id
	private ConveyancePolygonCompoundId id;
	private String mode;
	@Field(value = "timeArea")
	private List<ConveyancePolygonTimeArea> timeAreas;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public ConveyancePolygonCompoundId getId() {
		return id;
	}

	public void setId(ConveyancePolygonCompoundId id) {
		this.id = id;
	}

	public List<ConveyancePolygonTimeArea> getTimeAreas() {
		return timeAreas;
	}

	public void setTimeAreas(List<ConveyancePolygonTimeArea> timeAreas) {
		this.timeAreas = timeAreas;
	}

	@Override
	public String toString() {
		return "ConveyancePolygonEntity [id=" + id + ", mode=" + mode + ", timeAreas=" + timeAreas + "]";
	}

}