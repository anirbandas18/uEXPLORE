package com.ufl.geoaccessibility.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.ufl.geoaccessibility.entity.ConveyancePolygonEntity;
import com.ufl.geoaccessibility.entity.Requestor;

@Component
public class ConveyancePolygonDAOImpl implements ConveyancePolygonDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String create(ConveyancePolygonEntity ctae) {
		mongoTemplate.save(ctae);
		String id = ctae.getId();
		return id;
	}

	@Override
	public List<ObjectId> create(List<ConveyancePolygonEntity> ctaes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ConveyancePolygonEntity> retrieveByRequestorName(Requestor requestor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConveyancePolygonEntity> retrieveByModeForRequestorName(String mode, Requestor requestor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConveyancePolygonEntity> retrieveAll() {
		List<ConveyancePolygonEntity> ctaes = mongoTemplate.findAll(ConveyancePolygonEntity.class);
		return ctaes;
	}

}
