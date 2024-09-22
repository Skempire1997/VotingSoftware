package com.electioncommision.ivc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electioncommision.ivc.entity.Candidate;
import com.electioncommision.ivc.service.VotingService;

@RestController
@RequestMapping("/Voting")
public class VotingController {
	
	@Autowired 
	private VotingService votingService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Candidate>> getAllCandidate() {
		return new ResponseEntity<>(votingService.getAllCandidate(),HttpStatus.FOUND);

	}
	
	@PostMapping("/castVote/{CandidateId}")
	 public ResponseEntity<String> castVote(@PathVariable Long candidateId){
		if (votingService.castVote(candidateId)) {
			return ResponseEntity.ok("VOTE CASTED SUCCESSFULLY");
		} else {
			throw new RuntimeException("Somthing went wrong");
		}
	}
}
