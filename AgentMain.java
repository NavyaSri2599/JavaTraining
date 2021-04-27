package com.mphasis.java.AgentProject;

import java.util.List;
import java.util.Scanner;

public class AgentMain {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice;
		do
		{
			System.out.println("OPTIONS");
			System.out.println("1.Add Agent Details");
			System.out.println("2.Show Agent Details");
			System.out.println("3.Exit");
			System.out.println("______________________________");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: addAgent();
						break;
				case 2: showAgent();
						break;
				case 3: break;
				default: System.out.println("Invalid Choice");
						 break;
				
			}
		}while(choice!=3);
	}
	public static void addAgent()
	{
		Agent agent=new Agent();
		System.out.println("Enter Agent ID: ");
		agent.setAgentId(sc.nextInt());
		System.out.println("Enter Agent name: ");
		agent.setAgentName(sc.next());
		System.out.println("Enter City: ");
		agent.setCity(sc.next());
		System.out.println("Enter Premium: ");
		agent.setPremium(sc.nextDouble());
		System.out.println("Enter Paymode: ");
		agent.setPayMode(sc.nextInt());
		String result = AgentBAL.addStudentBal(agent);
		System.out.println(result);
	}
	
	public static void showAgent()
	{
		List<Agent> agentList = AgentBAL.showStudentBal();
		System.out.println(" AgentID     AgentName     City     Premium     PayMode ");
		System.out.println("--------------------------------------------------------");
		for (Agent agent : agentList) {
			System.out.println(agent);
		}
	}
}
