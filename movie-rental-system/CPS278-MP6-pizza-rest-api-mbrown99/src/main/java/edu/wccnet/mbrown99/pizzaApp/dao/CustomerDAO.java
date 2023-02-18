package edu.wccnet.mbrown99.pizzaApp.dao;

import java.util.List;
import java.util.Map;

import edu.wccnet.mbrown99.pizzaApp.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);
	
	public Map<String, String> populateStates();
	
	public void deleteCustomer(int id);
}
