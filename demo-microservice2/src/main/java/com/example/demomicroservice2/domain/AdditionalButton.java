package com.example.demomicroservice2.domain;

public class AdditionalButton {

  boolean isVisible;
  String buttonText;
  
  
  
  public boolean isVisible() {
	return isVisible;
}



public void setVisible(boolean isVisible) {
	this.isVisible = isVisible;
}



public String getButtonText() {
	return buttonText;
}



public void setButtonText(String buttonText) {
	this.buttonText = buttonText;
}



AdditionalButton(){
	  this.isVisible = true;
	  this.buttonText = "Add Explanation";
  }
  
}
