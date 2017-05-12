package com.ufl.geoaccessibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.geojson.LngLatAlt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.geo.Point;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufl.geoaccessibility.core.ConcaveHull;
import com.ufl.geoaccessibility.dao.ConveyancePolygonDAO;
import com.ufl.geoaccessibility.dao.DemoDAO;
import com.ufl.geoaccessibility.dao.GeoJsonDAO;
import com.ufl.geoaccessibility.entity.ConveyancePolygonCompoundId;
import com.ufl.geoaccessibility.entity.ConveyancePolygonEntity;
import com.ufl.geoaccessibility.entity.ConveyancePolygonTimeArea;
import com.ufl.geoaccessibility.entity.DemoEntity;


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
	private DemoDAO demoDAO;
	
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
	
	private void demoDAOTest() {
		DemoEntity de = new DemoEntity();
		Map<String,String> map1 = new TreeMap<>();
		Map<String,List<Date>> map2 = new TreeMap<>();
		map1.put("a", "apple");
		map1.put("b", "bat");
		map1.put("c", "cat");
		List<Date> dates = new ArrayList<>();
		for(int i = 0 ; i < 3 ; i++) {
			dates.add(new Date());
		}
		map2.put("dates", dates);
		de.setMap1(map1);
		de.setMap2(map2);
		demoDAO.insert(de);
		
		List<DemoEntity> des = demoDAO.retrieveAll();
		for(DemoEntity x : des) {
			System.out.println(x);
		}
	}
	
	private ConveyancePolygonEntity createEntity() {
		List<ConveyancePolygonTimeArea> timeAreas = new ArrayList<>();
		ConveyancePolygonTimeArea ta = new ConveyancePolygonTimeArea();
		ta.setDuration(15l);
		Map<String,List<Point>> destinations = new TreeMap<>();
		List<Point> points = new ArrayList<>();
		points.add(new Point(77, 28));
		points.add(new Point(77, 28));
		points.add(new Point(77, 28));
		destinations.put("address", points);
		ta.setDestinations(destinations);
		timeAreas.add(ta);
		ConveyancePolygonEntity ctae = new ConveyancePolygonEntity();
		ctae.setTimeAreas(timeAreas);
		ctae.setMode("driving");
		ConveyancePolygonCompoundId id = new ConveyancePolygonCompoundId();
		id.setRequestedBy("abc@domain.com");
		id.setRequestedAt(new Date());
		ctae.setId(id);
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
		demoDAOTest();
	}

}
