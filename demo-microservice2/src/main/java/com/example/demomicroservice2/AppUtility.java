package com.example.demomicroservice2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import com.example.demomicroservice2.domain.ContextTemplate;
import com.example.demomicroservice2.service.ContextTemplateService;
public class AppUtility {

	public static List<ContextTemplate> uploadCSVFile(){
		String csvFile = "C:/temp/Misc/contextFile.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<ContextTemplate> contextTemplateList = new ArrayList<>();
        ContextTemplate contextTemplate = null;
        int iteration = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
        	while((line = br.readLine()) != null){
        		if(iteration == 0) {
        	        iteration++;  
        	        continue;
        	    }
        		String[] contextArray = line.split(cvsSplitBy);
        		contextTemplate =  createTemplate(contextArray);
        		contextTemplateList.add(contextTemplate);
        	}
        }catch(IOException e){
        	System.out.println("error while file processing"+e.getStackTrace());
        }
        return contextTemplateList;
	}
	
	public static List<ContextTemplate> uploadCSVFile(String filepath){
		//String csvFile = "C:/temp/Misc/contextFile.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<ContextTemplate> contextTemplateList = new ArrayList<>();
        ContextTemplate contextTemplate = null;
        int iteration = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
        	while((line = br.readLine()) != null){
        		if(iteration == 0) {
        	        iteration++;  
        	        continue;
        	    }
        		String[] contextArray = line.split(cvsSplitBy);
        		contextTemplate =  createTemplate(contextArray);
        		contextTemplateList.add(contextTemplate);
        	}
        }catch(IOException e){
        	System.out.println("error while file processing"+e.getStackTrace());
        }
        return contextTemplateList;
	}
	
	private static ContextTemplate createTemplate(String[] contextArray) {
		
		  String templateName = contextArray[0];
		  String contextName = contextArray[1];
		  String question = contextArray[2];
		  String answerType = contextArray[3];
		  String answerValues = contextArray[4];
		  String score = contextArray[5];
        
        return new ContextTemplate(templateName,contextName,question,answerType,answerValues,score);
    }
	
	public static void main(String[] arr){
		List<ContextTemplate> contextTemplateList = uploadCSVFile();
		ContextTemplateService service = new ContextTemplateService();
		for(ContextTemplate contextTemplate : contextTemplateList){
			service.addContextTemplate(contextTemplate);
		}
	}
	
}
