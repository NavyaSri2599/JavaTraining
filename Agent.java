package com.mphasis.java.AgentProject;

public class Agent {

	private int agentId;
	private String agentName;
	private String city;
	private double premium;
	private int payMode;
	
	public Agent(int agentId, String agentName, String city, double premium, int payMode) {
		this.agentId = agentId;
		this.agentName = agentName;
		this.city = city;
		this.premium = premium;
		this.payMode = payMode;
	}

	public Agent() {
	}

	@Override
	public String toString() {
		String pm="";
		if(payMode == 1)
		{
			pm="YEARLY";
		}
		if(payMode == 2)
		{
			pm="HALF-YEARLY";
		}
		if(payMode == 3)
		{
			pm="QUARTERLY";
		}
		
		return String.format("%10s %10s %10s %10s %10s",agentId,agentName,city,premium,pm);
		//return "Agent [agentId=" + agentId + ", agentName=" + agentName + ", city=" + city + ", premium=" + premium
		//		+ ", payMode=" + pm + "]";
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public int getPayMode() {
		return payMode;
	}

	public void setPayMode(int payMode) {
		this.payMode = payMode;
	}
	
}
