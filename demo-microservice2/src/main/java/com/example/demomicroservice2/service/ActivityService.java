package com.example.demomicroservice2.service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demomicroservice2.dao.ActivityRepository;
import com.example.demomicroservice2.domain.Activity;

@Service
public class ActivityService {

	@Autowired
	ActivityRepository activityRepository;

	public List<Activity> getAllActivities() {
		System.out.println("Activity Repository :: Fetching all activities");
		Iterable<Activity> activities = activityRepository.findAll();
		return StreamSupport.stream(activities.spliterator(), false).collect(Collectors.toList());
	}

	public void addActivity(Activity activity) {
		activityRepository.save(activity);
	}

	public void deleteActivity(Activity activity) {
		activityRepository.delete(activity);
	}

	public void editActivity(Activity activity) {
		activityRepository.save(activity);
	}
	
	public Activity getActivityById(int activityId) {
		return activityRepository.findById(activityId).get();
	}
	
	/*
	 * Batch Operations
	 */
	
	public void editAllActivities(List<Activity> activities) {
		for(Activity activity : activities) {
			activityRepository.save(activity);
		}
	
	}
	
	public void addAllActivities(List<Activity> activities) {
		activityRepository.saveAll(activities);
	}
	
	public void saveActivityWithRound(String activity_info_name, int form_master_id, int form_Activity_Order, String form_status, Date last_update_date,
			   int round_Id) {
		
		activityRepository.saveActivityWithRound(activity_info_name, form_master_id, form_Activity_Order, form_status, last_update_date, round_Id);
	}

}
