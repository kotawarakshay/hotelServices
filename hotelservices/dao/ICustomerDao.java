package com.cg.hotelservices.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.hotelservices.bean.Customer;

public interface ICustomerDao {

	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException, IOException;
	public Customer viewCustomerDetails(String customerId) throws ClassNotFoundException, SQLException, IOException;
	public List<Customer> retrieveAllCustomers() throws ClassNotFoundException, SQLException, IOException;
}
