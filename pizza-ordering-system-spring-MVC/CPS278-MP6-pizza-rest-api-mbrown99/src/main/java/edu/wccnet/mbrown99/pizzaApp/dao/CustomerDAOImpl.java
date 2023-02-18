package edu.wccnet.mbrown99.pizzaApp.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.mbrown99.pizzaApp.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override 
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName ", Customer.class);
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public Map<String, String> populateStates() {
		// TODO Auto-generated method stub
		Map<String, String> states = new LinkedHashMap<String, String>();
		states.put("", "");
		states.put("IL", "IL");
		states.put("IN", "IN");
		states.put("OH", "OH");
		states.put("MI", "MI");
		states.put("WI", "WI");
		return states;
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		session.remove(customer);
	}

}
