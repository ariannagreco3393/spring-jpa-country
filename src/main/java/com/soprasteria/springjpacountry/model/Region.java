package com.soprasteria.springjpacountry.model;


import java.util.List;

import javax.persistence.Column;
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
	@Column(name="region_id")
	private int regionId;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "continent_id", nullable = false)
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



	public Continent getContinent() {
		return continent;
	}




	public void setContinent(Continent continent) {
		this.continent = continent;
	}


	
	

}
