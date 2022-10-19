package com.soprasteria.springjpacountry.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springjpacountry.model.Country;
import com.soprasteria.springjpacountry.model.Region;
import com.soprasteria.springjpacountry.repository.CountryRepository;
import com.soprasteria.springjpacountry.repository.RegionRepository;

@RestController
@RequestMapping("/api") // tutte le richieste del tipo /api/*
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping("/country")
	public List<Country> getAllCountry() {
			return (List<Country>) countryRepository.findAll();
		
	}
	
	@GetMapping("/country/{countryId}")
	public Country getCountryById(@PathVariable(value = "countryId") int countryId) {
		Optional<Country> c=countryRepository.findById(countryId);
		if(c.isPresent())
			return c.get();
		else
			return new Country();
	}
	
	@GetMapping("/countrybyregion")
	public List<Country> getContryByRegion(@PathVariable(value = "region", required = false) String name) {
		if(name == null)
			return (List<Country>) countryRepository.findAll();
		else
			return (List<Country>) countryRepository.findByregion(name);
	}
	
	
	
}
