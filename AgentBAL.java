package com.mphasis.java.AgentProject;

import java.util.List;

public class AgentBAL {

	public static String addStudentBal(Agent agent)
	{
			return new AgentDAO().addAgentDao(agent);
	}
	
	public static List<Agent> showStudentBal()
	{
		return new AgentDAO().showAgentDao();
	}

}
