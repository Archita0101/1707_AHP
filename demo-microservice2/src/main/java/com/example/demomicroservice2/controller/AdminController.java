/**
 * 
 */
package com.example.demomicroservice2.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demomicroservice2.AppUtility;
import com.example.demomicroservice2.dao.QuestionTypeRepository;
import com.example.demomicroservice2.domain.Activity;
import com.example.demomicroservice2.domain.ActivityContext;
import com.example.demomicroservice2.domain.ContextTemplate;
import com.example.demomicroservice2.domain.Question;
import com.example.demomicroservice2.domain.QuestionTransferObject;
import com.example.demomicroservice2.domain.QuestionType;
import com.example.demomicroservice2.domain.Round;
import com.example.demomicroservice2.domain.Template;
import com.example.demomicroservice2.domain.TemplateQuestions;
import com.example.demomicroservice2.domain.TemplateTransferObject;
import com.example.demomicroservice2.domain.TransferObject;
import com.example.demomicroservice2.service.ActivityContextService;
import com.example.demomicroservice2.service.ActivityService;
import com.example.demomicroservice2.service.ApplicationService;
import com.example.demomicroservice2.service.ContextTemplateService;
import com.example.demomicroservice2.service.FormService;
import com.example.demomicroservice2.service.QuestionService;
import com.example.demomicroservice2.service.RoundService;
import com.example.demomicroservice2.service.TemplateQuestionService;
import com.example.demomicroservice2.service.TemplateService;

