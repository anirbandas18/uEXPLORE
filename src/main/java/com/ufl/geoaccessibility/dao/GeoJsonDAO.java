package com.ufl.geoaccessibility.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeoJsonObject;
import org.geojson.LngLatAlt;
import org.geojson.Point;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class GeoJsonDAO {

	@Value(value = "classpath:pyshp-shp_ready_25.json")
	private Resource resource;

	
	public List<LngLatAlt> deserialize() {
		List<LngLatAlt> points = new ArrayList<>();
		try {
			InputStream inputStream = resource.getInputStream();
			ObjectMapper mapper = new ObjectMapper();
			FeatureCollection featureCollection = mapper.readValue(inputStream, FeatureCollection.class);
			for (Feature feature : featureCollection.getFeatures()) {
				GeoJsonObject geometry = feature.getGeometry();
				if(geometry instanceof Point) {
					Point point = (Point) geometry;
					LngLatAlt coordinates = point.getCoordinates();
					//System.out.println(coordinates);
					points.add(coordinates);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return points;
	}

}
