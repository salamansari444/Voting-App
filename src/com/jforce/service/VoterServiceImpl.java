package com.jforce.service;

import com.jforce.dao.IVoterDao;
import com.jforce.daoFactory.VoterDaoFactory;

public class VoterServiceImpl implements IVoterService {

	
	IVoterDao voterDao=null;
	@Override
	public String registerVoter(String username, String password, String email, Integer phone) {
		
		voterDao=VoterDaoFactory.getVoterBean();

		return voterDao.registerVoter(username, password, email, phone);
		
		
	}
	
	
	@Override
	public boolean validateUser(String username, String password) {

		voterDao=VoterDaoFactory.getVoterBean();

		return voterDao.validateUser(username, password);
	}


	@Override
	public boolean validateVote(String username) {
		// TODO Auto-generated method stub
		voterDao=VoterDaoFactory.getVoterBean();

		return voterDao.validateVote(username);
	}


	@Override
	public void updateVote(String username) {
		voterDao=VoterDaoFactory.getVoterBean();

		voterDao.updateVote(username);
		// TODO Auto-generated method stub
		
	}
	
	

}
