package com.capgemini.contactbook.ui;

import java.util.Scanner;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.service.ContactBookService;
import com.capgemini.contactbook.service.ContactBookServiceImpl;

public class Client {

	static ContactBookService contactBook=null;
	static ContactBookServiceImpl contactBookServiceImpl=null;
	static Scanner scanner=new Scanner(System.in);
	static  EnquiryBean enqry=null;
	public static void main(String[] args)
	{
		int enqryId=0;
		
		while(true)
		{
			System.out.println("**********Global Recruitment*******************");
			System.out.println("Choose an option");
			System.out.println("1.Enter Enquiry Details");
			System.out.println("2.View Enquiry Details on Id");
			System.out.println("0.Exit");
			System.out.println("**************************************************");
			
			
			System.out.println("Please enter a Choice ");
			int option=scanner.nextInt();
			switch(option){
			
			case 1:
				while(enqry==null)
				{
					enqry=populateEnquiryBean();
				}
			try{
			
				contactBookServiceImpl=new ContactBookServiceImpl();
				enqryId=contactBookServiceImpl.addEnquiry(enqry);
				
				System.out.println("Customer Details are successfully added");
				System.out.println("Customer Id is:"+ enqryId);
				
			}catch(Exception messege)
			{
				System.out.println(messege);
			}
		break;
		
			case 2:
				
				 enqryId=0;
				 enqry=new EnquiryBean();
				 try
				 {
				contactBookServiceImpl=new ContactBookServiceImpl();
				System.out.println("Enter the Enquiry Id");
				 enqryId=scanner.nextInt();
				 enqry=contactBookServiceImpl.getEnquiryDetails(enqryId);
				 System.out.println("Enquiry Id is: "+enqry.getEnqryId());
				 System.out.println(enqry.getfName());
				 System.out.println(enqry.getlName());
				 System.out.println(enqry.getContactNo());
				 System.out.println(enqry.getpDomain());
				 System.out.println(enqry.getpLocation());
				 }
				 catch(Exception e)
				 {
					 System.out.println(e);
				 }
				 break;
				 
			case 0:
				System.exit(0);
				break;
		default:
			break;
			}
		}
			
		
		
	}


	private static EnquiryBean populateEnquiryBean() {
		enqry=new EnquiryBean();
		System.out.println("Enter First Name");
		enqry.setfName(scanner.next());
		System.out.println("Enter the Last Name");
		enqry.setlName(scanner.next());
		System.out.println("Enter Contact No");
		enqry.setContactNo(scanner.next());
		System.out.println("Enter Prefered Location");
		enqry.setpLocation(scanner.next());
		System.out.println("Enter preferred Domain");
		enqry.setpDomain(scanner.next());
		try
		{
		contactBookServiceImpl=new ContactBookServiceImpl();
		contactBookServiceImpl.validateCustomer(enqry);
		return enqry;
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
}
