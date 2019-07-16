/**
 * 
 */
package com.example.demomicroservice2.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demomicroservice2.dao.TemplateRepository;
import com.example.demomicroservice2.domain.Template;

/**
 * @author juhi.b.jain
 *
 */
@Service
public class TemplateService {

	@Autowired
	TemplateRepository templateRepository;

	public List<Template> getTemplates() {
		Iterable<Template> templates = templateRepository.findAll();
    	return StreamSupport.stream(templates.spliterator(), false) 
        .collect(Collectors.toList());
	} 
}
