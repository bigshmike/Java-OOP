package edu.wccnet.mbrown99.pizzaApp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.mbrown99.pizzaApp.api.CustomerNotFoundException;
import edu.wccnet.mbrown99.pizzaApp.dao.CustomerDAO;
import edu.wccnet.mbrown99.pizzaApp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Customer customer = customerDAO.getCustomer(id);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer ID [" + id + "] was not found");
		}
		return customerDAO.getCustomer(id);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Customer customer = customerDAO.getCustomer(id);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer ID [" + id + "] was not found");
		}
		customerDAO.deleteCustomer(id);
	}

	@Override
	public Map<String, String> populateStates() {
		// TODO Auto-generated method stub
		return customerDAO.populateStates();
	}

}
