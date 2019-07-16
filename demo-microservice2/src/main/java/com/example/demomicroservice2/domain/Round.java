/**
 * 
 */
package com.example.demomicroservice2.domain;

import java.sql.Date;
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

/**
 * @author juhi.b.jain
 *
 */
@Entity
@Table(name = "Round")
public class Round {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROUND_ID")
	private int roundId;
	@Column(name = "round_Name")
	private String roundName;
	@Column(name = "round_Status")
	private String roundStatus;
	/*
	 * Every Application is associated with multiple rounds. The relationship
	 * between round and application is that of MANY-TO-ONE.
	 */
	// @Column(name = "associatedApplication")
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "app_id") private Application associatedApplication;
	 */
	@Column(name = "start_Date")
	private Date startDate;
	@Column(name = "end_Date")
	private Date endDate;
	@Column(name = "progress_Credence")
	private String progressCredence;
	@Column(name = "retention_Period")
	private String retentionPeriod;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "round")
	@javax.persistence.OrderBy("activity_info_id")
	private Set<Activity> activities;
	@Column(name = "owner_Occupied_Rp")
	private String ownerOccupiedRetentionPeriod;
	
	
	public String getOwnerOccupiedRetentionPeriod() {
		return ownerOccupiedRetentionPeriod;
	}

	public void setOwnerOccupiedRetentionPeriod(String ownerOccupiedRetentionPeriod) {
		this.ownerOccupiedRetentionPeriod = ownerOccupiedRetentionPeriod;
	}

	public String getProgressCredence() {
		return progressCredence;
	}

	public void setProgressCredence(String progressCredence) {
		this.progressCredence = progressCredence;
	}

	public String getRetentionPeriod() {
		return retentionPeriod;
	}

	public void setRetentionPeriod(String retentionPeriod) {
		this.retentionPeriod = retentionPeriod;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	/**
	 * @return the roundId
	 */
	public int getRoundId() {
		return roundId;
	}

	/**
	 * @param roundId the roundId to set
	 */
	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}

	/**
	 * @return the roundName
	 */
	public String getRoundName() {
		return roundName;
	}

	/**
	 * @param roundName the roundName to set
	 */
	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}

	/**
	 * @return the roundStatus
	 */
	public String getRoundStatus() {
		return roundStatus;
	}

	/**
	 * @param roundStatus the roundStatus to set
	 */
	public void setRoundStatus(String roundStatus) {
		this.roundStatus = roundStatus;
	}

	/**
	 * @return the associatedApplication
	 */
	/*
	 * public Application getAssociatedApplication() { return associatedApplication;
	 * }
	 * 
	 *//**
		 * @param associatedApplication the associatedApplication to set
		 *//*
			 * public void setAssociatedApplication(Application associatedApplication) {
			 * this.associatedApplication = associatedApplication; }
			 */

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
