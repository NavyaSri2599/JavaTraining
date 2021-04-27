package com.mphasis.java.LeaveProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class LeaveDAO {

	static List<Leave> leavelist;
	static
	{
		leavelist=new ArrayList<Leave>();
	}
	
	public String addLeaveDao(Leave leave)
	{
		leavelist.add(leave);
		return "Leave details added successfully";
	}
	
	public List<Leave> showLeaveDao()
	{
		return leavelist;
	}
	
	public Leave searchLeaveDao(int lid)
	{
		Leave result=null;
		for (Leave leave : leavelist) {
			if(leave.getLeaveId()==lid)
			{
				result=leave;
				break;
			}
		}
		return result;
	}
	
	public String deleteLeaveDao(int lid)
	{
		Leave leave=searchLeaveDao(lid);
		if(leave!=null)
		{
			leavelist.remove(lid);
			return "Record Deleted successfully";
		}
		else
		{
			return "Record not Found";
		}
	}
	
	public String updateLeaveDao(Leave newRecord)
	{
		Leave oldRecord=searchLeaveDao(newRecord.getLeaveId());
		if(oldRecord!=null)
		{
			oldRecord.setLeaveId(newRecord.getLeaveId());
			oldRecord.setManagerId(newRecord.getManagerId());
			oldRecord.setLeaveStartdate(newRecord.getLeaveStartdate());
			oldRecord.setLeaveEnddate(newRecord.getLeaveEnddate());
			oldRecord.setLeaveType(newRecord.getLeaveType());
			oldRecord.setLeaveStatus(newRecord.getLeaveStatus());
			oldRecord.setLeaveAppliedOn(newRecord.getLeaveAppliedOn());
			oldRecord.setManagerComment(newRecord.getManagerComment());
			return "Record Updated Successfully";
		}
		else
		{
			return "Record Not found";
		}
	}
	
	public String readLeaveFileDao() throws IOException, ClassNotFoundException
	{
		FileInputStream fin= new FileInputStream("C:/Files/leave.txt");
		ObjectInputStream objin=new ObjectInputStream(fin);
		leavelist=(List<Leave>)objin.readObject();
		objin.close();
		fin.close();
		return "File Read Succesfully";
	}
	
	public String writeLeaveFileDao() throws IOException
	{
		FileOutputStream fout=new FileOutputStream("C:/Files/leave.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		objout.writeObject(leavelist);
		objout.close();
		fout.close();
		return "Leave Records Saved Successfully";
	}
	
	public int generateLeaveId()
	{
		int lid=0;
		int count=leavelist.size();
		if(count==0)
		{
			lid=1;
		}
		else
		{
			lid=count+1;
		}
		return lid;
	}
	
	public String approveDenied(int lid,String leavestatus,String managercomment)
	{
		Leave leave=searchLeaveDao(lid);
		if(leave!=null)
		{
			leave.setLeaveStatus(LeaveStatus.valueOf(leavestatus));
			leave.setManagerComment(managercomment);
			return "LeaveStatus Updated";
		}
		else
		{
			return "Invalid LeaveID..";
		}
	}
}
