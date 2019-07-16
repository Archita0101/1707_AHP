/**
 * 
 */
package com.example.demomicroservice2.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demomicroservice2.dao.TemplateQuestionRepository;
import com.example.demomicroservice2.domain.TemplateQuestions;

/**
 * @author juhi.b.jain
 *
 */
@Service
public class TemplateQuestionService {

	@Autowired
	TemplateQuestionRepository templateQuestionRepository;
	
	
	public List<TemplateQuestions> getTemplateQuestionsByTemplateId(int templateId) {
		Iterable<TemplateQuestions> templateQuestions = templateQuestionRepository.findByTemplateId(templateId);
    	return StreamSupport.stream(templateQuestions.spliterator(), false) 
        .collect(Collectors.toList());
	}
}
