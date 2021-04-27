package com.mphasis.java.AgentProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mphasis.java.Studentproject.Student;

public class AgentDAO {

	static Scanner sc =new Scanner(System.in);
	static List<Agent> agentList;
	
	static
	{
		agentList = new ArrayList<Agent>() ;
	}
	
	public  String addAgentDao(Agent agent)
	{
		agentList.add(agent);
		return "Agent added successfully";
	}
	
	public List<Agent> showAgentDao()
	{
		return agentList;
		
	}
}
