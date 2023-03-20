package com.jforce.service;

import java.util.List;

import com.jforce.dto.Candidate;

public interface IVoterService {

	public String registerVoter(String username, String password, String email, Integer phone);

	boolean validateUser(String username, String password);

	boolean validateVote(String username);

	void updateVote(String username);

	void updateCandidate(String candidate);
	boolean validateAdmin(String username, String password);
	List<Candidate> fetchCandidates();



}
