package com.zoho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contacts;
import com.zoho.entities.Lead;
import com.zoho.services.ContactsService;
import com.zoho.services.LeadServcie;

@Controller
public class LeadController {
	@Autowired
	private LeadServcie leadServcie;
	
	@Autowired
	private ContactsService contactService;
	
	@RequestMapping(value = "/create" , method = RequestMethod.GET)
	public String viewCreateLeadPage() {
		return "create_lead";
		
	}

	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveOneLead(@ModelAttribute("lead") Lead lead,Model model) {
		leadServcie.saveLeadInfo(lead);
		model.addAttribute("lead", lead);
		model.addAttribute("msg", "Lead is Saved");
		return "lead_info";
		
	}
	
	@RequestMapping("/listleads")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadServcie.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
		
	}
	
	@RequestMapping("/leadInfo")
	public String getOneLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadServcie.getLeadInfo(id);
		model.addAttribute("lead", lead);
		return "lead_info";
		
	}
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadServcie.getLeadInfo(id);
		Contacts contact=new Contacts();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		
		contactService.saveContactInfo(contact);
		
		
		leadServcie.deleteOneLead(id);
		
		List<Contacts> contacts = contactService.getAllContacts();
		
		model.addAttribute("contacts", contacts);
		return "list_contacts";
		
		
	}
	


}

