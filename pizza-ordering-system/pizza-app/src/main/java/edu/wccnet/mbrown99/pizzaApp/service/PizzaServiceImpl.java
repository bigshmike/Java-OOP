package edu.wccnet.mbrown99.pizzaApp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.mbrown99.pizzaApp.dao.PizzaDAO;
import edu.wccnet.mbrown99.pizzaApp.entity.PizzaOrder;

@Service
public class PizzaServiceImpl implements PizzaService {
	@Autowired
	private PizzaDAO pizzaDAO;

	@Override
	@Transactional
	public List<PizzaOrder> getPizzas() {
		// TODO Auto-generated method stub
		return pizzaDAO.getPizzas();
	}

	@Override
	@Transactional
	public void orderPizza(PizzaOrder orderID) {
		// TODO Auto-generated method stub
		pizzaDAO.orderPizza(orderID);
	}

	@Override
	public Map<String, String> populatePizzaSizes() {
		// TODO Auto-generated method stub
		return pizzaDAO.populatePizzaSizes();
	}

	@Override
	public Map<String, String> populatePizzaToppings() {
		// TODO Auto-generated method stub
		return pizzaDAO.populatePizzaToppings();
	}

}
