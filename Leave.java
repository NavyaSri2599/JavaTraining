package com.mphasis.java.LeaveProject;

import java.io.Serializable;
import java.util.Date;

public class Leave implements Serializable{

	private int leaveId;
	private int managerId;
	private Date leaveStartdate;
	private Date leaveEnddate;
	LeaveType leaveType;
	LeaveStatus leaveStatus;
	private int noOfDays;
	private String leaveAppliedOn;
	private String managerComment;
	
	public Leave(int leaveId, int managerId, Date leaveStartdate, Date leaveEnddate, LeaveType leaveType,
			LeaveStatus leaveStatus, int noOfDays, String leaveAppliedOn, String managerComment) {
		this.leaveId = leaveId;
		this.managerId = managerId;
		this.leaveStartdate = leaveStartdate;
		this.leaveEnddate = leaveEnddate;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.noOfDays = noOfDays;
		this.leaveAppliedOn = leaveAppliedOn;
		this.managerComment = managerComment;
	}

	public Leave() {
	}

	@Override
	public String toString() {
		
		Date date1 = new Date();
		Date date2 = new Date();
		date1= leaveStartdate;
		date2= leaveEnddate;
		
		long time_diff=date2.getTime()-date1.getTime();
		long days_diff=(time_diff/(1000*60*60*24))%365;
		
		Date today = new Date();
		
		
		return "Leave [leaveId=" + leaveId + ", managerId=" + managerId + ", leaveStartdate=" + leaveStartdate
				+ ", leaveEnddate=" + leaveEnddate + ", leaveType=" + leaveType + ", leaveStatus=" + leaveStatus
				+ ", noOfDays=" + days_diff + ", leaveAppliedOn=" + today + ", managerComment=" + managerComment
				+ "]";
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Date getLeaveStartdate() {
		return leaveStartdate;
	}

	public void setLeaveStartdate(Date leaveStartdate) {
		this.leaveStartdate = leaveStartdate;
	}

	public Date getLeaveEnddate() {
		return leaveEnddate;
	}

	public void setLeaveEnddate(Date leaveEnddate) {
		this.leaveEnddate = leaveEnddate;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getLeaveAppliedOn() {
		return leaveAppliedOn;
	}

	public void setLeaveAppliedOn(String leaveAppliedOn) {
		this.leaveAppliedOn = leaveAppliedOn;
	}

	public String getManagerComment() {
		return managerComment;
	}

	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}
	
}
