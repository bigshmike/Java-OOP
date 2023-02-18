package edu.wccnet.mbrown99.pizzaApp.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.mbrown99.pizzaApp.entity.PizzaOrder;

@Repository
public class PizzaDAOImpl implements PizzaDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<PizzaOrder> getPizzas() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<PizzaOrder> query = session.createQuery("from PizzaOrder ", PizzaOrder.class);
		return query.getResultList();
	}

	@Override
	public void orderPizza(PizzaOrder orderID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(orderID);
	}

	@Override
	public Map<String, String> populatePizzaSizes() {
		// TODO Auto-generated method stub
		Map<String, String> sizes = new LinkedHashMap<String, String>();
		sizes.put("S", "S");
		sizes.put("M", "M");
		sizes.put("L", "L");
		sizes.put("XL", "XL");
		return sizes;
	}

	@Override
	public Map<String, String> populatePizzaToppings() {
		// TODO Auto-generated method stub
		Map<String, String> toppings = new LinkedHashMap<String, String>();
		toppings.put("Pepperoni", "Pepperoni");
		toppings.put("Sausage", "Sausage");
		toppings.put("Bacon", "Bacon");
		toppings.put("Ham", "Ham");
		toppings.put("Onion", "Onion");
		toppings.put("Green Olive", "Green Olive");
		toppings.put("Green Pepper", "Green Pepper");
		toppings.put("Black Olive", "Black Olive");
		toppings.put("Tomato", "Tomato");
		toppings.put("Jalapeno", "Jalapeño");
		toppings.put("Feta Cheese", "Feta Cheese");
		toppings.put("Fresh Mozzarella", "Fresh Mozzarella");
		toppings.put("Extra Cheese", "Extra Cheese");
		return toppings;
	}


}
