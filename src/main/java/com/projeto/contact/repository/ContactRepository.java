package com.projeto.contact.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.contact.model.Contact;
import com.projeto.contact.repository.Contact.ContactRepositoryQuery;

public interface ContactRepository extends JpaRepository<Contact, Long>, ContactRepositoryQuery {

	public Optional<Contact> findById(Integer id);
	
	public void deleteById(Integer id);
	
}
