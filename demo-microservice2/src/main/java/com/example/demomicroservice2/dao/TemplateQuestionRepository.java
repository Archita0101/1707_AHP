/**
 * 
 */
package com.example.demomicroservice2.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demomicroservice2.domain.TemplateQuestions;

/**
 * @author juhi.b.jain
 *
 */
@Repository
public interface TemplateQuestionRepository extends CrudRepository<TemplateQuestions, Integer> {

	@Query(value = " select * from template_questions where template_id = :templateId" , nativeQuery = true)
	Iterable<TemplateQuestions> findByTemplateId(@Param("templateId") Integer templateId);

}
