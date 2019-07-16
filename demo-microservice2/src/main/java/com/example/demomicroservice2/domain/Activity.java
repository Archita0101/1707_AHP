package com.example.demomicroservice2.domain;

import java.util.Date;
import java.util.List;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "activity_info")
public class Activity {//implements Comparable<Activity> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_info_id")
	private Integer activityId;

	@Column(name = "activity_info_name")
	private String activityName;

	// @Column(name = "form_Id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_master_id")
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Form form;

	@OneToMany(mappedBy = "activity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinColumn(name = "activity_info_id")
	@javax.persistence.OrderBy("activity_context_id")
	private Set<ActivityContext> activityContext;
	
	@Transient
	private List<ActivityContext> activityContextListByRental;
	@Transient
	private List<ActivityContext> activityContextListByOwner;

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


	@Column(name = "form_Activity_Order")
	private int formActivityOrder;

	@Column(name = "form_status")
	private String formStatus;

	@Column(name = "last_update_date")
	private Date lastUpdateDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "round_Id", nullable = false)
	private Round round;

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	@JsonIgnore
	public Round getRound() {
		return round;
	}

	@JsonIgnore
	public void setRound(Round round) {
		this.round = round;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Activity() {
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Form getFormId() {
		return form;
	}

	public void setFormId(Form form) {
		this.form = form;
	}

	public int getFormActivityOrder() {
		return formActivityOrder;
	}

	public void setFormActivityOrder(int formActivityOrder) {
		this.formActivityOrder = formActivityOrder;
	}

	public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Set<ActivityContext> getActivityContext() {
		return activityContext;
	}

	public void setActivityContext(Set<ActivityContext> activityContext) {
		this.activityContext = activityContext;

	}
	


	/*
	 * @Override public int compareTo(Activity compareWith) { if
	 * (this.getFormActivityOrder() == compareWith.getFormActivityOrder()) return 0;
	 * else if (this.getFormActivityOrder() > compareWith.getFormActivityOrder())
	 * return 1; else return -1; }
	 */

	/*
	 * public Activity(int activityId, String activityName, boolean completeStatus,
	 * boolean isActive,boolean error) { this.activityId = activityId;
	 * this.activityName = activityName; this.isCompleted = completeStatus;
	 * this.isActive = isActive; this.error = error;
	 * 
	 * }
	 */

}
