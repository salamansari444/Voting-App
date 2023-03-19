package com.jforce.daoFactory;

import com.jforce.dao.IVoterDao;
import com.jforce.dao.VoterDaoImpl;

public class VoterDaoFactory {
	
	private static IVoterDao voterDao=null;
	
	public static IVoterDao getVoterBean() {
		
		if(voterDao==null) {
			voterDao=new VoterDaoImpl();
		}
		return voterDao;
	}

}
