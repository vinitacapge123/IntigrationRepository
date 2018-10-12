package com.fms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class FlightBean {

	@Id
	@GeneratedValue
	private Integer flightId;
	@Size(min=3,max=6,message="please enter correct data")
	@NotEmpty(message="please enter ")
	private String flightName;
	private String classtype;
	public FlightBean() {
		// TODO Auto-generated constructor stub
	}
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getClasstype() {
		return classtype;
	}
	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}
	public FlightBean(Integer flightId, String flightName, String classtype) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.classtype = classtype;
	}
	public FlightBean( String flightName, String classtype) {
		this.flightName = flightName;
		this.classtype = classtype;
	}
	
	
	
	
}
