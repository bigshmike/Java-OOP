package edu.wccnet.mbrown99.pizzaApp.dao;

import java.util.List;

import edu.wccnet.mbrown99.pizzaApp.entity.PizzaOrder;

public interface PizzaOrderDAO {
	public List<PizzaOrder> getPizzaOrders(int id);
	
	public List<PizzaOrder> getPizzaOrders();
	
	public void saveOrder(PizzaOrder pizzaOrder);
	
	public PizzaOrder getOrder(int id);
	
	public void deleteOrder(int id);

}
