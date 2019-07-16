
DROP TABLE IF EXISTS question;
 
CREATE TABLE question (
  question_id INT AUTO_INCREMENT,
  question_value CLOB NOT NULL,
  question_answer BOOLEAN NOT NULL,
  comment VARCHAR2(255) DEFAULT NULL,
  PRIMARY KEY (question_id)
);

DROP TABLE IF EXISTS application_master;

CREATE TABLE application_master (
    app_id INT AUTO_INCREMENT,
    app_name VARCHAR2(255) NOT NULL,
    sponsor VARCHAR2(255) NOT NULL,
    project_type VARCHAR2(255) NOT NULL,
    subsidy_request VARCHAR2(255) NOT NULL,
    location VARCHAR2(255) NOT NULL,
    last_update_date DATE,
    PRIMARY KEY (app_id)
);

DROP TABLE IF EXISTS round;

CREATE TABLE round (
    round_Id INT AUTO_INCREMENT,
    round_Name VARCHAR2(255) NOT NULL,
    round_Status VARCHAR2(255) NOT NULL,
   -- associated_Application INT ,
    start_Date DATE,
    end_Date DATE,
    progress_Credence VARCHAR2(255),
    retention_Period VARCHAR2(255),
    owner_Occupied_Rp VARCHAR2(255),
    PRIMARY KEY (round_Id)
    --FOREIGN KEY (associated_Application) REFERENCES application_master (app_id)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    user_id INT AUTO_INCREMENT,
    user_name VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) NOT NULL,
    last_update_date DATE,
    PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS application_user;
CREATE TABLE application_user (
    user_id INT NOT NULL,
    app_id INT NOT NULL, 
    last_update_date DATE,
    PRIMARY KEY (user_id, app_id),
    FOREIGN KEY (app_id) REFERENCES application_master (app_id),
    FOREIGN KEY (user_id) REFERENCES USER (user_id)
);

DROP TABLE IF EXISTS form_master;
CREATE TABLE form_master (
    form_master_id INT AUTO_INCREMENT,
    form_name VARCHAR2(255) NOT NULL, 
    last_update_date DATE,
    PRIMARY KEY (form_master_id)
    
);


DROP TABLE IF EXISTS answer_option;
CREATE TABLE answer_option (
    answer_id INT AUTO_INCREMENT,
    answer_type VARCHAR2(255) NOT NULL,
    answer_details VARCHAR2(255) NOT NULL,
    last_update_date DATE,
    PRIMARY KEY (answer_id)
);

--We can delete this table
DROP TABLE IF EXISTS form_activities;
CREATE TABLE form_activities (
    form_activity_id INT AUTO_INCREMENT,
    form_activity_name VARCHAR2(255),
    form_id INT NOT NULL,
    Form_Activity_Order INT NOT NULL,
    last_update_date DATE,
    PRIMARY KEY (form_activity_id),
    FOREIGN KEY (form_id) REFERENCES form_master (form_master_id)
--    Form_Question_Context_Order INT NOT NULL,
--    Form_Question_Context INT NOT NULL,
--    FOREIGN KEY (form_context_id) REFERENCES form_context (form_context_id)
);


DROP TABLE IF EXISTS activity_info;
CREATE TABLE activity_info (
    activity_info_id INT AUTO_INCREMENT,
    activity_info_name VARCHAR2(255) NOT NULL,
    form_master_id INT NOT NULL,
    form_Activity_Order INT NOT NULL,
    form_status VARCHAR2(255) NOT NULL,
    last_update_date DATE,
    round_Id INT NOT NULL, 
    PRIMARY KEY (activity_info_id),
    FOREIGN KEY (form_master_id) REFERENCES form_master (form_master_id),
    FOREIGN KEY (round_Id) REFERENCES round (round_Id)
--    Form_Question_Context_Order INT NOT NULL,
--    Form_Question_Context INT NOT NULL,
--    FOREIGN KEY (form_context_id) REFERENCES form_context (form_context_id)
);

DROP TABLE IF EXISTS question_type;
CREATE TABLE question_type (
question_type_id INT AUTO_INCREMENT,
question_type_name VARCHAR2(255) NOT NULL
);


DROP TABLE IF EXISTS activity_context;
CREATE TABLE activity_context (
    activity_context_id INT AUTO_INCREMENT,
    activity_info_id INT NOT NULL,
    activity_context_title VARCHAR2(255) NOT NULL,
    activity_context_score INT ,
    activity_context_scoretype VARCHAR2(255) ,
    question_type_id int not null,
    --form_question_heading VARCHAR2(255) NOT NULL,
    --form_status VARCHAR2(255) NOT NULL,
    last_update_date DATE,
    PRIMARY KEY (activity_context_id),
    FOREIGN KEY (activity_info_id) REFERENCES activity_info (activity_info_id),
    FOREIGN KEY (question_type_id) REFERENCES question_type (question_type_id)
   --FOREIGN KEY (activity_context_title) REFERENCES activity_info (activity_info_name)
);



