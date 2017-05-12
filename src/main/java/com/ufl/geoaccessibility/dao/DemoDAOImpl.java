package com.ufl.geoaccessibility.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ufl.geoaccessibility.entity.DemoEntity;

@Repository
public class DemoDAOImpl implements DemoDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void insert(DemoEntity de) {
		mongoTemplate.insert(de);
	}

	@Override
	public List<DemoEntity> retrieveAll() {
		List<DemoEntity> des = mongoTemplate.findAll(DemoEntity.class);
		return des;
	}
	
	
	
}
