package com.mphasis.java.LeaveProject;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class LeaveBAL {

	static StringBuilder sb = new StringBuilder("");
	
	public static boolean valid(Leave leave) {
		sb=new StringBuilder("");
		boolean isValid=true;
		if(leave.getManagerId()<=0)
		{
			sb.append("Inavlid ManagerID...MangerID must be positive\r\n");
			isValid=false;
		}
		Date d1= new Date();
		if(leave.getLeaveStartdate().compareTo(d1)<0)
		{
			sb.append("Invalid Leave Start Date\r\n");
			isValid=false;
		}
		if(leave.getLeaveEnddate().compareTo(d1)<0)
		{
			sb.append("Invalid Leave End Date\r\n");
			isValid=false;
		}
		return isValid;
	}

	public static String addLeaveBal(Leave leave) throws LeaveException
	{
		if(valid(leave)==true)
		{
			return new LeaveDAO().addLeaveDao(leave);
		}
		else
		{
			throw new LeaveException(sb.toString());
		}
	}
	
	public static List<Leave> showLeaveBal()
	{
		return new LeaveDAO().showLeaveDao();
	}

	public static Leave searchLeaveDao(int lid)
	{
		return new LeaveDAO().searchLeaveDao(lid);
	}
	
	public static String deletLeaveBal(int lid)
	{
		return new LeaveDAO().deleteLeaveDao(lid);
	}
	
	public static String updateLeaveBal(Leave leave) throws LeaveException
	{
		if(valid(leave)==true)
		{
			return new LeaveDAO().updateLeaveDao(leave);
		}
		else
		{
			throw new LeaveException(sb.toString());
		}
	}
	
	public static String readLeaveBal() throws ClassNotFoundException, IOException
	{
		return new LeaveDAO().readLeaveFileDao();
	}
	
	public static String writeLeaveBal() throws IOException
	{
		return new LeaveDAO().writeLeaveFileDao();
	}
	
	public static int generateLeaveIdBal()
	{
		return new LeaveDAO().generateLeaveId();
	}
	
	public static String approveDeniedBal(int lid, String leavestatus,String managercomment)
	{
		return new LeaveDAO().approveDenied(lid, leavestatus, managercomment);
	}
}
