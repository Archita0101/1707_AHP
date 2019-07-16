package com.example.demomicroservice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demomicroservice2.dao.ContextTemplateRepository;
import com.example.demomicroservice2.domain.ContextTemplate;

@Service
public class ContextTemplateService {

	@Autowired
	ContextTemplateRepository contextTemplateRepository;
	
	public void addContextTemplate(ContextTemplate contextTemplate){
		contextTemplateRepository.save(contextTemplate);
	}
	
	public void findByTemplateName(String  templateName){
		contextTemplateRepository.findByTemplateName(templateName);
	}
	
	public void deleteByTemplateName(String  templateName){
		contextTemplateRepository.deleteByTemplateName(templateName);
	}
}
