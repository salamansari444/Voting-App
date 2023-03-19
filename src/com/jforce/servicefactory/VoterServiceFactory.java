package com.jforce.servicefactory;

import com.jforce.service.IVoterService;
import com.jforce.service.VoterServiceImpl;

public class VoterServiceFactory {
	
	private static IVoterService voterService=null;
	
	public static IVoterService getVoterServiceBean() {
		
		if(voterService==null) {
			voterService=new VoterServiceImpl();
		}
		return voterService;
	}

}
