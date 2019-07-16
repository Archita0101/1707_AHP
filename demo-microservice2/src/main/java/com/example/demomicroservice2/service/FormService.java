/**
 * 
 */
package com.example.demomicroservice2.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demomicroservice2.dao.FormRepository;
import com.example.demomicroservice2.domain.Form;

/**
 * @author juhi.b.jain
 *
 */
@Service
public class FormService {
	
	@Autowired
	FormRepository formRepository;
	
	public List<Form> getForms() {
		Iterable<Form> forms = formRepository.findAll();
    	return StreamSupport.stream(forms.spliterator(), false) 
        .collect(Collectors.toList());
	}
	
	
	public Form getFormById(int formId) {
		return formRepository.findById(formId).get();
	}

	public void createNewForm(Form form) {
		formRepository.save(form);
	}

	public void deleteForm(Form form) {
		formRepository.delete(form);
	}

	public void editForm(Form form) {
		formRepository.save(form);
	}
}
