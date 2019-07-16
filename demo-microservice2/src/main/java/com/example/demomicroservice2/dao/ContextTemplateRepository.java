package com.example.demomicroservice2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demomicroservice2.domain.ContextTemplate;

@Repository 
@Transactional
public interface ContextTemplateRepository extends CrudRepository<ContextTemplate,Integer>{
	
	
	public ContextTemplate findByTemplateName(String TemplateName );
	
	public void deleteByTemplateName(String templateName);

}
