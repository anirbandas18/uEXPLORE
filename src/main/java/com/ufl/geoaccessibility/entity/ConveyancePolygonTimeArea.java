package com.ufl.geoaccessibility.entity;

import java.util.List;
import java.util.Map;

import org.springframework.data.geo.Point;



public class ConveyancePolygonTimeArea {

	private Long duration;
	private Map<String,List<Point>> destinations;
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Map<String, List<Point>> getDestinations() {
		return destinations;
	}
	public void setDestinations(Map<String, List<Point>> destinations) {
		this.destinations = destinations;
	}
	@Override
	public String toString() {
		return "ConveyancePolygonTimeArea [duration=" + duration + ", destinations=" + destinations + "]";
	}

}
