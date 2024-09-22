package com.electioncommision.ivc.serviceimp;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.electioncommision.ivc.entity.States;
import com.electioncommision.ivc.entity.Voter;
import com.electioncommision.ivc.exceptionhandler.DuplicateEntryException;
import com.electioncommision.ivc.exceptionhandler.EmailNotFound;
import com.electioncommision.ivc.exceptionhandler.IdNotFoundException;
import com.electioncommision.ivc.exceptionhandler.NoDataAvailable;
import com.electioncommision.ivc.exceptionhandler.PhoneNotFound;
import com.electioncommision.ivc.repository.VoterRepository;
import com.electioncommision.ivc.service.VoterService;

@Service
public class VoterServiceimpl implements VoterService {
	
	@Autowired
	private VoterRepository repository;

	@Override
	public List<Voter> getVoterByStateAndDistrict(States state, String district) {
		List<Voter>voters=repository.getVoterByState(state);
		if (voters.isEmpty()) {
			throw new NoDataAvailable("No Data Available for "+state);
		} else {
			List<Voter>voters2=new LinkedList<Voter>();
			for (Voter voter : voters) {
				if (voter.getDistrict().equals(district)) {
					voters2.add(voter);
				}
			}
			
			return voters2;
		}
	}

	@Override
	public Voter getVoterByEmailID(String emailID) {
		Voter voter= repository.getVoterByEmailID(emailID);
		if (voter !=null) {
			return voter;
		} else {
			throw new EmailNotFound(emailID);
		}
	}

	@Override
	public Voter getVoterByPhoneNo(String phoneNo) {
		Voter voter=repository.getVoterByPhoneNo(phoneNo);
		if (voter!=null) {
			return voter;
		} else {
			throw new PhoneNotFound(phoneNo);
		}
	}

	

	@Override
	public Voter createVoter(Voter voter) {
		
		Voter condition1 = repository.getVoterByEmailID(voter.getEmailID());
		Voter condition2 = repository.getVoterByPhoneNo(voter.getPhoneNo());
		
			if (condition1==null) {
				if (condition2==null) {
					return repository.save(voter);
				} else {
					throw new DuplicateEntryException("Voter is already registerd with phone " + voter.getPhoneNo());
				}
			} else {

				throw new DuplicateEntryException("Voter is already registerd with email " + voter.getEmailID());

			}
			
		
	}

	@Override
	public List<Voter> getVoterByState(States state) {
		List<Voter>voters=repository.getVoterByState(state);
		if (voters.isEmpty()) {
			throw new NoDataAvailable("No Data Available for "+state);
		} else {
			return voters;
		}
	}

	@Override
	public List<Voter> getVoterByDistrict(String district) {
		List<Voter> voters= repository.getVoterByDistrict(district);
		if (voters.isEmpty()) {
			throw new NoDataAvailable("No Data Available for "+ district);
		} else {
			return voters;
		}
	}

	@Override
	public Optional<?> getVoterById(long id) {
		Optional<?> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional;
		} else {
			throw new IdNotFoundException();

		}
	}

	@Override
	public List<Voter> getAllVoter() {
		List<Voter> voters = repository.findAll();

		if (voters.isEmpty()) {
			throw new NoDataAvailable("No Voters found");
		} else {
			return voters;
		}
	}

	@Override
	public Voter updateVoter(long id, Voter voter) {
		Optional<?> optional = repository.findById(id);
		if (optional.isPresent()) {
			Voter condition1 = repository.getVoterByEmailID(voter.getEmailID());
			Voter condition2 = repository.getVoterByPhoneNo(voter.getPhoneNo());
			if (condition1==null) {
				if (condition2==null) {
					return repository.save(voter);
				} else {
					throw new DuplicateEntryException("Voter is already registerd with phone no " + voter.getPhoneNo());
				}
			} else {

				throw new DuplicateEntryException("Voter is already registerd with email " + voter.getEmailID());

			}
		} else {
			throw new IdNotFoundException();
		}
	}

	@Override
	public Voter updatingVoter(long id, Map<String, Object> updates) {
		Voter voter = repository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Voter Not found with given Id"));
		updates.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Voter.class, key);
			if (field != null) {
				field.setAccessible(true);
				ReflectionUtils.setField(field, voter, value);
			}
		});

	
		return repository.save(voter);

	}

	@Override
	public Boolean deleteVoter(long id) {
		Optional<?> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return true;
		} else {

			throw new IdNotFoundException();
		}
	}

}
