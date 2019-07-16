package com.example.demomicroservice2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="context_template")
public class ContextTemplate {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "context_template_id")
	private Integer contextTemplateId;
	
  @Column(name="template_name")
  private String templateName;
  
  @Column(name="context_name")
  String contextName;
  
  @Column(name="question_value")
  String question;
  
  @Column(name="answer_type")
  String answerType;
  
  @Column(name="answer_values")
  String answerValues;
  
  @Column(name="score")
  String score;
  
  public ContextTemplate(String templateName, String contextName, String question, String answerType, String answerValues, String score ){
	   this.templateName = templateName;
	   this.contextName = contextName;
	   this.question = question;
	   this.answerType = answerType;
	   this.answerValues = answerValues;
	   this.score = score;
  }

public ContextTemplate() {
}

public String getTemplateName() {
	return templateName;
}

public void setTemplateName(String templateName) {
	this.templateName = templateName;
}

public String getContextName() {
	return contextName;
}

public void setContextName(String contextName) {
	this.contextName = contextName;
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public String getAnswerType() {
	return answerType;
}

public void setAnswerType(String answerType) {
	this.answerType = answerType;
}

public String getAnswerValues() {
	return answerValues;
}

public void setAnswerValues(String answerValues) {
	this.answerValues = answerValues;
}

public String getScore() {
	return score;
}

public void setScore(String score) {
	this.score = score;
}
  
}
