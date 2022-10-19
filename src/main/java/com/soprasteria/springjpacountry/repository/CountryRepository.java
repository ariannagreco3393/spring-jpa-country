package com.soprasteria.springjpacountry.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.soprasteria.springjpacountry.model.Country;


public interface CountryRepository extends CrudRepository<Country, Integer> {

	
	 public List<Country> findByregion(String name);

}
