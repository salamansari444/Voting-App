package com.jforce.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Candidate {

	@Id
	private String candidateName;
	private Integer voteCount;

	@Override
	public String toString() {
		return "Candidate [candidateName=" + candidateName + ", voteCount=" + voteCount + "]";
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

}
