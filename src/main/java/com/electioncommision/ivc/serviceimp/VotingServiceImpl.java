package com.electioncommision.ivc.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electioncommision.ivc.entity.Candidate;
import com.electioncommision.ivc.exceptionhandler.IdNotFoundException;
import com.electioncommision.ivc.exceptionhandler.NoDataAvailable;
import com.electioncommision.ivc.repository.CandidateRepository;
import com.electioncommision.ivc.service.VotingService;

@Service
public abstract class VotingServiceImpl implements VotingService{

	@Autowired
	private CandidateRepository candidateRepository;
	@Override
	public List<Candidate> getAllCandidate() {
		List<Candidate> candidates=candidateRepository.findAll();
		if (candidates.isEmpty()) {
			throw new NoDataAvailable("No candidates are available");
		} else {
			return candidates;
		}
	}

	@Override
	public boolean castVote(long candidateId) {
		Optional<Candidate> optional=candidateRepository.findById(candidateId);
		if (optional.isPresent()) {
			Candidate candidate=optional.get();
			candidate.setVotes(candidate.getVotes()+1);
			if ( candidateRepository.save(candidate)!=null) {
				return true;
			} else {
				return false;
			}
			
		} else {
			throw new IdNotFoundException("Candidate Not Found with given Id : "+candidateId);
		}
	}

	
}
