package com.ufl.uexplore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ufl.uexplore.entity.ConveyancePolygonEntity;

@Repository
public interface ConveyancePolygonDAO {
	
	public String create(ConveyancePolygonEntity ctae);

	public ConveyancePolygonEntity retrieveByRequestorRequestedAtDesc(String requestedBy);
	
	public List<ConveyancePolygonEntity> retrieveByRequestor(String requestedBy);

}
