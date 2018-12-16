package com.cg.hotelservices.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.hotelservices.bean.Customer;

public interface ICustomerService {
	
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException, IOException;
	public Customer viewCustomerDetails(String customerId) throws ClassNotFoundException, SQLException, IOException;
	public List<Customer> retrieveAllCustomers() throws ClassNotFoundException, SQLException, IOException;
	
}
