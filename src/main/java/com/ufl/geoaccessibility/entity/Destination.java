package com.ufl.geoaccessibility.entity;

public class Destination {

	private String address;
	
	private Coordinate coordinates;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Coordinate getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinate coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Destination [address=" + address + ", coordinates=" + coordinates + "]";
	}
	
}
