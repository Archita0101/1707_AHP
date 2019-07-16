package com.example.demomicroservice2.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "question_type")
public class QuestionType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_type_id")
	private int typeId;
	
	@Column(name = "question_type_name")
	public String typeName;
	
	@OneToMany(mappedBy="questionType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@JoinColumn(name = "activity_info_id")
	private Set<Question> question;
	
	
	@OneToMany(mappedBy = "questionType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ActivityContext> activityContext;
	

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<ActivityContext> getActivityContext() {
		return activityContext;
	}

	public void setActivityContext(Set<ActivityContext> activityContext) {
		this.activityContext = activityContext;
	}
	
	

}
