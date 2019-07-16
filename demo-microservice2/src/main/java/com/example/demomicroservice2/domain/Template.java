/**
 * 
 */
package com.example.demomicroservice2.domain;

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
@Table(name = "templates")
public class Template {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="template_Id")
	private int templateId;
	@Column(name="template_Name")
	private String templateName;
	@OneToMany(mappedBy="template", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<TemplateQuestions> templateQuestions;
	
	public Set<TemplateQuestions> getTemplateQuestions() {
		return templateQuestions;
	}
	public void setTemplateQuestions(Set<TemplateQuestions> templateQuestions) {
		this.templateQuestions = templateQuestions;
	}
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
}
