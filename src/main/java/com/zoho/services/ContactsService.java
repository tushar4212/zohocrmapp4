package com.zoho.services;


import java.util.List;

import com.zoho.entities.Contacts;

public interface ContactsService {
	
	public void saveContactInfo(Contacts contact);

	public List<Contacts> getAllContacts();

	public Contacts getContactById(long id);

}
