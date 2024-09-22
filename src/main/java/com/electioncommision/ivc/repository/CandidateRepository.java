package com.electioncommision.ivc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electioncommision.ivc.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
