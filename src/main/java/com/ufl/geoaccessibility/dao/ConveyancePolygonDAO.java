package com.ufl.geoaccessibility.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.ufl.geoaccessibility.entity.ConveyancePolygonEntity;
import com.ufl.geoaccessibility.entity.Requestor;

@Repository
public interface ConveyancePolygonDAO {

	public String create(ConveyancePolygonEntity ctae);
	
	public List<ObjectId> create(List<ConveyancePolygonEntity> ctaes);
	
	//public boolean update(ConveyanceTimeAreaEntity ctae);
	
	//public List<Boolean> update(List<ConveyanceTimeAreaEntity> ctaes);
	
	//public boolean delete(ConveyanceTimeAreaEntity ctae);
	
	//public boolean delete(List<ConveyanceTimeAreaEntity> ctaes);
	
	//public boolean delete(ObjectId id);
	
	public boolean deleteAll();
	
	//public Integer count();
	
	//public boolean exists(ConveyanceTimeAreaEntity ctae);
	
	//public boolean exists(ObjectId id);
	
	public List<ConveyancePolygonEntity> retrieveAll();
	
	//public List<ConveyanceTimeAreaEntity> retrieveAll(List<ObjectId> ids);
	
	public List<ConveyancePolygonEntity> retrieveByRequestorName(Requestor requestor);
	
	public List<ConveyancePolygonEntity> retrieveByModeForRequestorName(String mode, Requestor requestor);
	
	//public ConveyanceTimeAreaEntity retrieveOne(ObjectId id);
	
	//public ConveyanceTimeAreaEntity retrieveOne(RequestorEntity requestor);
}
