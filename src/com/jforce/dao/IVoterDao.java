package com.jforce.dao;

public interface IVoterDao {
	
	public String registerVoter(String username, String password, String email, Integer phone);
	
	boolean validateUser(String username, String password);
	boolean validateVote(String username);
	void updateVote(String username);
	

}
