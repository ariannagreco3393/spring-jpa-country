package com.soprasteria.springjpacountry.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		Optional<Country> c = countryRepository.findById(countryId);
		if (c.isPresent())
			return c.get();
		else
			return new Country();
	}

	@GetMapping("/countrybyregion") 
	public List<Country> getContryByRegion(@PathVariable(value = "region", required = false) String name) {
		if (name == null)
			return (List<Country>) countryRepository.findAll();
		else
			return (List<Country>) countryRepository.findByregion(name);
	}

	@DeleteMapping("/country/{countryId}") //delete
	public void deleteCountryById(@PathVariable(value = "countryId") int countryId) {
		countryRepository.deleteById(countryId);
	}
	
	
	@PostMapping("/country") //create
	public Country createStudent(@RequestBody Country country) {
		return countryRepository.save(country);

	}
	
	
	@PutMapping("/country/{countryId}")  //update
	public ResponseEntity<Country>  updateStudent(
			@PathVariable(value = "studentId") int CountryId,
			@RequestBody Country country) {
		
		Optional<Country> c=countryRepository.findById(CountryId);
		if (c.isPresent()) {
			Country c1=c.get();
			c1.setName(country.getName());
			c1.setArea(country.getArea());
			return new ResponseEntity<Country> (countryRepository.save(c1),HttpStatus.OK);
		} else
			return new ResponseEntity<Country> ((Country) null, HttpStatus.NOT_FOUND);
		
	}

}
