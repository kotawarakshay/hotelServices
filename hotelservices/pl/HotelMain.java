package com.cg.hotelservices.pl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.management.relation.RelationServiceNotRegisteredException;

import com.cg.hotelservices.bean.Bill;
import com.cg.hotelservices.bean.Customer;
import com.cg.hotelservices.bean.Hotel;
import com.cg.hotelservices.exception.CustomerException;
import com.cg.hotelservices.services.CustomerServiceImpl;
import com.cg.hotelservices.services.HotelServiceImpl;
import com.cg.hotelservices.services.ICustomerService;
import com.cg.hotelservices.services.IHotelService;

public class HotelMain {
	
	static Scanner sc=new Scanner(System.in);
	static ICustomerService customerService=null;
	static CustomerServiceImpl customerServiceImpl=null;
	static IHotelService hotelService = null;
	static HotelServiceImpl hotelServiceImpl = null;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
	{
		
		boolean start = true;
		int login;
		while(start)
		{
			System.out.println(" Enter 1 for user, enter 2 for admin");
			login = sc.nextInt();
			switch(login)
			{
			
			case 1:
				getUser();
				break;
				
			case 2:
				getAdmin();
				break;
			default:
				start = false;
				break;
			}
		}
	}
	static public void getUser() throws ClassNotFoundException, SQLException, IOException
	{
		Customer customer = null;
		String customerId = null;
		boolean methods=true;
		while(methods)
		{
			System.out.println();
			System.out.println();
			System.out.println("*---CAPGEMINI HOTEL---*");
			System.out.println("______________________");
			
			System.out.println("1.Add Customer");
			System.out.println("2.View Customer");
			System.out.println("3.Retrieve All");
			System.out.println("4.Exit");
			System.out.println("______________________");
			System.out.println("Select an option");
			int option;
			option = sc.nextInt();
			switch(option)
			{
			case 1:
				while(customer==null)
				{
					customer=populateCustomer();
				}
				try
				{
					customerService=new CustomerServiceImpl();
					customerId=customerService.addCustomer(customer);
					System.out.println("Customer details are successfully added");
					System.out.println("Customer ID is:" + customerId);
				}
				catch(Exception custException)
				{
					System.err.println("ERROR:" +custException.getMessage());
				}
				finally {
					customerId=null;
					customerService=null;
					customer=null;
				}
				break;
			case 2:
				try{
				System.out.println(" enter customer id to get details: ");
				customerId = sc.next();
				customer = new Customer();
				customerServiceImpl = new CustomerServiceImpl();
				customerService = new CustomerServiceImpl();
				if(customerServiceImpl.validateCustomerId(customerId))
				{
					customer = customerService.viewCustomerDetails(customerId);
					System.out.println(customer);
				}
				else
				{
					System.out.println("enter proper customer id ");
				}
				}
				catch(Exception e)
				{
					System.err.println(e.getMessage());
				}
				/*finally{
					customer = null;
					customerServiceImpl=null;
					customerService=null;
				}*/
				break;
			case 3:
				
					List<Customer> list = new ArrayList<>();
					list = customerService.retrieveAllCustomers();
					//System.out.println(list);	
					if(list !=null)
					{
						Iterator<Customer> i = list.iterator();
						while(i.hasNext())
						{
							System.out.println(i.next());
						}
					}
				
				break;
			case 4:
				System.exit(0);
				break;
			default:
				methods = false;
				break;
			}
		}
	}
	
	public static void getAdmin() throws ClassNotFoundException, SQLException, IOException
	{
		boolean methods=true;
		while(methods)
		{
			System.out.println();
			System.out.println("*---CAPGEMINI HOTEL---*");
			System.out.println("______________________");
			
			System.out.println("1.Show Rooms");
			System.out.println("2.Generate Bill");
			System.out.println("6.Exit");
			System.out.println("______________________");
			System.out.println("Select an option");
			int option;
			option = sc.nextInt();
			switch(option)
			{
			case 1:
				String roomType = null;
				List<Hotel> li = new ArrayList<>();
				System.out.println("enter required room type : ");
				roomType=sc.next();
				hotelService = new HotelServiceImpl();
				hotelServiceImpl = new HotelServiceImpl();
				if(hotelServiceImpl.validateRoomType(roomType))
				{
					li = hotelService.showRooms(roomType);
					if(li !=null)
					{
						Iterator<Hotel> i = li.iterator();
						while(i.hasNext())
						{
							System.out.println(i.next());
						}
					}
				}
				
				break;
				
			case 2:
				String customerId;
				Bill bill = new Bill();
				System.out.println("enter customer id to generate bill :");
				customerId = sc.next();
				customerServiceImpl = new CustomerServiceImpl();
				hotelService = new HotelServiceImpl();
				if(customerServiceImpl.validateCustomerId(customerId))
				{
					bill = hotelService.generateBill(customerId);
					System.out.println(bill);
				}
				else
				{
					System.out.println("bill cannot be generated... right now due to technical problems");
				}
				break;
				
			default:
				methods = false;
			}
		}
	}
	private static Customer populateCustomer()
	{
		Customer customer=new Customer();
		System.out.println("\nEnter Details");
		
		System.out.println("enter the customer name:");
		customer.setCustomerName(sc.next());
		
		System.out.println("enter the donor contact:");
		customer.setCustomerPhoneNumber(sc.next());
		
		System.out.println(" enter customer checkin date: ");
		customer.setCheckInDate(sc.next());
		
		System.out.println(" enter customer checkout date: ");
		customer.setCheckOutDate(sc.next());
		
		System.out.println(" enter roomtype of customer :");
		customer.setRoomType(sc.next());
	
		customerServiceImpl =new CustomerServiceImpl();
		try
		{
			customerServiceImpl.validateCustomer(customer);
			return customer;
		}
		catch(CustomerException donorException)
		{
			System.err.println("Invalid Dtat:");
			System.err.println( donorException.getMessage() + "\nTry again...");
		}
		return null;
	}
}
