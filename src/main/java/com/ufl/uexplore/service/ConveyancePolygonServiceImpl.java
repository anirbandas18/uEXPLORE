package com.ufl.uexplore.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.geojson.LngLatAlt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.ufl.uexplore.core.ConcaveHull;
import com.ufl.uexplore.dto.RequestedLocationDTO;
import com.ufl.uexplore.entity.ConveyancePolygonEntity;
import com.ufl.uexplore.entity.ConveyanceTimeArea;

@Component
public class ConveyancePolygonServiceImpl implements ConveyancePolygonService {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private ConcaveHull concaveHull;

	@Value("${jms.queue.name}")
	private String destinationName;
	
	@Value("${concave.hull.neighbours}")
	private Integer k;

	@Override
	public List<LngLatAlt> findConveyancePolygonAroundLocation(RequestedLocationDTO location) {
		// TODO Auto-generated method stub
		jmsTemplate.convertAndSend(destinationName, location);
		ConveyancePolygonEntity polygonEntity = (ConveyancePolygonEntity) jmsTemplate.receiveAndConvert(destinationName);
		List<ConveyanceTimeArea> timeAreas = polygonEntity.getTimeAreas();
		ConcurrentLinkedQueue<LngLatAlt> pointArrayList = new ConcurrentLinkedQueue<LngLatAlt>();
		for(ConveyanceTimeArea ctae : timeAreas) {
			Map<String, List<LngLatAlt>> destinations = ctae.getDestinations();
			int nThreads = destinations.size();
			ExecutorService exec = Executors.newFixedThreadPool(nThreads);
			for(List<LngLatAlt> points : destinations.values()) {
				exec.submit(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						pointArrayList.addAll(points);
					}
					
				});
			}
			exec.shutdown();
		}
		List<LngLatAlt> points = concaveHull.calculate(pointArrayList, k);
		return points;
	}

}
