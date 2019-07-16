/**
 * 
 */
package com.example.demomicroservice2.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author juhi.b.jain
 *
 *
 */



@Entity
@Table(name = "context_questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="context_question_Id")
	private Integer question_ID;
	
	/*
	 * Activity Context is the heading/title/context for the sub-questions within it.
	 * Each activity context may have more than one context questions associated with it.
	 * However, a question may or may not be necessarily associated with an Activity Context.
	 * There is an optional MANY-TO-ONE relationship between the questions and the ActivityContext.
	 */
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "activity_context_id")
	private ActivityContext activityContext;
	
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "question_type_id")
	private QuestionType questionType;
	
	/*
	 * @OneToOne(mappedBy="contextQuestionId", fetch = FetchType.LAZY) private
	 * Answer answer;
	 */
	
	@Column(name = "context_question")
	private String questionValue;

	@Column(name = "context_question_Order")
	private String questionOrder;

	
	@Column(name = "answer_field_type")
	private String answerFieldType;
	
	@Column(name = "is_rule_applicable")
	private String isRuleApplicable;
	
	@Column(name = "options_value")
	private String optionsValue;
	
	@Column(name = "additional_button")
	private String additionalButton;
	
	@Column(name = "is_visible_button")
	private boolean isVisibleButton;
	
	@Column(name = "score")
	private int score;

	public int getQuestion_ID() {
		return question_ID;
	}

	public void setQuestion_ID(int question_ID) {
		this.question_ID = question_ID;
	}

	/*
	 * @JsonIgnore public Activity getActivity() { return activity; }
	 * 
	 * @JsonIgnore public void setActivity(Activity activity) { this.activity =
	 * activity; }
	 */

	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}

	public String getQuestionOrder() {
		return questionOrder;
	}

	public void setQuestionOrder(String questionOrder) {
		this.questionOrder = questionOrder;
	}

	public String getAnswerFieldType() {
		return answerFieldType;
	}

	public void setAnswerFieldType(String answerFieldType) {
		this.answerFieldType = answerFieldType;
	}

	public String getIsRuleApplicable() {
		return isRuleApplicable;
	}

	public void setIsRuleApplicable(String isRuleApplicable) {
		this.isRuleApplicable = isRuleApplicable;
	}

	public String getOptionsValue() {
		return optionsValue;
	}

	public void setOptionsValue(String optionsValue) {
		this.optionsValue = optionsValue;
	}

	public String getAdditionalButton() {
		return additionalButton;
	}

	public void setAdditionalButton(String additionalButton) {
		this.additionalButton = additionalButton;
	}

	public boolean isVisibleButton() {
		return isVisibleButton;
	}

	public void setVisibleButton(boolean isVisibleButton) {
		this.isVisibleButton = isVisibleButton;
	}

	@JsonIgnore
	public ActivityContext getActivityContext() {
		return activityContext;
	}

	@JsonIgnore
	public void setActivityContext(ActivityContext activityContext) {
		this.activityContext = activityContext;
	}

	@JsonIgnore
	public QuestionType getQuestionType() {
		return questionType;
	}

	@JsonIgnore
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

		
}
