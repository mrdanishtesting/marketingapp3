package com.marketing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.repositories.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
     @Autowired
	private LeadRepository leadRepo;

 

	

	//http:localhost:8080/api/leads/leadinfo/1
	@RequestMapping("/leadinfo/{id}")
	public Lead getOneLead(@PathVariable("id")long id) {
		Optional<Lead> findById = leadRepo.findById(id);
	Lead lead = findById.get();
	return lead;
	}
}
