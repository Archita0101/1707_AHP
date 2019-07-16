/**
 * 
 */
package com.example.demomicroservice2.domain;

import java.util.List;

/**
 * @author juhi.b.jain
 *
 */
public class TemplateTransferObject {

		private int roundId;
		private int activityId;
		private List<ActivityContext> activityContextList;
		//private List<TemplateQuestions> question;
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
	/*
	 * public List<TemplateQuestions> getQuestion() { return question; } public void
	 * setQuestion(List<TemplateQuestions> question) { this.question = question; }
	 */
		
	}