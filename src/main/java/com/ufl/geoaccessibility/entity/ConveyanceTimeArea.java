package com.ufl.geoaccessibility.entity;

import java.util.List;
import java.util.Map;

import org.geojson.LngLatAlt;



public class ConveyanceTimeArea {

	private Long duration;
	private Map<String,List<LngLatAlt>> destinations;
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Map<String, List<LngLatAlt>> getDestinations() {
		return destinations;
	}
	public void setDestinations(Map<String, List<LngLatAlt>> destinations) {
		this.destinations = destinations;
	}
	@Override
	public String toString() {
		return "ConveyancePolygonTimeArea [duration=" + duration + ", destinations=" + destinations + "]";
	}
	
}
