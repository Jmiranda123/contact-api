package com.projeto.contact.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.contact.model.Contact;
import com.projeto.contact.repository.ContactRepository;
import com.projeto.contact.service.ContactService;
import com.projeto.contact.service.dto.ContactCreateDTO;
import com.projeto.contact.service.dto.ContactUpdateDTO;

@Service
public class ContactServiceImpl implements ContactService {

	private final ContactRepository contactRepository;
	
	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	@Override
	public Contact findContact(Integer id) {
		Contact contact = contactRepository.findById(id).orElse(new Contact());
		return contact;
	}
	
	@Override
	@Transactional
	public void updateContact(Integer id, ContactUpdateDTO dto) {
		contactRepository.findById(id).orElseThrow(EntityNotFoundException::new);

		Contact toUpdateContact = new Contact(id, dto.getName(), dto.getChannel(), dto.getValue(), dto.getObs());
		
		contactRepository.save(toUpdateContact);
	}
	
	@Override
	@Transactional
	public void deleteContact(Integer id) {
		contactRepository.deleteById(id);
	}
	
	@Override
	public List<Contact> pagedSearch(Optional<Integer> size, Optional<Integer> page) {
		return contactRepository.pagedSearch(page.isPresent() ? page.get() : 0, size.isPresent() ? size.get() : 10);
	}
	
	@Override
	@Transactional
	public void createContact(ContactCreateDTO dto) {
		Contact toCreateContact = new Contact(dto.getName(), dto.getChannel(), dto.getValue(), dto.getObs());
		contactRepository.save(toCreateContact);
	}
	
}
