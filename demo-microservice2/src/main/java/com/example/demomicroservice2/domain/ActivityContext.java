/**
 * 
 */
package com.example.demomicroservice2.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author juhi.b.jain
 *
 */

@Entity
@Table(name = "activity_context")
public class ActivityContext implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="activity_context_id")
	private int activityContextId;
	@Column(name = "activity_context_title")
	private String activityContextTitle;
	
	@Column(name = "activity_context_score")
	public int activityContextScore;
	
	@Column(name = "activity_context_scoretype")
	public String activityContextScoreType;
	/*
	 * Each Activity can have one or more than one Activity Contexts associated with it.
	 * 
	 */
	
	@OneToMany(mappedBy="activityContext", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name = "activity_info_id")
	@javax.persistence.OrderBy("context_question_Order")
	private Set<Question> question;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "activity_info_id")
	private Activity activity;
	
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "question_type_id")
	private QuestionType questionType;
	
	@Column(name = "last_update_date")
	private Date lastUpdateDate;
	/**
	 * @return the activityContextId
	 */
	public int getActivityContextId() {
		return activityContextId;
	}
	/**
	 * @param activityContextId the activityContextId to set
	 */
	public void setActivityContextId(int activityContextId) {
		this.activityContextId = activityContextId;
	}
	/**
	 * @return the activityContextTitle
	 */
	public String getActivityContextTitle() {
		return activityContextTitle;
	}
	/**
	 * @param activityContextTitle the activityContextTitle to set
	 */
	public void setActivityContextTitle(String activityContextTitle) {
		this.activityContextTitle = activityContextTitle;
	}
	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public Set<Question> getQuestion() {
		return question;
	}
	public void setQuestion(Set<Question> question) {
		this.question = question;
	}
	
	@JsonIgnore
	public Activity getActivity() {
		return activity;
	}
	@JsonIgnore
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public int getActivityContextScore() {
		return activityContextScore;
	}
	public void setActivityContextScore(int activityContextScore) {
		this.activityContextScore = activityContextScore;
	}
	public String getActivityContextScoreType() {
		return activityContextScoreType;
	}
	public void setActivityContextScoreType(String activityContextScoreType) {
		this.activityContextScoreType = activityContextScoreType;
	}
	
	@JsonIgnore
	public QuestionType getQuestionType() {
		return questionType;
	}
	@JsonIgnore
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	
	
	
	
}
