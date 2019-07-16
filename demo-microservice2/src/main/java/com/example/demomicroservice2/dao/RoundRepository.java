/**
 * 
 */
package com.example.demomicroservice2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demomicroservice2.domain.Round;

/**
 * @author juhi.b.jain
 *
 */
@Repository
public interface RoundRepository extends CrudRepository<Round, Integer> {

	public List<Round> findByRoundStatus(String status);

	@Transactional
	@Modifying
	@Query(value = "update round set round_Status = 'closed' where round_Status != 'closed' AND end_date < TO_DATE(GETDATE(),'YYYY-MM-DD')", nativeQuery = true)
	public void closeRounds();
	
	@Transactional
	@Modifying
	@Query(value = "select distinct fm.FORM_NAME || ' - ' || r.ROUND_NAME || ' - ' || r.start_date || ' to ' || r.end_date as ROUND_NAME, r.round_id + 2 as round_id, r.round_status, r.start_date, r.end_date, r.progress_credence, r.retention_period, r.owner_occupied_rp  from ROUND r,  ACTIVITY_INFO ai,  FORM_MASTER fm where fm.FORM_MASTER_ID = ai.FORM_MASTER_ID and ai.ROUND_ID  = r.ROUND_ID", nativeQuery = true)
	public List<Round> getRoundTemplateNames();
	 
}