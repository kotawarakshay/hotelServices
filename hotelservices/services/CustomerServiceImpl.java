package com.cg.hotelservices.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.hotelservices.bean.Customer;
import com.cg.hotelservices.dao.CustomerDaoImpl;
import com.cg.hotelservices.dao.ICustomerDao;
import com.cg.hotelservices.exception.CustomerException;

public class CustomerServiceImpl implements ICustomerService {

	ICustomerDao iCustomerDao= new CustomerDaoImpl();
	
	@Override
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException, IOException {
		String customerSeq;
		customerSeq= iCustomerDao.addCustomer(customer);
		return customerSeq;
	}

	@Override
	public Customer viewCustomerDetails(String customerId) throws ClassNotFoundException, SQLException, IOException {
		Customer customer = new Customer();
		customer = iCustomerDao.viewCustomerDetails(customerId);
		return customer;
	}

	@Override
	public List<Customer> retrieveAllCustomers() throws ClassNotFoundException, SQLException, IOException {
		List<Customer> list = new ArrayList<>();
		list = iCustomerDao.retrieveAllCustomers();
		return list;
	}

	
	public void validateCustomer(Customer customer) throws CustomerException
	{
		List<String> validationErrors =new ArrayList<String>();
		
		if(!(isValidName(customer.getCustomerName())))
		{
			validationErrors.add("\n customer name should be in alphatical and min 3 char long!");
		}
		
		if(!(isValidPhoneNumber(customer.getCustomerPhoneNumber()))) 
		{
			validationErrors.add("\n phone number should be in 10 digit \n");
		}
		
	/*	if(!(isValidDate(customer.getCheckInDate())))
		{
			validationErrors.add("\n date must be given in proper format \n");
		}
		if(!(isValidDate(customer.getCheckOutDate())))
		{
			validationErrors.add("\n date must be given in proper format \n");
		}*/
		
		if(!validationErrors.isEmpty())
		{
			throw new CustomerException(validationErrors+ "");
		}
	}
	
	private boolean isValidName(String customerName) 
	{
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher namematcher=namePattern.matcher(customerName);
		return namematcher.matches();
	}
	
	private boolean isValidPhoneNumber(String customerNumber) 
	{
		Pattern phonePattern=Pattern.compile("^[6-9][0-9]{9}$");
		Matcher phonematcher=phonePattern.matcher(customerNumber);
		return phonematcher.matches();
	}
	
	private boolean isValidDate(String checkDate)
	{
		Pattern pat1 = Pattern.compile("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[2][0-9]{3}$");
		Matcher mat1 = pat1.matcher(checkDate);
		return mat1.matches();
	}

	public boolean validateCustomerId(String customerId)
	{
		Pattern idPattern=Pattern.compile("[1-9][0-9]{2}");
		Matcher idmatcher=idPattern.matcher(customerId);
		if(idmatcher.matches())
			return true;
		else
			return false;
	}
}
