package com.ufl.geoaccessibility.service;

import java.util.List;

import org.geojson.LngLatAlt;
import org.springframework.stereotype.Service;

import com.ufl.geoaccessibility.dto.RequestedLocationDTO;

@Service
public interface ConveyancePolygonService {
	
	public List<LngLatAlt> findConveyancePolygonAroundLocation(RequestedLocationDTO location);

}
