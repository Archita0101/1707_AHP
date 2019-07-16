/**
 * 
 */
package com.example.demomicroservice2.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demomicroservice2.domain.ActivityContext;

/**
 * @author juhi.b.jain
 *
 */
@Repository
public interface ActivityContextRepository extends CrudRepository<ActivityContext, Integer> {

	@Query(value = " select * from activity_context where question_type_id = :typeId and activity_info_id = :activityInfoId" , nativeQuery = true)
	Iterable<ActivityContext> findByActivityInfoIdAndTypeId(@Param("activityInfoId") Integer activityInfoId, @Param("typeId") Integer typeId);


}
