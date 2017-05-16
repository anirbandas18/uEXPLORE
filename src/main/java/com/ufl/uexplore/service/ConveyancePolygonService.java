package com.ufl.uexplore.service;

import java.util.List;

import org.geojson.LngLatAlt;
import org.springframework.stereotype.Service;

import com.ufl.uexplore.dto.RequestedLocationDTO;

@Service
public interface ConveyancePolygonService {
	
	public List<LngLatAlt> findConveyancePolygonAroundLocation(RequestedLocationDTO location);

}
