/**
 * 
 */
package com.example.demomicroservice2.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demomicroservice2.dao.ActivityContextRepository;
import com.example.demomicroservice2.domain.ActivityContext;
import com.example.demomicroservice2.domain.Question;

/**
 * @author juhi.b.jain
 *
 */
@Service
public class ActivityContextService {
	@Autowired
	ActivityContextRepository activityContextRepository;
	
	public List<ActivityContext> getAllActivityContexts() {
		Iterable<ActivityContext> activityContexts = activityContextRepository.findAll();
		return StreamSupport.stream(activityContexts.spliterator(), false).collect(Collectors.toList());
	}

	public void addActivityContext(ActivityContext activityContext) {
		activityContextRepository.save(activityContext);
	}

	public void deleteActivityContext(Integer activityContextId) throws Exception {
		Optional<ActivityContext> activityContext = activityContextRepository.findById(activityContextId);
		if(activityContext.isPresent()) {
			System.out.println("Activity Context is present");
		activityContextRepository.deleteById(activityContextId);
		}
		else
		{
			throw new Exception("Activity Context not present");
		}
	}

	public void editActivityContext(ActivityContext activityContext) {
		activityContextRepository.save(activityContext);
	}
	
	public ActivityContext getActivityContextById(int activityContextId) {
		return activityContextRepository.findById(activityContextId).get();
	}
	
	public List<ActivityContext> getActivityContextByTypeId(int activityInfoId , int typeId) {
		Iterable<ActivityContext> activityContextsByType = activityContextRepository.findByActivityInfoIdAndTypeId(activityInfoId,typeId);
		return StreamSupport.stream(activityContextsByType.spliterator(), false).collect(Collectors.toList());
	}
	
}
