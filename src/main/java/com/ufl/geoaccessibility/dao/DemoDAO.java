package com.ufl.geoaccessibility.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ufl.geoaccessibility.entity.DemoEntity;

@Repository
public interface DemoDAO {
	
	public void insert(DemoEntity de);
	
	public List<DemoEntity> retrieveAll();

}
