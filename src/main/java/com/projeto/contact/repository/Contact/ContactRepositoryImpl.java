package com.projeto.contact.repository.Contact;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.projeto.contact.model.Contact;

public class ContactRepositoryImpl implements ContactRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Contact> pagedSearch(Integer page, Integer size) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Contact> criteria = builder.createQuery(Contact.class);
		Root<Contact> root = criteria.from(Contact.class);
		
		criteria.orderBy(builder.asc(root.get("id")));
		
		TypedQuery<Contact> query = manager.createQuery(criteria);
		addPaginationRestrictions(query, page, size);
		
		return query.getResultList();
	}
	
	private void addPaginationRestrictions(TypedQuery<Contact> query, Integer page, Integer size) {
		int currentPage = page;
		int totalRecordsPerPage = size;
		int firstPageRecord = currentPage * totalRecordsPerPage;
		
		query.setFirstResult(firstPageRecord);
		query.setMaxResults(totalRecordsPerPage);
	}

}
