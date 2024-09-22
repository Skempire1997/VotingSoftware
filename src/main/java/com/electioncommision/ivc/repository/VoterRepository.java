package com.electioncommision.ivc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electioncommision.ivc.entity.States;
import com.electioncommision.ivc.entity.Voter;

public interface VoterRepository extends JpaRepository<Voter, Long> {

	Voter getVoterByEmailID(String emailID);
	
	Voter getVoterByPhoneNo(String phoneNo);
	
	List<Voter> getVoterByState(States state);
	
	List<Voter> getVoterByDistrict(String district);
	
	
}
