package com.soprasteria.springjpacountry.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springjpacountry.model.Continent;
import com.soprasteria.springjpacountry.repository.ContinentRepository;

@RestController
@RequestMapping("/api") // tutte le richieste del tipo /api/*
public class ContinentController {

	@Autowired
	private ContinentRepository continentRepository;
	
	@GetMapping("/continent")
	public List<Continent> getAllContinent(){
		return (List<Continent>) continentRepository.findAll();
		
	}
	
	
	@GetMapping("/continent/{continentId}")
	public Continent getContinentById(@PathVariable(value = "continentId") int continentId) {
		Optional<Continent> c=continentRepository.findById(continentId);
		if(c.isPresent())
			return c.get();
		else
			return new Continent();
	}
}
