package com.mphasis.java.LeaveProject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class LeaveMain {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		int choice;
		do
		{
			System.out.println("OPTIONS");
			System.out.println("1.Add Leave Details");
			System.out.println("2.Show	Leave Details");
			System.out.println("3.Search LeaveDetail");
			System.out.println("4.Update Leave Details");
			System.out.println("5.Delete a Leave");
			System.out.println("6.Save to file");
			System.out.println("7.Read from file");
			System.out.println("8.Approve Denied");
			System.out.println("9.Exit");
			System.out.println("______________________________");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1: try {
							addLeave();
						} catch (ParseException | LeaveException e1) {
							e1.printStackTrace();
						}
						break;
				case 2: showLeave();
						break;
				case 3: searchLeave();
						break;
				case 4: try {
							updateLeave();
						} catch (ParseException | LeaveException e1) {
							e1.printStackTrace();
						}
						break;
				case 5:	deleteLeave();
						break;
				case 6: try {
							saveFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
				case 7: try {
							readFile();
						} catch (ClassNotFoundException | IOException e) {
							e.printStackTrace();
						}
						break;
				case 8: approveDenied();
						break;
				case 9: break;				
				default: System.out.println("Invalid Choice");
						 break;
				
			}
		}while(choice!=9);

	}
	
	public static void addLeave() throws ParseException, LeaveException
	{
		Leave leave=new Leave();
		//System.out.println("Enter LeaveID: ");
		//leave.setLeaveId(sc.nextInt());
		int lid=LeaveBAL.generateLeaveIdBal();
		leave.setLeaveId(lid);
		System.out.println("Enter Manager ID: ");
		leave.setManagerId(sc.nextInt());
		System.out.println("Enter LeaveStartDate: ");
		leave.setLeaveStartdate(new SimpleDateFormat("dd-MM-yyyy").parse(sc.next()));
		System.out.println("Enter LeaveEndDate: ");
		leave.setLeaveEnddate(new SimpleDateFormat("dd-MM-yyyy").parse(sc.next()));
		System.out.println("Enter LeaveType: ");
		leave.setLeaveType(LeaveType.valueOf(sc.next()));
		//System.out.println("Enter LeaveStatus: ");
		//leave.setLeaveStatus(LeaveStatus.valueOf(sc.next()));
		leave.setLeaveStatus(LeaveStatus.PENDING);
		System.out.println("Enter Manager Comments: ");
		leave.setManagerComment(sc.next());
		String result =LeaveBAL.addLeaveBal(leave);
		System.out.println(result);
	}
	
	public static void showLeave()
	{
		List<Leave> leavelist = LeaveBAL.showLeaveBal();
		for (Leave leave : leavelist) {
			System.out.println(leave);
		}
	}
	
	public static void searchLeave()
	{
		int lid;
		System.out.println("Enter LeaveID: ");
		lid=sc.nextInt();
		Leave leave=LeaveBAL.searchLeaveDao(lid);
		if(leave!=null)
		{
			System.out.println(leave);
		}
		else
		{
			System.out.println("Record not found");
		}
	}
	
	public static void deleteLeave()
	{
		int lid;
		System.out.println("Enter LeaveID: ");
		lid=sc.nextInt();
		String result=LeaveBAL.deletLeaveBal(lid);
		System.out.println(result);
	}
	
	public static void updateLeave() throws ParseException, LeaveException
	{
		Leave leave=new Leave();
		System.out.println("Enter LeaveID: ");
		leave.setLeaveId(sc.nextInt());
		System.out.println("Enter ManagerID: ");
		leave.setManagerId(sc.nextInt());
		System.out.println("Enter LeaveStartDate: ");
		leave.setLeaveStartdate(new SimpleDateFormat("dd-MM-yyyy").parse(sc.next()));
		System.out.println("Enter LeaveEndDate: ");
		leave.setLeaveEnddate(new SimpleDateFormat("dd-MM-yyyy").parse(sc.next()));
		System.out.println("Enter LeaveType: ");
		leave.setLeaveType(LeaveType.valueOf(sc.next()));
		System.out.println("Enter LeaveStatus: ");
		leave.setLeaveStatus(LeaveStatus.valueOf(sc.next()));
		System.out.println("Leave Applied on: ");
		leave.setLeaveAppliedOn(sc.next());
		System.out.println("Enter Manager Comments: ");
		leave.setManagerComment(sc.next());
		String result=LeaveBAL.updateLeaveBal(leave);
		System.out.println(result);
	}
	
	public static void readFile() throws ClassNotFoundException, IOException
	{
		LeaveBAL.readLeaveBal();
	}
	
	public static void saveFile() throws IOException
	{
		String result=LeaveBAL.writeLeaveBal();
		System.out.println(result);
	}
	
	public static void approveDenied()
	{
		System.out.println("Enter LeaveID: ");
		int lid=sc.nextInt();
		System.out.println("Enter LeaveStatus: ");
		String leavestatus =sc.next();
		System.out.println("Manager Comments: ");
		String managercomment =sc.next();
		String result = LeaveBAL.approveDeniedBal(lid, leavestatus, managercomment);
		System.out.println(result);
	}

}
