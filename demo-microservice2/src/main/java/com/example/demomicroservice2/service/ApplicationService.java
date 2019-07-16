/**
 * 
 */
package com.example.demomicroservice2.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demomicroservice2.dao.ApplicationRepository;
import com.example.demomicroservice2.domain.Application;

/**
 * @author juhi.b.jain
 *
 */
@Service
public class ApplicationService {

	@Autowired
	ApplicationRepository applicationRepository;
	
	public List<Application> getAllApplications() {
		System.out.println(" Entering application service to fetch all");
		Iterable<Application> applications = applicationRepository.findAll();
		return StreamSupport.stream(applications.spliterator(), false).collect(Collectors.toList());
	}

	public void addApplication(Application application) {
		applicationRepository.save(application);
	}

	public void deleteApplication(Application application) {
		applicationRepository.delete(application);
	}

	public void editApplication(Application application) {
		applicationRepository.save(application);
	}
	
	public Application getApplicationById(int applicationId) {
		return applicationRepository.findById(applicationId).get();
	}
}
