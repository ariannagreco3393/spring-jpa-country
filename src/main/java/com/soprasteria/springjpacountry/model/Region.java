package com.soprasteria.springjpacountry.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int regionId;
	private String name;
	
	@OneToMany
	@JoinColumn(name = "region", nullable = false)
    private List<Country> countries;
	
	
	@ManyToOne
	@JoinColumn(name = "continent_id")
	private Continent continent;


	

	public int getRegionId() {
		return regionId;
	}


	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getContinent_id() {
		return continent_id;
	}


	public void setContinent_id(int continent_id) {
		this.continent_id = continent_id;
	}


	public List<Country> getCountries() {
		return countries;
	}


	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}


	public Continent getContinent() {
		return continent;
	}


	public void setContinent(Continent continent) {
		this.continent = continent;
	}
	
	
	
	

}
