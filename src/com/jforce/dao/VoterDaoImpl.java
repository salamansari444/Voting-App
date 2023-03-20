package com.jforce.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.jforce.dto.Candidate;
import com.jforce.dto.Voter;
import com.jforce.util.HibernateUtil;

public class VoterDaoImpl implements IVoterDao {
	Session session = HibernateUtil.getSession();

	@Override
	public String registerVoter(String username, String password, String email, Integer phone) {

		Transaction transacion = null;
		Boolean flag = true;
		String status = "";
		try {
			transacion = session.beginTransaction();
			if (transacion != null) {

				Voter voter = new Voter();
				voter.setEmail(email);
				voter.setUsername(username);
				voter.setPassword(password);
				voter.setPhone(phone);

				session.save(voter);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transacion.commit();
				System.out.println("data inserted");
				status = "success";
			} else {
				transacion.rollback();
				status = "failed";
			}

		}

		return status;
	}

	@Override
	public boolean validateUser(String username, String password) {

		String hql = "from com.jforce.dto.Voter where username=:user and password=:pass";
		Query query = session.createQuery(hql);
		query.setParameter("user", username);
		query.setParameter("pass", password);

		Optional<Voter> optional = query.uniqueResultOptional();
		if (optional.isPresent()) {
			return true;
		}
		return false;

	}

	@Override
	public boolean validateVote(String username) {
		// TODO Auto-generated method stub

		Voter voter = session.get(Voter.class, username);
		if (voter.getVoted() != null)
			return true;
		return false;

	}

	@Override
	public void updateVote(String username) {

		Transaction tx = session.beginTransaction();

		Voter voter = session.get(Voter.class, username);

		voter.setVoted(1);
		session.update(voter);
		tx.commit();

	}

	@Override
	public void updateCandidate(String candidate) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Candidate cand = session.get(Candidate.class, candidate);
		if (cand == null) {
			Candidate can = new Candidate();
			can.setCandidateName(candidate);
			can.setVoteCount(1);
			session.merge(can);

		} else {

			Integer currCount = cand.getVoteCount() + 1;
			cand.setVoteCount(currCount);
			session.merge(cand);
		}
		tx.commit();

	}

	@Override
	public boolean validateAdmin(String username, String password) {

		String admin = "admin";
		String pass = "admin";

		if (username.equals(admin) && password.equals(pass))
			return true;

		return false;
	}

	@Override
	public List<Candidate> fetchCandidates() {
		// TODO Auto-generated method stub

		Query query = session.createQuery("from com.jforce.dto.Candidate");

		List<Candidate> resultList = query.getResultList();
		resultList.forEach(System.out::println);

		return resultList;
	}

}
