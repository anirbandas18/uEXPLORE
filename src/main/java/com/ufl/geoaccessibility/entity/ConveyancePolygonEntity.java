package com.ufl.geoaccessibility.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ufl.geoaccessibility.core.TransportMode;

@CompoundIndex(name = "id", def = "{'id.requestedBy' : 1, 'id.requestedAt' : -1}", unique = true, sparse = true)
@Document(collection = "ConveyancePolygon")
public class ConveyancePolygonEntity {

	@Id
	private String id;
	private TransportMode mode;
	@Field(value = "timeArea")
	private List<ConveyanceTimeArea> timeAreas;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TransportMode getMode() {
		return mode;
	}
	public void setMode(TransportMode mode) {
		this.mode = mode;
	}
	public List<ConveyanceTimeArea> getTimeAreas() {
		return timeAreas;
	}
	public void setTimeAreas(List<ConveyanceTimeArea> timeAreas) {
		this.timeAreas = timeAreas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConveyancePolygonEntity other = (ConveyancePolygonEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ConveyancePolygonEntity [id=" + id + ", mode=" + mode + ", timeAreas=" + timeAreas + "]";
	}

	

}