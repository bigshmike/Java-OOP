package edu.wccnet.mbrown99.pizzaApp.service;

import java.util.List;
import java.util.Map;

import edu.wccnet.mbrown99.pizzaApp.entity.PizzaOrder;

public interface PizzaService {
	public List<PizzaOrder> getPizzas();
	
	public void orderPizza(PizzaOrder orderID);
	
	public Map<String, String> populatePizzaSizes();
	
	public Map<String, String> populatePizzaToppings();

}
