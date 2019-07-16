/**
 * 
 */
package com.example.demomicroservice2.domain;

import java.util.List;

/**
 * @author juhi.b.jain
 *
 */
public class QuestionTransferObject {

	private int roundId;
	private int activityId;
	private List<ActivityContext> activityContextList;
	private List<ActivityContext> activityContextListByRental;
	private List<ActivityContext> activityContextListByOwner;
	
	private List<Question> question;
	public int getRoundId() {
		return roundId;
	}
	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public List<ActivityContext> getActivityContextList() {
		return activityContextList;
	}
	public void setActivityContextList(List<ActivityContext> activityContextList) {
		this.activityContextList = activityContextList;
	}
	public List<Question> getQuestion() {
		return question;
	}
	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	public List<ActivityContext> getActivityContextListByRental() {
		return activityContextListByRental;
	}
	public void setActivityContextListByRental(List<ActivityContext> activityContextListByRental) {
		this.activityContextListByRental = activityContextListByRental;
	}
	public List<ActivityContext> getActivityContextListByOwner() {
		return activityContextListByOwner;
	}
	public void setActivityContextListByOwner(List<ActivityContext> activityContextListByOwner) {
		this.activityContextListByOwner = activityContextListByOwner;
	}
	
}
	