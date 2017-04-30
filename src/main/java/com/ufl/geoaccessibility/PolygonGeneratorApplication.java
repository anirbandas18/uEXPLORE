package com.ufl.geoaccessibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.geojson.LngLatAlt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufl.geoaccessibility.core.ConcaveHull;
import com.ufl.geoaccessibility.dao.ConveyancePolygonDAO;
import com.ufl.geoaccessibility.dao.GeoJsonDAO;
import com.ufl.geoaccessibility.entity.ConveyancePolygonEntity;
import com.ufl.geoaccessibility.entity.Coordinate;
import com.ufl.geoaccessibility.entity.Destination;
import com.ufl.geoaccessibility.entity.Requestor;
import com.ufl.geoaccessibility.entity.TimeArea;


@SpringBootApplication	
@ComponentScan(basePackages = {"com.ufl.geoaccessibility"})
public class PolygonGeneratorApplication implements CommandLineRunner {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Autowired
	private ConveyancePolygonDAO ctaeDAO;
	
	@Autowired
	private GeoJsonDAO dao;
	
	@Autowired
	private ConcaveHull hull;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PolygonGeneratorApplication.class);
		app.run(args);
	}
	
	private void dao() throws JsonProcessingException {
		List<LngLatAlt> points = dao.deserialize();
		String listOfPoints[] = new String[points.size()];
		int k = 3, i = 0;
		List<LngLatAlt> hullPoints = hull.calculateConcaveHull(points, k);
		for(LngLatAlt p : hullPoints) {
			if(p != null) {
				String json = objectMapper.writeValueAsString(p);
				listOfPoints[i++] = json;
			}
		}
		System.out.println(Arrays.toString(listOfPoints));
	}
	
	private ConveyancePolygonEntity createEntity() {
		Coordinate c = new Coordinate(77d, 28d);
		Destination d1 = new Destination();
		d1.setAddress("address");
		d1.setCoordinates(c);
		List<Destination> destinations = new ArrayList<>();
		destinations.add(d1);
		List<TimeArea> timeAreas = new ArrayList<>();
		TimeArea ta = new TimeArea();
		ta.setDestinations(destinations);
		ta.setDuration(System.currentTimeMillis());
		timeAreas.add(ta);
		Date now = new Date();
		System.out.println(now);
		Requestor re = new Requestor("user@email.com", now);
		Coordinate ce = new Coordinate(77d,28d);
		Destination de = new Destination();
		de.setAddress("address");
		de.setCoordinates(ce);
		ConveyancePolygonEntity ctae = new ConveyancePolygonEntity();
		ctae.setTimeAreas(timeAreas);
		ctae.setMode("driving");
		ctae.setRequestor(re);
		return ctae;
	}
	

	@Override
	public void run(String... arg0) throws Exception {
		ConveyancePolygonEntity ctae = createEntity(); 
		String id = ctaeDAO.create(ctae);
		System.out.println(id);
		System.out.println();
		List<ConveyancePolygonEntity> ctaes = ctaeDAO.retrieveAll();
		for(ConveyancePolygonEntity x : ctaes) {
			System.out.println(x);
		}
	}

}
