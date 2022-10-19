package com.soprasteria.springjpacountry.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springjpacountry.model.Region;
import com.soprasteria.springjpacountry.repository.RegionRepository;

@RestController
@RequestMapping("/api/*") // tutte le richieste del tipo /api/*

public class RegionController  {
	
	@Autowired
	private RegionRepository regionRepository;
	
	@GetMapping("/region")
	public List<Region> getAllRegion() {
			return (List<Region>) regionRepository.findAll();
		
	}
	
	
	@GetMapping("/region/{regionId}")
	public Region getRegionById(@PathVariable(value = "regionId") int regionId) {
		Optional<Region> r=regionRepository.findById(regionId);
		if(r.isPresent())
			return r.get();
		else
			return new Region();
	}
	

}
