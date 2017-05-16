package com.ufl.uexplore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.geojson.LngLatAlt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufl.uexplore.core.ConcaveHull;
import com.ufl.uexplore.core.TransportMode;
import com.ufl.uexplore.dao.GeoJsonDAO;
import com.ufl.uexplore.dto.RequestedLocationDTO;
import com.ufl.uexplore.entity.ConveyancePolygonEntity;
import com.ufl.uexplore.entity.ConveyanceTimeArea;


@SpringBootApplication	
@ComponentScan(basePackages = {"com.ufl.uexplore"})
public class UExploreApplication implements CommandLineRunner {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private GeoJsonDAO dao;
	
	@Autowired
	private ConcaveHull hull;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(UExploreApplication.class);
		app.run(args);
	}
	
	private void dao() throws JsonProcessingException {
		List<LngLatAlt> points = dao.deserialize();
		String listOfPoints[] = new String[points.size()];
		int k = 3, i = 0;
		List<LngLatAlt> hullPoints = hull.calculate(points, k);
		for(LngLatAlt p : hullPoints) {
			if(p != null) {
				String json = objectMapper.writeValueAsString(p);
				listOfPoints[i++] = json;
			}
		}
		System.out.println(Arrays.toString(listOfPoints));
	}
	
	private ConveyancePolygonEntity createEntity() {
		List<ConveyanceTimeArea> timeAreas = new ArrayList<>();
		ConveyanceTimeArea ta = new ConveyanceTimeArea();
		ta.setDuration(15l);
		Map<String,List<LngLatAlt>> destinations = new TreeMap<>();
		List<LngLatAlt> points = new ArrayList<>();
		points.add(new LngLatAlt(77, 28));
		points.add(new LngLatAlt(77, 28));
		points.add(new LngLatAlt(77, 28));
		destinations.put("address", points);
		ta.setDestinations(destinations);
		timeAreas.add(ta);
		ConveyancePolygonEntity ctae = new ConveyancePolygonEntity();
		ctae.setTimeAreas(timeAreas);
		ctae.setMode(TransportMode.DRIVING);
		ctae.setId(UUID.randomUUID().toString());
		return ctae;
	}
	

	@Override
	public void run(String... arg0) throws Exception {
		/*ConveyancePolygonEntity ctae = createEntity(); 
		String id = ctaeDAO.create(ctae);
		ctae = createEntity(); 
		ctaeDAO.create(ctae);
		System.out.println();
		List<ConveyancePolygonEntity> cpes = ctaeDAO.retrieveByRequestor(ctae.getId().getRequestedBy());
		for(ConveyancePolygonEntity cpe : cpes) {
			System.out.println(cpe);
		}*/
		demoDTO();
	}
	
	private void demoDTO() {
		RequestedLocationDTO dto = new RequestedLocationDTO();
		dto.setEmailId("anirbandas18@live.com");
		dto.setMode(TransportMode.DRIVING);
		dto.setTimeStamp(System.currentTimeMillis());
		dto.setLocationCoordinates(new LngLatAlt(77.28,55.23));
		System.out.println(dto);
	}

}
