/**
 * 
 */
package com.example.demomicroservice2.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demomicroservice2.dao.RoundRepository;
import com.example.demomicroservice2.domain.Round;

/**
 * @author juhi.b.jain
 *
 */
@Service
public class RoundService {
	@Autowired 
	RoundRepository roundRepository;

	public List<Round> getRounds() {
		Iterable<Round> rounds = roundRepository.findAll();
		return StreamSupport.stream(rounds.spliterator(), false).collect(Collectors.toList());
	}

	public Round getRoundById(int roundId) {
		return roundRepository.findById(roundId).get();
	}

	public Round createNewRound(Round round) {
		return roundRepository.save(round);
		
	}

	public void deleteRound(Round round) {
		roundRepository.delete(round);
	}

	public void editRound(Round round) {
		roundRepository.save(round);
	}

	public List<Round> getRoundsByStatus(String status) {
		
		roundRepository.closeRounds();
		List<Round> rounds = roundRepository.findByRoundStatus(status);
		return rounds;
	}
	
	public List<Round> getRoundTemplateNames() {
		return roundRepository.getRoundTemplateNames();
	}
	
	/*
	 * public void closeRounds() {
	 * 
	 * roundRepository.closeRounds();
	 * 
	 * }
	 */

}
