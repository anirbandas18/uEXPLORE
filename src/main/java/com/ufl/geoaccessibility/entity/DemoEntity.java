package com.ufl.geoaccessibility.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "demo")
public class DemoEntity {

	private String id;
	private Map<String,String> map1;
	private Map<String,List<Date>> map2;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, String> getMap1() {
		return map1;
	}
	public void setMap1(Map<String, String> map1) {
		this.map1 = map1;
	}
	public Map<String, List<Date>> getMap2() {
		return map2;
	}
	public void setMap2(Map<String, List<Date>> map2) {
		this.map2 = map2;
	}
	@Override
	public String toString() {
		return "DemoEntity [id=" + id + ", map1=" + map1 + ", map2=" + map2 + "]";
	}
	
	
	
}
