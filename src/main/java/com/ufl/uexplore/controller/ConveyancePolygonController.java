package com.ufl.uexplore.controller;

import java.util.List;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.LngLatAlt;
import org.geojson.Point;
import org.geojson.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufl.uexplore.core.TransportMode;
import com.ufl.uexplore.dto.RequestedLocationDTO;
import com.ufl.uexplore.service.ConveyancePolygonService;

@RestController
@RequestMapping("/{emailId}/conveyancePolygon")
public class ConveyancePolygonController {

	@Autowired
	private ConveyancePolygonService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/{mode}")
	public FeatureCollection getConveyancePolygon(@PathVariable String emailId, @RequestBody Feature locationPoint, @PathVariable TransportMode mode) {
		Long timeStamp = System.currentTimeMillis();
		// Add validation for point type geometry
		Point point = (Point) locationPoint.getGeometry();
		RequestedLocationDTO location = new RequestedLocationDTO();
		location.setEmailId(emailId);
		location.setMode(mode);
		location.setTimeStamp(timeStamp);
		location.setLocationCoordinates(point.getCoordinates());
		List<LngLatAlt> concaveHullPoints = service.findConveyancePolygonAroundLocation(location);
		Polygon polygon = new Polygon();
		polygon.add(concaveHullPoints);
		Feature feature = new Feature();
		feature.setGeometry(polygon);
		FeatureCollection featureCollection = new FeatureCollection();
		featureCollection.add(feature);
		return featureCollection;
	}

}
