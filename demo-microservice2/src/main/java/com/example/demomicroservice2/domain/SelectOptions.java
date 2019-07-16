/**
 * 
 */
package com.example.demomicroservice2.domain;

import java.io.Serializable;

/**
 * @author juhi.b.jain
 *
 */
public class SelectOptions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SelectOptions(String text, String value) {
		this.text = text;
		this.value = value;
	}

	String text;
	String value;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
