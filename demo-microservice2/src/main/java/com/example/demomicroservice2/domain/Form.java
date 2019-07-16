package com.example.demomicroservice2.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form_master")
public class Form {
	
	
	    
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "form_master_id")
	private int formMasterId;
	
	@Column(name = "form_name")
	private String formName;

	@Column(name = "last_update_date")
    private Date lastUpdateDate;
	
	public Form() {
	}

	public int getFormMasterId() {
		return formMasterId;
	}

	public void setFormMasterId(int formMasterId) {
		this.formMasterId = formMasterId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	
}
