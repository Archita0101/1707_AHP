
INSERT INTO question (question_value, question_answer, comment) VALUES
  ('Is this Question 1', true , 'This is question number 1'),
  ('Is this Question 5', false, 'This is question number 2'),
  ('Is this Question 3', true, 'This is question number 3');


INSERT INTO application_master (app_name, sponsor, project_type,subsidy_request,location,last_update_date) VALUES
 ('Riverdale gardens original', 'Affordable Housing Association of New Jersey' , 'Rental','$23700','NY',TO_DATE('17/12/2015', 'DD/MM/YYYY')),
  ('Riverdale gardens2', 'Affordable Housing Association of New Jersey' , 'Rental','$23700','NY',TO_DATE('17/12/2015', 'DD/MM/YYYY'));
  

INSERT INTO user (user_id, user_name, email,last_update_date) VALUES
  (1, 'Tukaram', 'abc@pqr.com' , TO_DATE('17/12/2015', 'DD/MM/YYYY')),
  (2, 'Trilok', 'pqr@abc.com' , TO_DATE('17/12/2015', 'DD/MM/YYYY'));


INSERT INTO application_user (user_id, app_id,last_update_date) VALUES
  (1, 1 , TO_DATE('17/12/2015', 'DD/MM/YYYY')),
  (2, 1 , TO_DATE('17/12/2015', 'DD/MM/YYYY'));


INSERT INTO form_master (form_name,last_update_date) VALUES
  ('Eligibility & Scoring', TO_DATE('17/12/2015', 'DD/MM/YYYY')),
  ('Financial Review', TO_DATE('17/12/2015', 'DD/MM/YYYY'));

  
