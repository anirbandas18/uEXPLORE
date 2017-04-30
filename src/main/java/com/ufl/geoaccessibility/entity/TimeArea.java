package com.ufl.geoaccessibility.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class TimeArea {

	private Long duration;
	@Field(value = "destination")
	private List<Destination> destinations;
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public List<Destination> getDestinations() {
		return destinations;
	}
	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}
	public TimeArea(Long duration, List<Destination> destinations) {
		super();
		this.duration = duration;
		this.destinations = destinations;
	}
	public TimeArea() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TimeArea [duration=" + duration + ", destination=" + destinations + "]";
	}

}
