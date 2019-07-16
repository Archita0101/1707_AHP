package com.example.demomicroservice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demomicroservice2.dao.ActivityRepository;
import com.example.demomicroservice2.domain.Activity;
import com.example.demomicroservice2.service.ActivityService;

@RunWith(MockitoJUnitRunner.class)
public class ActivityContextServiceTest {

	@InjectMocks
	ActivityService activityService;
	
	@Mock
	ActivityRepository activityRepository;
	
	@Test
	public void addActivityTest() {
		Activity activity = new Activity();
		Mockito.when(activityRepository.save(activity)).thenReturn(activity);
		activityService.addActivity(activity);
		Mockito.verify(activityRepository, Mockito.times(1)).save(activity);
		
	}
	
	@Test
	public void getActivityByIdTest() {
		Activity activity = new Activity();
		int activityId = 1;
		Mockito.when(activityRepository.findById(activityId)).thenReturn(Optional.of(activity));
		activityService.getActivityById(activityId);
		
	}
	
	@Test
	public void getAllActivitiesTest() {
		List<Activity> activities = new ArrayList<Activity>();
		Mockito.when(activityRepository.findAll()).thenReturn(activities);
		activityService.getAllActivities();
	}
	
	@Test
	public void editActivity() {
		Activity activity = new Activity();
		Mockito.when(activityRepository.save(activity)).thenReturn(activity);
		activityRepository.save(activity);
	}
	
	
}
