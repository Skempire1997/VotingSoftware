package com.electioncommision.ivc.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.electioncommision.ivc.entity.States;
import com.electioncommision.ivc.entity.Voter;

public interface VoterService {

	public Voter createVoter(Voter voter);

	public Optional<?> getVoterById(long id);

	public Voter getVoterByEmailID(String emailID);

	public Voter getVoterByPhoneNo(String PhoneNo);

	public List<Voter> getAllVoter();

	public Voter updateVoter(long id, Voter voter);

	public Voter updatingVoter(long id, Map<String, Object> updates);

	public Boolean deleteVoter(long id);
	
	List<Voter> getVoterByStateAndDistrict(States state,String district);

	List<Voter> getVoterByState(States state);

	List<Voter> getVoterByDistrict(String district);
	

}
