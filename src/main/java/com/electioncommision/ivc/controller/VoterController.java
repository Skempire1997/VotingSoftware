package com.electioncommision.ivc.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electioncommision.ivc.entity.States;
import com.electioncommision.ivc.entity.Voter;
import com.electioncommision.ivc.service.VoterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Voter")
public class VoterController {
	@Autowired
	private VoterService service;
	
	@PostMapping("/save")
	public ResponseEntity<Voter> createVoter(@Valid @RequestBody Voter voter) {
		Voter voter2= service.createVoter(voter);
		
		return new ResponseEntity<>(voter2,HttpStatus.CREATED);
	}

	@GetMapping("/id")
	public ResponseEntity<Optional<?>> getVoterById(@RequestParam long id){
		return new ResponseEntity<>(service.getVoterById(id),HttpStatus.FOUND);

	}
	
	@GetMapping("/email")
	public ResponseEntity<Voter>getVoterByEmailID(@RequestParam String emailId){
		return new ResponseEntity<>(service.getVoterByEmailID(emailId), HttpStatus.FOUND);
	}
	
	@GetMapping("/phone")
	public ResponseEntity<Voter>getVoterByPhoneNo(@RequestParam String phoneno){
		return new ResponseEntity<>(service.getVoterByPhoneNo(phoneno), HttpStatus.FOUND);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Voter>> getAllVoter(){
		return new ResponseEntity<>(service.getAllVoter(),HttpStatus.FOUND)  ;
	}

	@PutMapping("/update")
	public ResponseEntity<Voter> updateVoter(@Valid @RequestParam long id,@RequestBody Voter voter) {
		return new ResponseEntity<>(service.updateVoter(id, voter),HttpStatus.OK);
	}


	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteVoter(@RequestParam long id) {
		return new ResponseEntity<>(service.deleteVoter(id),HttpStatus.NO_CONTENT);
	}
	

	@PatchMapping("/update")
	public ResponseEntity<Voter> updatingVoter(@RequestParam long id,@RequestBody Map<String, Object> voter) {
		Voter voter2=service.updatingVoter(id, voter);
		return new ResponseEntity<>(voter2,HttpStatus.OK);
	}
	
	@GetMapping("/state")
	public ResponseEntity<List<Voter>> getVotersByState(@RequestParam States state){
		List<Voter> voters=service.getVoterByState(state);
		return new ResponseEntity<>(voters,HttpStatus.FOUND);
	}
	
	@GetMapping("/district")
	public ResponseEntity<List<Voter>> getVoterByDistrict(@PathVariable String district){
		List<Voter> voters=service.getVoterByDistrict(district);
		return new ResponseEntity<>(voters,HttpStatus.FOUND);
	}
	
	@GetMapping("/state/district")
	public ResponseEntity<List<Voter>> getVoterByStateAndDistrict(@PathVariable States state,@PathVariable String district){
		List<Voter> voters=service.getVoterByStateAndDistrict(state, district);
		return new ResponseEntity<>(voters,HttpStatus.FOUND);
	}

}
