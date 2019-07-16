
package com.example.demomicroservice2.dao;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demomicroservice2.domain.Activity;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer>{

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = " INSERT INTO activity_info (activity_info_name, form_master_id,form_Activity_Order,form_status,last_update_date, round_Id) VALUES "
	          + " (:activity_info_name, :form_master_id, :form_Activity_Order, :form_status, :last_update_date, :round_Id)" , nativeQuery = true)
	 void saveActivityWithRound(@Param("activity_info_name") String activity_info_name, @Param("form_master_id") int form_master_id,
			  @Param("form_Activity_Order") int form_Activity_Order, @Param("form_status") String form_status, @Param("last_update_date") Date last_update_date,
			  @Param("round_Id") int round_Id);

}


