package com.projeto.contact.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.contact.model.Contact;
import com.projeto.contact.service.ContactService;
import com.projeto.contact.service.dto.ContactCreateDTO;
import com.projeto.contact.service.dto.ContactUpdateDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class ContactResource {
	
	private final ContactService contactService;
	
	public ContactResource(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping("/{idContato}")
	public ResponseEntity<Contact> findContact(@PathVariable("idContato") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findContact(id));
	}
	
	@PutMapping("/{idContato}")
	public ResponseEntity<?> updateContact(@PathVariable("idContato") Integer id, @RequestBody ContactUpdateDTO dto) {
		contactService.updateContact(id, dto);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{idContato}")
	public ResponseEntity<?> deleteContact(@PathVariable("idContato") Integer id) {
		contactService.deleteContact(id);
		return ResponseEntity.noContent().build();
	}	
	
	@GetMapping
	public  ResponseEntity<List<Contact>> findByState(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		return ResponseEntity.ok(contactService.pagedSearch(size, page));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ContactCreateDTO dto) {
		contactService.createContact(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
