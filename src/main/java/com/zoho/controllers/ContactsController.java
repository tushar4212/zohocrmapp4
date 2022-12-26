package com.zoho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Contacts;
import com.zoho.services.ContactsService;

@Controller
public class ContactsController {
	
	@Autowired
	private ContactsService contService;
	
	@RequestMapping("/listcontacts")
	public String getAllContacts( Model model ) {
		
		List<Contacts> contacts = contService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
		
	}
	
	@RequestMapping("/contactInfo")
	public String getContactInfo(@RequestParam("id") long  id , Model model) {
		Contacts contacts = contService.getContactById(id);
		model.addAttribute("contacts", contacts);
		return "contact_info";
		
	}

}
