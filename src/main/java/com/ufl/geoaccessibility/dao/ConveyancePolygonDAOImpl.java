package com.ufl.geoaccessibility.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.ufl.geoaccessibility.entity.ConveyancePolygonEntity;

@Component
public class ConveyancePolygonDAOImpl implements ConveyancePolygonDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String create(ConveyancePolygonEntity ctae) {
		mongoTemplate.save(ctae);
		return null;
	}
	
	@Override
	public ConveyancePolygonEntity retrieveByRequestorRequestedAtDesc(String requestedBy) {
		Query query = new Query();
		query = query.addCriteria(Criteria.where("id.requestedBy").is(requestedBy));
		query = query.with(new Sort(Sort.Direction.DESC, "requestedAt"));
		ConveyancePolygonEntity cpe = mongoTemplate.findOne(query, ConveyancePolygonEntity.class);
		return cpe;
	}

	@Override
	public List<ConveyancePolygonEntity> retrieveByRequestor(String requestedBy) {
		Query query = new Query();
		query = query.addCriteria(Criteria.where("id.requestedBy").is(requestedBy));
		query = query.with(new Sort(Sort.Direction.DESC, "requestedAt"));
		List<ConveyancePolygonEntity> cpes = mongoTemplate.find(query, ConveyancePolygonEntity.class);
		return cpes;
	}

	
}
