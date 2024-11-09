package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.service.LeadService1;
import com.marketing.util.EmailService;

@Controller 
public class LeadController {
     @Autowired
	private LeadService1 leadService;
@Autowired
private EmailService emailService;


	//http://localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	@RequestMapping("/saveLead")
public String saveOneLead(@ModelAttribute("L") Lead lead,ModelMap model) {
		leadService.saveLeadInfo(lead);
		emailService.sendEmail(lead.getEmail()," welcome to danish academy", "test email from springboot");
		model.addAttribute("msg", "record is saved!!");
		return "create_lead";
}
	
	
//	@RequestMapping("saveLead")
//	public String saveOneLead(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,@RequestParam("email")String email,@RequestParam("mobile")String mobile,ModelMap model){
//	Lead lead=new Lead();
//	lead.setFirstName(firstName);
//	lead.setLastName(lastName);
//	lead.setEmail(email);
//	lead.setMobile(mobile);
//	model.addAttribute("msg", "just now record saved!!!");
//	leadService.saveLeadInfo(lead);
//		return "create_lead";
//	}
//	@RequestMapping("/saveLead")
//	public String saveOneLead(LeadData data,ModelMap model) {
//		Lead lead=new Lead();
//		lead.setFirstName(data.getFirstName());
//		lead.setLastName(data.getLastName());
//		lead.setEmail(data.getEmail());
//		lead.setMobile(data.getMobile());
//		
//		leadService.saveLeadInfo(lead);
//		model.addAttribute("msg","record get uploaded!!");
//		return "create_lead" ;
		
	//}
		
	
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String listAllLeads(Model model) {
	  List<Lead> leader = leadService.getLeads();
model.addAttribute("leads",leader);
		return "list_leads";
	}
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id,Model model) {
		leadService.deleteLead(id);
		
		List<Lead>leades = leadService.getLeads();
		model.addAttribute("leads",leades);
				return "list_leads";
	}
	
	
	
	
	
	@RequestMapping("/update")
	public String getLeadInfo(@RequestParam("id") long id,Model Map) {
		Lead lead=leadService.getOneLead(id);
		Map.addAttribute("lead", lead);
		return "update_leads";
	}
		@RequestMapping("/updateLead")
		public String updateLeadInfo(LeadData data,Model model) {
			Lead l=new Lead();
			l.setId(data.getId());
			l.setFirstName(data.getFirstName());
			l.setLastName(data.getLastName());
			l.setEmail(data.getEmail());
			l.setMobile(data.getMobile());
			
			leadService.saveLeadInfo(l);
			List<Lead>leads = leadService.getLeads();
			model.addAttribute("leads",leads);
					return "list_leads";
		}
	}

