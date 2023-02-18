package edu.wccnet.mbrown99.pizzaApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.mbrown99.pizzaApp.entity.Customer;
import edu.wccnet.mbrown99.pizzaApp.entity.PizzaOrder;

@Repository
public class PizzaOrderDAOImpl implements PizzaOrderDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PizzaOrder> getPizzaOrders(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer c where id = :customerID ", Customer.class);
		query.setParameter("customerID", id);
		Customer customer = query.getSingleResult();
		return customer.getOrders();
	}
	
	@Override
	public List<PizzaOrder> getPizzaOrders() {
		Session session = sessionFactory.getCurrentSession();
		Query<PizzaOrder> query = session.createQuery("from PizzaOrder ", PizzaOrder.class);
		return query.getResultList();
	}
	
	public void saveOrder(PizzaOrder pizzaOrder) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(pizzaOrder);
	}
	
	public PizzaOrder getOrder(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<PizzaOrder> query = session.createQuery("From PizzaOrder where id = :orderId ", PizzaOrder.class);
		query.setParameter("orderId", id);
		return query.getSingleResult();
	}
	
	public void deleteOrder(int id) {
		Session session = sessionFactory.getCurrentSession();
		PizzaOrder pizzaOrder = session.get(PizzaOrder.class, id);
		session.remove(pizzaOrder);
	}

}
