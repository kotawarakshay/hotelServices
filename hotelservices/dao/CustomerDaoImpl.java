package com.cg.hotelservices.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.cg.hotelservices.bean.Customer;
import com.cg.hotelservices.exception.CustomerException;
import com.cg.hotelservices.util.DBConnection;

public class CustomerDaoImpl implements ICustomerDao{

	@Override
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement st=connection.createStatement();
		java.sql.Date inDate =null;
		java.sql.Date outDate = null;
		java.util.Date a=null;
		java.util.Date b= null;
		String customerId=null;
		try {
				pst = connection.prepareStatement("insert into Customer_Details values(customerId_Seq.nextval,?,?,?,?,?)");
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				//Date inDate=null;
				//Date outDate=null;
				DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				a =  dateFormat.parse(customer.getCheckInDate());
				inDate = new java.sql.Date(a.getTime());
				b =  dateFormat.parse(customer.getCheckOutDate());
				outDate = new java.sql.Date(b.getTime());
				pst.setString(1, customer.getCustomerName());
				pst.setString(2, customer.getCustomerPhoneNumber());
				pst.setDate(3, inDate);
				pst.setDate(4, outDate);
				pst.setString(5, customer.getRoomType());
				pst.executeUpdate();
				
				rs = st.executeQuery("select * from customer_details order by customerid");
				
				while(rs.next())
				{
					customerId = rs.getString(1);
				}
				
				return customerId;
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return customerId;
	}

	@Override
	public Customer viewCustomerDetails(String customerId) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Statement st=connection.createStatement();
		try{
			Customer customer = new Customer();
			rs = st.executeQuery("select * from customer_details where customerid = '"+customerId+"'");
			while(rs.next())
			{
				customer.setCustomerId(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerPhoneNumber(rs.getString(3));
				customer.setCheckInDate(rs.getString(4));
				customer.setCheckOutDate(rs.getString(5));
				
			}
			return customer;
		}
		catch(Exception ce)
		{
			System.err.println(ce.getMessage());
		}
		return null;
	}

	@Override
	public List<Customer> retrieveAllCustomers() throws ClassNotFoundException, SQLException, IOException {
		Connection connection = DBConnection.getConnection();
		PreparedStatement pst = null;
		//Statement st = connection.createStatement();
		ResultSet rs = null;
		//Statement st=connection.createStatement();
		List<Customer> list = new ArrayList<Customer>();
		try{
			pst = connection.prepareStatement(" select * from customer_details order by customerid");
			rs = pst.executeQuery();
		//	Statement st=connection.createStatement();
		//	rs = st.executeQuery("select * from customer_details order by customerid");
			//st.executeU
			
			while(rs.next())
			{
				Customer customer = new Customer();
				
				customer.setCustomerId(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerPhoneNumber(rs.getString(3));
				customer.setCheckInDate(rs.getString(4));
				customer.setCheckOutDate(rs.getString(5));
				customer.setRoomType(rs.getString(6));
				
				list.add(customer);
			}
		}
		catch(Exception ce)
		{
			System.err.println(ce.getMessage());
		}
		return list;
	}


}
