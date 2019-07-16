/**
 * 
 */
package com.example.demomicroservice2.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author juhi.b.jain
 *
 */

@Entity
@Table(name = "template_questions")
public class TemplateQuestions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	/*
	 * @ManyToOne(fetch = FetchType.EAGER )
	 * 
	 * @JoinColumn(name = "activity_context_id") private ActivityContext
	 * activityContext;
	 */
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "template_id")
	private Template template;
	
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
	
	@Column(name = "context_Title")
	private String contextTitle;

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
	public Template getTemplate() {
		return template;
	}

	@JsonIgnore
	public void setTemplate(Template template) {
		this.template = template;
	}

	public String getContextTitle() {
		return contextTitle;
	}

	public void setContextTitle(String contextTitle) {
		this.contextTitle = contextTitle;
	}
	
	
	/*
	 * @JsonIgnore public ActivityContext getActivityContext() { return
	 * activityContext; }
	 * 
	 * @JsonIgnore public void setActivityContext(ActivityContext activityContext) {
	 * this.activityContext = activityContext; }
	 */

		
}

