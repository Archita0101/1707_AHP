/**
 * 
 */
package com.example.demomicroservice2.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demomicroservice2.domain.Question;

/**
 * @author juhi.b.jain
 *
 */
@Repository
public interface QuestionRepository  extends CrudRepository<Question, Integer>  {

	/*
	 * @Query("SELECT q FROM Question q WHERE q.activityId = :activityId") public
	 * List<Question> findQuestionsByActivityId(@Param("activityId") Integer
	 * activityId);
	 */
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = " delete from CONTEXT_QUESTIONS where ACTIVITY_CONTEXT_ID = :activityContextId" , nativeQuery = true)
	 void deleteQuestionsByContextId(@Param("activityContextId") Integer activityContextId);
}
