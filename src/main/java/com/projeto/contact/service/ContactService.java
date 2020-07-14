package com.projeto.contact.service;

import java.util.List;
import java.util.Optional;

import com.projeto.contact.model.Contact;
import com.projeto.contact.service.dto.ContactCreateDTO;
import com.projeto.contact.service.dto.ContactUpdateDTO;

public interface ContactService {
	
	Contact findContact(Integer id);
	
	void updateContact(Integer id, ContactUpdateDTO dto);
	
	void deleteContact(Integer id);
	
	List<Contact> pagedSearch(Optional<Integer> size, Optional<Integer> page);
	
	void createContact(ContactCreateDTO dto);

}
