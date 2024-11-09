package com.marketing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;
import com.marketing.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService1 {
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveLeadInfo(Lead lead) {
		leadRepo.save(lead);
	}

	@Override
	public List<Lead> getLeads() {
		  List<Lead> leader = leadRepo.findAll();
		return leader;
	}

	@Override
	public void deleteLead(long id) {
			leadRepo.deleteById(id);
		}

	@Override
	public Lead getOneLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
	
		
	

	

}
