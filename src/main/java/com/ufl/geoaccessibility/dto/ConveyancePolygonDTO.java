package com.ufl.geoaccessibility.dto;

import java.util.Date;

import org.springframework.data.geo.Point;

public class ConveyancePolygonDTO {

	private String mode;
	
	private String emailId;
	
	private Date timeStamp;
	
	private Point locationCoordinates;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Point getLocationCoordinates() {
		return locationCoordinates;
	}

	public void setLocationCoordinates(Point locationCoordinates) {
		this.locationCoordinates = locationCoordinates;
	}

	@Override
	public String toString() {
		return "ConveyancePolygonDTO [mode=" + mode + ", emailId=" + emailId + ", timeStamp=" + timeStamp
				+ ", locationCoordinates=" + locationCoordinates + "]";
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
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
		ConveyancePolygonDTO other = (ConveyancePolygonDTO) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}
	
	
	
}
