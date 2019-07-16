/**
 * 
 */
package com.example.demomicroservice2.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author juhi.b.jain
 *
 */
public class TransferObject {
	
	
	public TransferObject (){
		
		System.out.println("TransferObject constructor");
		SelectOptions selectOption1 = new SelectOptions("Yes", "Y");
		SelectOptions selectOption2 = new SelectOptions("No", "N");
		
		this.optionsList = new ArrayList<SelectOptions>();
		
		this.optionsList.add(selectOption1);
		this.optionsList.add(selectOption2);
		
		this.additionalButton = new AdditionalButton();
		
	}
	
	int fieldId; 
	String type;
	String label;
	String index;
	String inputType;
	String keyName;
	String ruleApplicable;
	String parentId;
	String category;
	
	
	List<SelectOptions> optionsList;
	
	AdditionalButton additionalButton;
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getInputType() {
		return inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<SelectOptions> getOptionsList() {
		return optionsList;
	}

	/*
	 * public void setOptionsList(List<SelectOptions> optionsList) {
	 * this.optionsList = optionsList; }
	 */
	public AdditionalButton getAdditionalButton() {
		return additionalButton;
	}
	public void setAdditionalButton(AdditionalButton additionalButton) {
		this.additionalButton = additionalButton;
	}
	public String getRuleApplicable() {
		return ruleApplicable;
	}
	public void setRuleApplicable(String ruleApplicable) {
		this.ruleApplicable = ruleApplicable;
	}
	
}