/**
 * @author juhi.b.jain This controller is the Admin controller. Requests to
 *         perform CRUD operations on the below are mapped here: 1. Application
 *         2. Form 3. Activity 4. ActivityContext 5. Question 6. Round
 */

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	private static Map mpRound = new HashMap();

	@Autowired
	ActivityService activityService;

	@Autowired
	QuestionService questionService;

	@Autowired
	FormService formService;

	@Autowired
	ApplicationService applicationService;

	@Autowired
	ActivityContextService activityContextService;

	@Autowired
	RoundService roundService;

	@Autowired
	TemplateQuestionService templateQuestionService;

	@Autowired
	TemplateService templateService;

	@Autowired
	ContextTemplateService contextTemplateService;
	
	@Autowired
	QuestionTypeRepository questionTypeRepository;

	/*
	 * APPLICATIONS
	 * 
	 */
	/*
	 * @RequestMapping(value = "/applications", method = RequestMethod.GET, produces
	 * = "application/json")
	 * 
	 * @ResponseBody public List<Application> getAllApplications() {
	 * List<Application> applications = applicationService.getAllApplications();
	 * System.out.println("Returning REsponse with :: " + applications.size() +
	 * " activities"); return applications; }
	 * 
	 * @RequestMapping(value = "/applications/{id}", method = RequestMethod.GET,
	 * produces = "application/json")
	 * 
	 * @ResponseBody public Application getApplication(@PathParam("id") int
	 * applicationId) { return applicationService.getApplicationById(applicationId);
	 * }
	 * 
	 * @RequestMapping(value = "/applications", method = RequestMethod.POST,
	 * produces = "application/json")
	 * 
	 * @ResponseBody public ResponseEntity<Application> addApplication(@RequestBody
	 * Application application) { try {
	 * applicationService.addApplication(application); return
	 * ResponseEntity.status(HttpStatus.OK).body(application); } catch (Exception
	 * exception) {
	 * 
	 * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } finally { }
	 * }
	 * 
	 * @RequestMapping(value = "/applications", method = RequestMethod.DELETE,
	 * produces = "application/json")
	 * 
	 * @ResponseBody public void deleteApplication(@RequestBody Application
	 * application) { applicationService.deleteApplication(application); }
	 * 
	 * @RequestMapping(value = "/applications", method = RequestMethod.PUT, produces
	 * = "application/json")
	 * 
	 * @ResponseBody public void editApplication(@RequestBody Application
	 * application) { applicationService.editApplication(application); }
	 */

	/*
	 * FORMS
	 * 
	 */
	/*
	 * @RequestMapping(value = "/forms", method = RequestMethod.GET, produces =
	 * "application/json")
	 * 
	 * @ResponseBody public List<Form> getAllForms() { return
	 * formService.getForms(); }
	 * 
	 * @RequestMapping(value = "/forms/{id}", method = RequestMethod.GET, produces =
	 * "application/json")
	 * 
	 * @ResponseBody public Form getForm(@PathParam("id") int formId) { return
	 * formService.getFormById(formId); }
	 * 
	 * @RequestMapping(value = "/forms", method = RequestMethod.POST, produces =
	 * "application/json")
	 * 
	 * @ResponseBody public ResponseEntity<Form> addForm(@RequestBody Form form) {
	 * try { formService.createNewForm(form); return
	 * ResponseEntity.status(HttpStatus.OK).body(form); } catch (Exception
	 * exception) {
	 * 
	 * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } finally { }
	 * }
	 * 
	 * @RequestMapping(value = "/forms", method = RequestMethod.DELETE, produces =
	 * "application/json")
	 * 
	 * @ResponseBody public void deleteForm(@RequestBody Form form) {
	 * formService.deleteForm(form); }
	 * 
	 * @RequestMapping(value = "/forms", method = RequestMethod.PUT, produces =
	 * "application/json")
	 * 
	 * @ResponseBody public void editForm(@RequestBody Form form) {
	 * formService.editForm(form); }
	 */

	/*
	 * ACTIVITIES
	 */
	/**
	 * Gets all activities
	 */
	@RequestMapping(value = "/activities", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Activity> getAllActivities() {
		System.out.println(" Admin Controller :: getAllActivities");
		List<Activity> activities = activityService.getAllActivities();

		/*
		 * for(Activity activity : activities) {
		 * activity.setActivityContextListByRental(activityContextService.
		 * getActivityContextByTypeId(1));
		 * activity.setActivityContextListByOwner(activityContextService.
		 * getActivityContextByTypeId(2)); }
		 */
		activities = listActivityContextsByType(activities);
		System.out.println("Returning REsponse with :: " + activities.size() + " activities");
		return activities;
	}

	List<Activity> listActivityContextsByType(List<Activity> activities) {
		List<Activity> activitiesNew = new ArrayList<Activity>();
		for (Activity activity : activities) {
			activity.setActivityContextListByRental(activityContextService.getActivityContextByTypeId(activity.getActivityId(),1));
			activity.setActivityContextListByOwner(activityContextService.getActivityContextByTypeId(activity.getActivityId(),2));
			activitiesNew.add(activity);
		}
		return activitiesNew;
	}

	Set<Activity> setActivityContextsByType(Set<Activity> activities) {
		Set<Activity> activitiesNew = new HashSet<Activity>();
		for (Activity activity : activities) {
			activity.setActivityContextListByRental(activityContextService.getActivityContextByTypeId(activity.getActivityId(),1));
			activity.setActivityContextListByOwner(activityContextService.getActivityContextByTypeId(activity.getActivityId(),2));
			activitiesNew.add(activity);
		}
		return activitiesNew;
	}

	/**
	 * @param activityId
	 * @return Gets activity details for a particular activity
	 */

	@RequestMapping(value = "/activity/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Activity getActivity(@PathVariable("id") int activityId) {
		Activity activity =  activityService.getActivityById(activityId);
		List<Activity> activitylist = new ArrayList<Activity>();
		activitylist.add(activity);
		List<Activity> activities = listActivityContextsByType(activitylist);
		return activities.get(0);
	}

	//Leave as of now
	@RequestMapping(value = "/activityById/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<TransferObject> getActivityJson(@PathVariable("id") int activityId) {
		List<TransferObject> transferObjects = new ArrayList<TransferObject>();
		Activity activity = activityService.getActivityById(activityId);

		Set<ActivityContext> contexts = activity.getActivityContext();
		for (ActivityContext currentContext : contexts) {
			TransferObject object = new TransferObject();
			System.out.println("In controller :: " + object.getOptionsList().size());
			object.setFieldId(currentContext.getActivityContextId());
			object.setLabel(currentContext.getActivityContextTitle());
			object.setIndex(String.valueOf(currentContext.getActivityContextId()));
			object.setParentId(null);
			object.setCategory("main");
			transferObjects.add(object);
			for (Question question : currentContext.getQuestion()) {
				TransferObject questionObject = new TransferObject();
				questionObject.setFieldId(question.getQuestion_ID());
				questionObject.setType("select");
				questionObject.setLabel(question.getQuestionValue());
				questionObject.setIndex(question.getQuestionOrder());
				questionObject.setInputType("select");
				// questionObject.setKeyName(question.get);

				questionObject.setParentId(String.valueOf(currentContext.getActivityContextId()));
				questionObject.setCategory("sub");
				questionObject.setRuleApplicable(question.getIsRuleApplicable());
				transferObjects.add(questionObject);

			}
		}
		return transferObjects;
	}

	/**
	 * @param activities
	 * @return Creates a list of new activities
	 */
	@RequestMapping(value = "/activities", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<List<Activity>> addActivities(@RequestBody List<Activity> activities) {
		try {
			activityService.addAllActivities(activities);
			System.out.println("Returning Response with " + activities.size() + " number of questions");
			return ResponseEntity.status(HttpStatus.OK).body(activities);
		} catch (Exception exception) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
		}
	}

	/**
	 * @param activities
	 * @return To update list of activities
	 */
	@RequestMapping(value = "/activities", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<List<Activity>> editActivities(@RequestBody List<Activity> activities) {
		try {
			activityService.editAllActivities(activities);
			System.out.println("Returning Response with " + activities.size() + " number of questions");
			return ResponseEntity.status(HttpStatus.OK).body(activities);
		} catch (Exception exception) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
		}
	}

	/**
	 * @param activities
	 * @return Deletes an activity
	 */
	@RequestMapping(value = "/activities", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Activity> deleteActivity(@RequestBody Activity activities) {
		try {
			activityService.deleteActivity(activities);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception exception) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
		}
	}

	/*
	 * ACTIVITY CONTEXTS
	 * 
	 */
	/**
	 * @return Gets all activity contexts
	 */
	@RequestMapping(value = "/activityContexts", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ActivityContext> getAllActivityContexts() {
		return activityContextService.getAllActivityContexts();
	}

	/**
	 * @param activityContextId
	 * @return Gets activity context information for a single activity context
	 */
	@RequestMapping(value = "/activityContexts/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ActivityContext getActivityContext(@PathVariable("id") int activityContextId) {
		return activityContextService.getActivityContextById(activityContextId);
	}

	@RequestMapping(value = "/activityContexts", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<ActivityContext> addActivityContext(@RequestBody ActivityContext activityContext) {
		try {
			activityContextService.addActivityContext(activityContext);
			return ResponseEntity.status(HttpStatus.OK).body(activityContext);
		} catch (Exception exception) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
		}
	}

	/**
	 * @param activityContext Deletes an activity context
	 */
	@RequestMapping(value = "/activityContexts/{id}", method = RequestMethod.DELETE) // , produces = "application/json"
	@ResponseBody
	public void deleteActivityContext(@PathVariable("id") int activityContextId) throws Exception {
		System.out.println("Deleting in controller :: >> " + activityContextId);
		activityContextService.deleteActivityContext(activityContextId);
	}

	/**
	 * @param activityContext Edit an activity context
	 */
	@RequestMapping(value = "/activityContexts", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public void editActivityContext(@RequestBody ActivityContext activityContext) {
		activityContextService.editActivityContext(activityContext);
	}

	/*
	 * QUESTIONS
	 */
	/**
	 * @return Gets all questions
	 */
	@RequestMapping(value = "/questions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Question> getAllQuestions() {
		return questionService.getQuestions();
	}

	@RequestMapping(value = "/templateQuestions/{id}/{activityId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public TemplateTransferObject getQuestionsByTemplateId(@PathVariable("id") int templateId,
			@PathVariable("activityId") int activityId) {
		TemplateTransferObject qto = new TemplateTransferObject();
		if (templateId <= 2) {
			List<TemplateQuestions> tempQuesList = templateQuestionService.getTemplateQuestionsByTemplateId(templateId);
			// qto.setQuestion(tempQuesList );
			List<ActivityContext> tempActivityContextList = new ArrayList<ActivityContext>();
			for (TemplateQuestions tempQues : tempQuesList) {
				ActivityContext activityContext = new ActivityContext();
				Set<Question> questSet = new HashSet<Question>();
				Question question = new Question();
				question.setAdditionalButton(tempQues.getAdditionalButton());
				question.setAnswerFieldType(tempQues.getAnswerFieldType());
				question.setIsRuleApplicable(tempQues.getIsRuleApplicable());
				question.setOptionsValue(tempQues.getOptionsValue());
				question.setQuestionOrder(tempQues.getQuestionOrder());
				question.setQuestionValue(tempQues.getQuestionValue());
				question.setVisibleButton(tempQues.isVisibleButton());
				question.setQuestion_ID(tempQues.getQuestion_ID());
				questSet.add(question);

				activityContext.setQuestion(questSet);
				activityContext.setActivityContextTitle(tempQues.getContextTitle());
				tempActivityContextList.add(activityContext);
			}
			qto.setActivityContextList(tempActivityContextList);
		} else {
			// templateId = templateId - 2;
			// fetch details from roun
			activityId = activityId - 2;
			Activity activity = activityService.getActivityById(activityId);
			qto.setActivityContextList(new ArrayList<ActivityContext>(activity.getActivityContext()));
			qto.setRoundId(templateId);
			qto.setActivityId(activityId);

		}
		return qto;

	}

	@RequestMapping(value = "/templates", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Template> getAllTemplates() {
		// return templateService.getTemplates();
		List<Template> lstTemplates = templateService.getTemplates();

		List<Round> lstRound = roundService.getRoundTemplateNames();
		for (Round round : lstRound) {
			Template template = new Template();
			template.setTemplateName(round.getRoundName());
			template.setTemplateId(round.getRoundId());
			lstTemplates.add(template);
		}
		return lstTemplates;
	}

	/**
	 * @param activityId
	 * @return Get Question detail by id
	 */
	@RequestMapping(value = "/question/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Question getQuestionById(@PathVariable("id") int activityId) {
		return questionService.getQuestionById(activityId);
	}

	/*
	 * @RequestMapping(value = "/questionsByActivityId/{id}", method =
	 * RequestMethod.GET, produces = "application/json")
	 * 
	 * @ResponseBody public List<Question> questionsByActivityId(@PathVariable("id")
	 * Integer activityId) { return
	 * questionService.findQuestionsByActivityId(activityId); }
	 */

	/*
	 * @RequestMapping(value = "/questions", method = RequestMethod.PUT, produces =
	 * "application/json")
	 * 
	 * @ResponseBody public ResponseEntity<List<Question>>
	 * editQuestions(@RequestBody List<Question> questions) { try {
	 * questionService.editAllQuestions(questions);
	 * System.out.println("Returning Response with " + questions.size() +
	 * " number of questions"); return
	 * ResponseEntity.status(HttpStatus.OK).body(questions); } catch (Exception
	 * exception) {
	 * 
	 * return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } finally { }
	 * }
	 */

	/*
	 * ROUNDS
	 */

	/**
	 * @ return Gets all Rounds
	 */
	@RequestMapping(value = "/rounds", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Round> getAllRounds() {
		List<Round> rounds = roundService.getRounds();
		List<Round> newRounds = new ArrayList<Round>();
		for (Round round : rounds) {
			Set<Activity> newActivities = setActivityContextsByType(round.getActivities());
			round.setActivities(newActivities);
			newRounds.add(round);
		}
		return newRounds;
	}

	/**
	 * @param status
	 * @return Gets all rounds by status Status can be : active draft closed
	 */
	@RequestMapping(value = "/rounds/{status}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Round> getRoundsByStatus(@PathVariable("status") String status) {
		List<Round> rounds = roundService.getRoundsByStatus(status);
		List<Round> newRounds = new ArrayList<Round>();
		for (Round round : rounds) {
			Set<Activity> newActivities = setActivityContextsByType(round.getActivities());
			round.setActivities(newActivities);
			newRounds.add(round);
		}
		return newRounds;
	}

	/**
	 * @param roundId
	 * @return Get detailed information of a single round
	 */
	@RequestMapping(value = "/roundsById/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Round getRound(@PathVariable("id") int roundId) {
		Round round = roundService.getRoundById(roundId);
		Set<Activity> newActivities = setActivityContextsByType(round.getActivities());
		round.setActivities(newActivities);
		return round;
	}

	/**
	 * @param round
	 * @return Add a new Round. A round will always be saved with draft status and
	 *         with start date as Todays date
	 */
	@RequestMapping(value = "/rounds", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Round> addRound(@RequestBody Round round) {
		try {
			round.setRoundStatus("draft");
			Round roundNew = roundService.createNewRound(round);

			// Changed the activity title and form activity order
			activityService.saveActivityWithRound("E-form Scoring", 1, 1, "Complete",
					new Date(System.currentTimeMillis()), roundNew.getRoundId());
			activityService.saveActivityWithRound("Eligibility & Scoring Verification", 1, 2, "Complete",
					new Date(System.currentTimeMillis()), roundNew.getRoundId());
			activityService.saveActivityWithRound("Financial Review", 1, 3, "Complete",
					new Date(System.currentTimeMillis()), roundNew.getRoundId());

			Round roundResponse = roundService.getRoundById(roundNew.getRoundId());

			return ResponseEntity.status(HttpStatus.OK).body(roundResponse);
		} catch (Exception exception) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
		}
	}

	/**
	 * @param round Deletes a Round
	 */
	@RequestMapping(value = "/rounds", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public void deleteRound(@RequestBody Round round) {
		roundService.deleteRound(round);
	}

	/**
	 * @param round Edit Round specific information
	 */
	@RequestMapping(value = "/rounds", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public void editRound(@RequestBody Round round) {
		/*
		 * mpRound.put(round.getRoundId(), round); if (1==1) { return; }
		 */
		//int i = 0;
		System.out.println("roundId>>>" + round.getRoundId());
		/*
		 * Set<Activity> lstActivities= new HashSet(); for (Activity activity :
		 * round.getActivities()) { activity.setRound(round);
		 * lstActivities.add(activity); } round.setActivities(lstActivities);
		 */

		
		for (Activity activity : round.getActivities()) {
			
			/*
			 * Round roundReference = new Round();
			 * 
			 * roundReference.setRoundId(round.getRoundId());
			 * roundReference.setRoundName(round.getRoundName());
			 * roundReference.setStartDate(round.getStartDate());
			 * roundReference.setRoundStatus(round.getRoundStatus());
			 * roundReference.setRetentionPeriod(round.getRetentionPeriod());
			 * roundReference.setProgressCredence(round.getProgressCredence());
			 * roundReference.setOwnerOccupiedRetentionPeriod(round.
			 * getOwnerOccupiedRetentionPeriod());
			 * roundReference.setEndDate(round.getEndDate());
			 * roundReference.setActivities(round.getActivities());
			 * 
			 * System.out.println("roundId>>>" + roundReference.getRoundId());
			 */
			Round roundNew = roundService.getRoundById(round.getRoundId());
			activity.setRound(roundNew);
			//if (i ==0 ) { roundService.editRound(roundReference); } i = i + 1;
			 
			roundService.editRound(roundNew);
			
			List<Question> questions = new ArrayList<Question>();
			
			/*
			 * for (ActivityContext activityContext : activity.getActivityContext()) {
			 * activityContext.setActivity(activity);
			 * 
			 * for (Question question : activityContext.getQuestion()) {
			 * question.setActivityContext(activityContext); questions.add(question); }
			 * activityContextService.addActivityContext(activityContext); }
			 */
			
			if(null!=activity.getActivityContextListByRental() && activity.getActivityContextListByRental().size()>0) {
			for (ActivityContext activityContext : activity.getActivityContextListByRental()) {
				activityContext.setActivity(activity);
				activityContext.setQuestionType(questionTypeRepository.findById(1).get());
				for (Question question : activityContext.getQuestion()) {
					question.setActivityContext(activityContext);
					question.setQuestionType(questionTypeRepository.findById(1).get());
					questions.add(question);
				}
				activityContextService.addActivityContext(activityContext);
			}
			}
			
			if(null!=activity.getActivityContextListByOwner() && activity.getActivityContextListByOwner().size()>0) {
			for (ActivityContext activityContext : activity.getActivityContextListByOwner()) {
				activityContext.setActivity(activity);
				activityContext.setQuestionType(questionTypeRepository.findById(2).get());
				for (Question question : activityContext.getQuestion()) {
					question.setActivityContext(activityContext);
					question.setQuestionType(questionTypeRepository.findById(2).get());
					questions.add(question);
				}
				activityContextService.addActivityContext(activityContext);
			}
			}	
			
			//questionService.editAllQuestions(questions);
		}
		
		
		//roundService.editRound(round);
	}

	@RequestMapping(value = "/questions", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public void addQuestions(@RequestBody QuestionTransferObject questionTransferObject) {
		int roundId = questionTransferObject.getRoundId();
		int activityId = questionTransferObject.getActivityId();

		//List<ActivityContext> list = questionTransferObject.getActivityContextListByOwner();
		//list.addAll(questionTransferObject.getActivityContextListByRental());
		
		/*
		 * for (ActivityContext activityContext :
		 * questionTransferObject.getActivityContextListByOwner()) {
		 * activityContext.setActivity(activityService.getActivityById(activityId));
		 * System.out.println("question >>>> " + activityContext.getQuestion().size());
		 * System.out.println("activity context >>>> " +
		 * activityContext.getActivityContextId());
		 * questionService.deleteQuestionsByContextId(activityContext.
		 * getActivityContextId()); QuestionType questionType =
		 * questionTypeRepository.findById(2).get();
		 * activityContext.setQuestionType(questionType); for (Question question :
		 * activityContext.getQuestion()) {
		 * question.setAdditionalButton("TestAdditionalButton");
		 * //question.setAnswerFieldType("select");
		 * question.setIsRuleApplicable("false"); question.setOptionsValue("YES:NO");
		 * question.setVisibleButton(true);
		 * question.setActivityContext(activityContext);
		 * question.setQuestionType(questionType); //
		 * questionService.editQuestion(question); }
		 * activityContextService.editActivityContext(activityContext); } for
		 * (ActivityContext activityContext :
		 * questionTransferObject.getActivityContextListByRental()) {
		 * activityContext.setActivity(activityService.getActivityById(activityId));
		 * System.out.println("question >>>> " + activityContext.getQuestion().size());
		 * System.out.println("activity context >>>> " +
		 * activityContext.getActivityContextId());
		 * questionService.deleteQuestionsByContextId(activityContext.
		 * getActivityContextId());
		 * 
		 * questionService.deleteQuestionsByContextId(activityContext.
		 * getActivityContextId()); QuestionType questionType =
		 * questionTypeRepository.findById(1).get();
		 * activityContext.setQuestionType(questionType); for (Question question :
		 * activityContext.getQuestion()) {
		 * question.setAdditionalButton("TestAdditionalButton");
		 * question.setAnswerFieldType("select"); question.setIsRuleApplicable("false");
		 * question.setOptionsValue("YES:NO"); question.setVisibleButton(true);
		 * question.setActivityContext(activityContext);
		 * question.setQuestionType(questionType); //
		 * questionService.editQuestion(question); }
		 * activityContextService.editActivityContext(activityContext); }
		 */

		if(questionTransferObject != null && questionTransferObject.getActivityContextListByOwner() != null && questionTransferObject.getActivityContextListByOwner().size() > 0) {
			//list = questionTransferObject.getActivityContextListByOwner();
			for (ActivityContext activityContext : questionTransferObject.getActivityContextListByOwner()) {
				activityContext.setActivity(activityService.getActivityById(activityId));
				System.out.println("question >>>> " + activityContext.getQuestion().size());
				System.out.println("activity context >>>> " + activityContext.getActivityContextId());
				activityContext.setQuestionType(questionTypeRepository.findById(2).get());
				for (Question question : activityContext.getQuestion()) {
					question.setAdditionalButton("TestAdditionalButton");
					question.setAnswerFieldType("select");
					question.setIsRuleApplicable("false");
					question.setOptionsValue("YES:NO");
					question.setVisibleButton(true);
					question.setActivityContext(activityContext);
					question.setQuestionType(questionTypeRepository.findById(2).get());
					// questionService.addQuestion(question);
				}
				// activityContextService.editActivityContext(activityContext);
				activityContextService.editActivityContext(activityContext);
			//}
			}
		}
		if(questionTransferObject != null && questionTransferObject.getActivityContextListByRental() != null && questionTransferObject.getActivityContextListByRental().size() > 0) {
			//list.addAll(questionTransferObject.getActivityContextListByRental());
			for (ActivityContext activityContext : questionTransferObject.getActivityContextListByRental()) {
				activityContext.setActivity(activityService.getActivityById(activityId));
				System.out.println("question >>>> " + activityContext.getQuestion().size());
				System.out.println("activity context >>>> " + activityContext.getActivityContextId());
				activityContext.setQuestionType(questionTypeRepository.findById(1).get());
				for (Question question : activityContext.getQuestion()) {
					question.setAdditionalButton("TestAdditionalButton");
					question.setAnswerFieldType("select");
					question.setIsRuleApplicable("false");
					question.setOptionsValue("YES:NO");
					question.setVisibleButton(true);
					question.setActivityContext(activityContext);
					question.setQuestionType(questionTypeRepository.findById(1).get());
					// questionService.addQuestion(question);
				}
				// activityContextService.editActivityContext(activityContext);
				activityContextService.editActivityContext(activityContext);
			//}
			}
		}
	}

	@RequestMapping(value = "/questions", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public void updateQuestions(@RequestBody QuestionTransferObject questionTransferObject) {
		int roundId = questionTransferObject.getRoundId();
		int activityId = questionTransferObject.getActivityId();

		//List<ActivityContext> list = new ArrayList<ActivityContext>();
		
		if(questionTransferObject != null && questionTransferObject.getActivityContextListByOwner() != null && questionTransferObject.getActivityContextListByOwner().size() > 0) {
			//list = questionTransferObject.getActivityContextListByOwner();
			for (ActivityContext activityContext : questionTransferObject.getActivityContextListByOwner()) {
				activityContext.setActivity(activityService.getActivityById(activityId));
				System.out.println("question >>>> " + activityContext.getQuestion().size());
				System.out.println("activity context >>>> " + activityContext.getActivityContextId());
				activityContext.setQuestionType(questionTypeRepository.findById(2).get());
				for (Question question : activityContext.getQuestion()) {
					question.setAdditionalButton("TestAdditionalButton");
					question.setAnswerFieldType("select");
					question.setIsRuleApplicable("false");
					question.setOptionsValue("YES:NO");
					question.setVisibleButton(true);
					question.setActivityContext(activityContext);
					question.setQuestionType(questionTypeRepository.findById(2).get());
					// questionService.addQuestion(question);
				}
				// activityContextService.editActivityContext(activityContext);
				activityContextService.addActivityContext(activityContext);
			//}
			}
		}
		if(questionTransferObject != null && questionTransferObject.getActivityContextListByRental() != null && questionTransferObject.getActivityContextListByRental().size() > 0) {
			//list.addAll(questionTransferObject.getActivityContextListByRental());
			for (ActivityContext activityContext : questionTransferObject.getActivityContextListByRental()) {
				activityContext.setActivity(activityService.getActivityById(activityId));
				System.out.println("question >>>> " + activityContext.getQuestion().size());
				System.out.println("activity context >>>> " + activityContext.getActivityContextId());
				activityContext.setQuestionType(questionTypeRepository.findById(1).get());
				for (Question question : activityContext.getQuestion()) {
					question.setAdditionalButton("TestAdditionalButton");
					question.setAnswerFieldType("select");
					question.setIsRuleApplicable("false");
					question.setOptionsValue("YES:NO");
					question.setVisibleButton(true);
					question.setActivityContext(activityContext);
					question.setQuestionType(questionTypeRepository.findById(1).get());
					// questionService.addQuestion(question);
				}
				// activityContextService.editActivityContext(activityContext);
				activityContextService.addActivityContext(activityContext);
			//}
			}
		}


		//list.addAll(questionTransferObject.getActivityContextListByRental());
		/*
		 * for (ActivityContext activityContext : list) {
		 * activityContext.setActivity(activityService.getActivityById(activityId));
		 * System.out.println("question >>>> " + activityContext.getQuestion().size());
		 * System.out.println("activity context >>>> " +
		 * activityContext.getActivityContextId());
		 * 
		 * for (Question question : activityContext.getQuestion()) {
		 * question.setAdditionalButton("TestAdditionalButton");
		 * question.setAnswerFieldType("select"); question.setIsRuleApplicable("false");
		 * question.setOptionsValue("YES:NO"); question.setVisibleButton(true);
		 * question.setActivityContext(activityContext);
		 * 
		 * // questionService.addQuestion(question); } //
		 * activityContextService.editActivityContext(activityContext);
		 * activityContextService.addActivityContext(activityContext); //} }
		 */

	}

	@RequestMapping(value = "/questions", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public void deleteQuestions(@RequestBody QuestionTransferObject questionTransferObject) {

		int roundId = questionTransferObject.getRoundId();
		int activityId = questionTransferObject.getActivityId();

		for (ActivityContext activityContext : questionTransferObject.getActivityContextList()) {
			activityContext.setActivity(activityService.getActivityById(activityId));
			System.out.println("question >>>> " + activityContext.getQuestion().size());
			System.out.println("activity context >>>> " + activityContext.getActivityContextId());

			for (Question question : activityContext.getQuestion()) {
				question.setAdditionalButton("TestAdditionalButton");
				question.setAnswerFieldType("select");
				question.setIsRuleApplicable("false");
				question.setOptionsValue("YES:NO");
				question.setVisibleButton(true);
				question.setActivityContext(activityContext);

				question.setActivityContext(activityContext);
				questionService.deleteQuestion(question);
			}
			// activityContextService.deleteActivityContext(activityContext);
		}

	}

	/*
	 * @RequestMapping(value = "/testFile", method = RequestMethod.GET, produces =
	 * "application/json")
	 * 
	 * @ResponseBody public void testFileUpload(){ List<ContextTemplate>
	 * contextTemplateList = AppUtility.uploadCSVFile(); for(ContextTemplate
	 * contextTemplate : contextTemplateList){
	 * contextTemplateService.deleteByTemplateName(contextTemplate.getTemplateName()
	 * ); }
	 * 
	 * for(ContextTemplate contextTemplate : contextTemplateList){
	 * contextTemplateService.addContextTemplate(contextTemplate); } }
	 */

	@RequestMapping(value = "/contextFileUpload", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

		String message = null;
		HttpStatus httpStatus = HttpStatus.OK;
		File importedFile = null;
		try {
			InputStream in = file.getInputStream();
			File currDir = new File(".");
			String path = currDir.getAbsolutePath();
			String fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();

			FileOutputStream fileOutputStream = new FileOutputStream(fileLocation);
			int chunk = 0;
			while ((chunk = in.read()) != -1) {
				fileOutputStream.write(chunk);
			}
			fileOutputStream.flush();
			fileOutputStream.close();

			// importedFile = new File(fileLocation);

			List<ContextTemplate> contextTemplateList = AppUtility.uploadCSVFile(fileLocation);

			for (ContextTemplate contextTemplate : contextTemplateList) {
				contextTemplateService.deleteByTemplateName(contextTemplate.getTemplateName());
			}

			for (ContextTemplate contextTemplate : contextTemplateList) {
				contextTemplateService.addContextTemplate(contextTemplate);
			}

			message = "Success";

		} catch (Exception e) {
			e.printStackTrace();
			message = "Error while file uploading!";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		} finally {
			if (importedFile != null && importedFile.exists()) {
				importedFile.delete();
			}
		}
		return ResponseEntity.status(httpStatus).body(message);

	}

	/*
	 * @RequestMapping(value = "/questionFileUpload", method = RequestMethod.POST,
	 * consumes = "multipart/form-data", produces = "application/json")
	 * 
	 * @ResponseBody public ResponseEntity<String>
	 * uploadQuestionFile(@RequestParam("file") MultipartFile file) throws
	 * IOException {
	 * 
	 * String message = null; HttpStatus httpStatus = HttpStatus.OK; File
	 * importedFile = null; try { InputStream in = file.getInputStream(); File
	 * currDir = new File("."); String path = currDir.getAbsolutePath(); String
	 * fileLocation = path.substring(0, path.length() - 1) +
	 * file.getOriginalFilename();
	 * 
	 * FileOutputStream fileOutputStream = new FileOutputStream(fileLocation); int
	 * chunk = 0; while ((chunk = in.read()) != -1) { fileOutputStream.write(chunk);
	 * } fileOutputStream.flush(); fileOutputStream.close();
	 * 
	 * // importedFile = new File(fileLocation);
	 * 
	 * List<ContextTemplate> contextTemplateList =
	 * AppUtility.uploadCSVFile(fileLocation);
	 * 
	 * 
	 * for(ContextTemplate contextTemplate : contextTemplateList){
	 * contextTemplateService.deleteByTemplateName(contextTemplate.getTemplateName()
	 * ); }
	 * 
	 * for(ContextTemplate contextTemplate : contextTemplateList){
	 * contextTemplateService.addContextTemplate(contextTemplate); }
	 * 
	 * 
	 * message = "Success" ;
	 * 
	 * } catch (Exception e) { e.printStackTrace(); message =
	 * "Error while file uploading!"; httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	 * } finally { if(importedFile != null && importedFile.exists()) {
	 * importedFile.delete(); } } return
	 * ResponseEntity.status(httpStatus).body(message);
	 * 
	 * }
	 */
}