DROP TABLE IF EXISTS context_questions;
CREATE TABLE context_questions (
context_question_Id INT AUTO_INCREMENT,
context_question_Order VARCHAR2(255) NOT NULL,
context_question VARCHAR2 NOT NULL,
answer_field_type VARCHAR2(255) NOT NULL,
is_rule_applicable VARCHAR2(255) NOT NULL,
options_value VARCHAR2(255) NOT NULL,
additional_button Varchar2(255) NOT NULL,
is_visible_button varchar2(255) NOT NULL,
Last_Updated_Date DATE,
activity_context_id int not null,
score int,
question_type_id int not null,
PRIMARY KEY (context_question_Id),
--FOREIGN KEY (activity_info_id) REFERENCES activity_info (activity_info_id)
FOREIGN KEY (activity_context_id) REFERENCES activity_context (activity_context_id),
FOREIGN KEY (question_type_id) REFERENCES question_type (question_type_id)
);




DROP TABLE IF EXISTS templates;
CREATE TABLE templates (
template_Id INT AUTO_INCREMENT,
template_Name VARCHAR2(255) NOT NULL);

DROP TABLE IF EXISTS template_questions;
CREATE TABLE template_questions (
context_question_Id INT AUTO_INCREMENT,
context_question_Order VARCHAR2(255) NOT NULL,
context_question VARCHAR2(255) NOT NULL,
answer_field_type VARCHAR2(255) NOT NULL,
is_rule_applicable VARCHAR2(255) NOT NULL,
options_value VARCHAR2(255) NOT NULL,
additional_button Varchar2(255) NOT NULL,
is_visible_button varchar2(255) NOT NULL,
Last_Updated_Date DATE,
template_Id int not null,
context_Title Varchar2(255),
PRIMARY KEY (context_question_Id),
--FOREIGN KEY (activity_info_id) REFERENCES activity_info (activity_info_id)
FOREIGN KEY (template_Id) REFERENCES templates (template_Id)
);




--DROP TABLE IF EXISTS context_answer;
--CREATE TABLE context_answer (
--answer_id INT AUTO_INCREMENT,
--selected_answer VARCHAR2(255) NOT NULL,
--context_question_Id int not null,
--PRIMARY KEY (answer_id),
-- FOREIGN KEY (context_question_Id) REFERENCES context_questions (context_question_Id)
--)


DROP TABLE IF EXISTS User_Form_Inputs;
CREATE TABLE User_Form_Inputs (

Form_ID INT NOT NULL,
User_Id INT NOT NULL,
Form_Question_Context_Id INT NOT NULL,
Form_Question_Id INT AUTO_INCREMENT,
Form_Answer_Type VARCHAR2(255) NOT NULL,
Form_Answer VARCHAR2(255) NOT NULL,
Form_Comments VARCHAR2(255) NOT NULL,
Last_Updated_Date DATE,
PRIMARY KEY (Form_Question_Id)
);

DROP TABLE IF EXISTS User_Form_Inputs_History;
CREATE TABLE User_Form_Inputs_History (

Form_ID INT NOT NULL,
User_Id INT NOT NULL,
Form_Question_Context_Id INT NOT NULL,
Form_Question_Id INT NOT NULL,
Form_Answer_Type VARCHAR2(255) NOT NULL,
Form_Answer VARCHAR2(255) NOT NULL,
Form_Comments VARCHAR2(255) NOT NULL,
User_Action_Type VARCHAR2(255) NOT NULL,
Last_Updated_Date DATE
);

DROP TABLE IF EXISTS item;

CREATE TABLE item (
  id INT(11) NOT NULL,
  name VARCHAR(50) NULL DEFAULT NULL,
  category VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (id)
);

--DROP TABLE IF EXISTS Activity;
--
--CREATE TABLE Activity (
--  lhsId VARCHAR(50) NOT NULL,
--  lhsName VARCHAR(50) ,
--  completeStatus boolean DEFAULT false ,
--  isActive boolean DEFAULT false  ,
--  error boolean DEFAULT false ,
--  PRIMARY KEY (lhsId)
--);

DROP TABLE IF EXISTS context_template;
CREATE TABLE context_template(
context_template_id INT AUTO_INCREMENT,
template_name VARCHAR2(255) NOT NULL,
context_name VARCHAR2(255) NOT NULL,
question_value VARCHAR2(255) NOT NULL,
answer_type VARCHAR2(255) NOT NULL,
answer_values VARCHAR2(255) NOT NULL,
score VARCHAR2(255) NOT NULL,
PRIMARY KEY (context_template_id)
);













