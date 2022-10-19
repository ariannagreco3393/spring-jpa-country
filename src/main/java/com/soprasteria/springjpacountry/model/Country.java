package com.soprasteria.springjpacountry.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int countryId;
	private String name;
	private BigDecimal area;
	private LocalDate nationalDay;
	private char countryCode2;
	private char countryCode3;
	
	
	@ManyToOne
	@JoinColumn(name = "region_id", nullable = false)
	private Region region;


	public int getCountryId() {
		return countryId;
	}


	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getArea() {
		return area;
	}


	public void setArea(BigDecimal area) {
		this.area = area;
	}


	public LocalDate getNationalDay() {
		return nationalDay;
	}


	public void setNationalDay(LocalDate nationalDay) {
		this.nationalDay = nationalDay;
	}


	public char getCountryCode2() {
		return countryCode2;
	}


	public void setCountryCode2(char countryCode2) {
		this.countryCode2 = countryCode2;
	}


	public char getCountryCode3() {
		return countryCode3;
	}


	public void setCountryCode3(char countryCode3) {
		this.countryCode3 = countryCode3;
	}


	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}



	

	
	
}
