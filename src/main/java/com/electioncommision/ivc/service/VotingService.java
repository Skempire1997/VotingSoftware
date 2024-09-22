package com.electioncommision.ivc.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electioncommision.ivc.entity.Candidate;

public interface VotingService extends JpaRepository<Candidate, Long> {

	List<Candidate> getAllCandidate();
	boolean castVote(long candidateId);
	
}