INSERT INTO question_type (question_type_name) VALUES
  ('Rental'),
  ('Owner');
  
  
 -- INSERT INTO form_context (form_question_title,form_question_heading,form_status,last_update_date) VALUES
  --('Amount, Timing, and Use of Subsidy','Confirm the number of units and targeting goals for use in
--determining project eligibility:','Soft Delete',TO_DATE('17/12/2015', 'DD/MM/YYYY'));



INSERT INTO answer_option (answer_type,answer_details,last_update_date) VALUES
  ('Dropdown','Yes',TO_DATE('17/12/2015', 'DD/MM/YYYY')),
  ('Radio', 'No',TO_DATE('17/12/2015', 'DD/MM/YYYY'));


  
  INSERT INTO item (id, name, category) VALUES (1, 'IPhone 6S', 'Mobile');
  
  INSERT INTO round (round_Name, round_Status, start_Date, end_Date, progress_Credence, retention_Period,owner_Occupied_Rp) VALUES
  ('Round1','active',TO_DATE('03/07/2019', 'DD/MM/YYYY'), TO_DATE('15/07/2019', 'DD/MM/YYYY'), '9 Months' , '12 months','12 months'),
  ('Round2','active' ,TO_DATE('03/07/2019', 'DD/MM/YYYY'), TO_DATE('05/07/2019', 'DD/MM/YYYY'), '9 Months' , '12 months','12 months'),
  ('Round3','draft' ,TO_DATE('03/07/2019', 'DD/MM/YYYY'), TO_DATE('15/07/2019', 'DD/MM/YYYY'), '9 Months' , '12 months','12 months'),
  ('Round4','draft' ,TO_DATE('03/07/2019', 'DD/MM/YYYY'), TO_DATE('05/07/2019', 'DD/MM/YYYY'), '9 Months' , '12 months','12 months'),
  ('Round5','closed' ,TO_DATE('03/01/2019', 'DD/MM/YYYY'), TO_DATE('05/06/2019', 'DD/MM/YYYY'), '9 Months' , '12 months','12 months'),
  ('Round6','closed' ,TO_DATE('03/02/2019', 'DD/MM/YYYY'), TO_DATE('05/06/2019', 'DD/MM/YYYY'), '9 Months' , '12 months','12 months'),
  ('Round7','closed' ,TO_DATE('03/03/2019', 'DD/MM/YYYY'), TO_DATE('05/06/2019', 'DD/MM/YYYY'), '9 Months' , '12 months','12 months');
  
  
  INSERT INTO activity_info (activity_info_name, form_master_id,form_Activity_Order,form_status,last_update_date, round_Id) VALUES
  ('Due Diligence',1, 1,'complete',TO_DATE('17/12/2015', 'DD/MM/YYYY'), 1),
  ('Targeting',1,2,'ongoing',TO_DATE('17/12/2015', 'DD/MM/YYYY'),1),
  ('Amount, Timing, and Use of Subsidy',1,3, 'pending',TO_DATE('17/12/2015', 'DD/MM/YYYY'),2),
  ('Site Control',2,1,'pending',TO_DATE('17/12/2015', 'DD/MM/YYYY'),3),
  ('Donated Property',2,2,'pending',TO_DATE('17/12/2015', 'DD/MM/YYYY'),3);
  
  
  
  INSERT INTO activity_context (activity_context_title,activity_info_id, activity_context_score, activity_context_scoretype,question_type_id,last_update_date) VALUES
  ('Confirm the number of units and targeting goals for use in determining project eligibility',1 ,10,'test1',1 ,TO_DATE('03/07/2019', 'DD/MM/YYYY'));

  INSERT INTO context_questions (context_question_Order,context_question, answer_field_type, is_rule_applicable, options_value, additional_button, is_visible_button ,activity_context_id, score, question_type_id, Last_Updated_Date)
  VALUES
  ('A','Is the Application a request for a supplemental amount of AHP subsidy? If yes, reject the Application and inform management. If no, continue.','select', true, 'YES:NO','TestAdditionalButton','Yes',1, 10 , 1, TO_DATE('03/07/2019', 'DD/MM/YYYY')),
  ('B','Is the Application a resubmission of a previous project that currently have an AHP commitment? If yes, notify management. If no, move forward.','select', false, 'YES:NO','TestAdditionalButton-2','Yes',1, 20, 2,TO_DATE('03/07/2019', 'DD/MM/YYYY'));

  INSERT INTO templates(template_name)VALUES
  ('Rental'),
  ('Owner Occupied');
  
  INSERT INTO template_questions (context_question_Order,context_question, answer_field_type, is_rule_applicable, options_value, additional_button, is_visible_button ,template_Id, Last_Updated_Date,context_Title)
  VALUES
  ('A','The Project is ≥50% occupied, will not displace households or will implement a formal relocation','select', true, 'YES:NO','TestAdditionalButton','Yes',1,TO_DATE('03/07/2019', 'DD/MM/YYYY'), ' Are all of the following true for this project'),
  ('B',' The Project will undergo rehabilitation of housing improvements that average ≥ $15,000 per unit ','select', false, 'YES:NO','TestAdditionalButton-2','Yes',1,TO_DATE('03/07/2019', 'DD/MM/YYYY'),' Are all of the following true for this project'),
	('C','The rehabilitation work will achieve HUD-determined Housing Quality Standards','select', true, 'YES:NO','TestAdditionalButton','Yes',1,TO_DATE('03/07/2019', 'DD/MM/YYYY'), 'Are all of the following true for this project'),
  ('A',' The Project will undergo rehabilitation of housing improvements that average ≥ $15,000 per unit ','select', false, 'YES:NO','TestAdditionalButton-2','Yes',2,TO_DATE('03/07/2019', 'DD/MM/YYYY'),' Are all of the following true for this project'),
	('B','The rehabilitation work will achieve HUD-determined Housing Quality Standards','select', true, 'YES:NO','TestAdditionalButton','Yes',2,TO_DATE('03/07/2019', 'DD/MM/YYYY'), 'Are all of the following true for this project');
  


