package com.jforce.service;

import java.util.List;

import com.jforce.dao.IVoterDao;
import com.jforce.daoFactory.VoterDaoFactory;
import com.jforce.dto.Candidate;

public class VoterServiceImpl implements IVoterService {

	IVoterDao voterDao = null;

	@Override
	public String registerVoter(String username, String password, String email, Integer phone) {

		voterDao = VoterDaoFactory.getVoterBean();

		return voterDao.registerVoter(username, password, email, phone);

	}

	@Override
	public boolean validateUser(String username, String password) {

		voterDao = VoterDaoFactory.getVoterBean();

		return voterDao.validateUser(username, password);
	}

	@Override
	public boolean validateVote(String username) {
		// TODO Auto-generated method stub
		voterDao = VoterDaoFactory.getVoterBean();

		return voterDao.validateVote(username);
	}

	@Override
	public void updateVote(String username) {
		voterDao = VoterDaoFactory.getVoterBean();

		voterDao.updateVote(username);
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCandidate(String candidate) {
		// TODO Auto-generated method stub
		voterDao = VoterDaoFactory.getVoterBean();
		voterDao.updateCandidate(candidate);

	}

	@Override
	public boolean validateAdmin(String username, String password) {
		// TODO Auto-generated method stub
		voterDao = VoterDaoFactory.getVoterBean();

		return voterDao.validateAdmin(username, password);
	}

	@Override
	public List<Candidate> fetchCandidates() {
		// TODO Auto-generated method stub
		voterDao = VoterDaoFactory.getVoterBean();
		return voterDao.fetchCandidates();
	}

}
