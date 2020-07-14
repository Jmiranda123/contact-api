package com.projeto.contact.repository.Contact;

import java.util.List;

import com.projeto.contact.model.Contact;

public interface ContactRepositoryQuery {
	
	public List<Contact> pagedSearch(Integer page, Integer size);

}
