/**
 * 
 */
package com.example.demomicroservice2.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demomicroservice2.dao.QuestionRepository;
import com.example.demomicroservice2.domain.Question;

/**
 * @author juhi.b.jain
 *
 */
@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	
	public List<Question> getQuestions() {
		Iterable<Question> questions = questionRepository.findAll();
    	return StreamSupport.stream(questions.spliterator(), false) 
        .collect(Collectors.toList());
	}
	

	public void addQuestion(Question question) {
		questionRepository.save(question);
	}

	public void deleteQuestion(Question question) {
		questionRepository.delete(question);
	}

	public void editQuestion(Question question) {
		questionRepository.save(question);
	}
	public Question getQuestionById(int questionId) {
		Optional<Question> contextRepo = questionRepository.findById(questionId);
		if(contextRepo.isPresent())
			return contextRepo.get();

		return new Question();
	}

	/*
	 * Batch Operations
	 */
	
	public void editAllQuestions(List<Question> questions) {
		questionRepository.saveAll(questions);
	}
	
	
	
	public void addAllQuestions(List<Question> questions) {
		questionRepository.saveAll(questions);
	}
	
	public void deleteQuestionsByContextId(Integer contextId ) {
		questionRepository.deleteQuestionsByContextId(contextId);
	}
	
	/*
	 * public List<Question> findQuestionsByActivityId(Integer activityId) {
	 * 
	 * Iterable<Question> questions =
	 * questionRepository.findQuestionsByActivityId(activityId); return
	 * StreamSupport.stream(questions.spliterator(), false)
	 * .collect(Collectors.toList());
	 * 
	 * }
	 */
	
	
}
