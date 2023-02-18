package edu.wccnet.mbrown99.pizzaApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.mbrown99.pizzaApp.api.OrderNotFoundException;
import edu.wccnet.mbrown99.pizzaApp.dao.PizzaOrderDAO;
import edu.wccnet.mbrown99.pizzaApp.entity.PizzaOrder;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService {
	@Autowired
	PizzaOrderDAO pizzaOrderDAO;

	@Override
	@Transactional
	public List<PizzaOrder> getPizzaOrders(int id) {
		// TODO Auto-generated method stub
		return pizzaOrderDAO.getPizzaOrders(id);
	}
	
	@Override
	@Transactional
	public List<PizzaOrder> getPizzaOrders() {
		return pizzaOrderDAO.getPizzaOrders();
	}

	@Override
	@Transactional
	public void saveOrder(PizzaOrder pizzaOrder) {
		// TODO Auto-generated method stub
		pizzaOrderDAO.saveOrder(pizzaOrder);
		
	}

	@Override
	@Transactional
	public PizzaOrder getOrder(int id) {
		// TODO Auto-generated method stub
		PizzaOrder order = pizzaOrderDAO.getOrder(id);
		if (order == null) {
			throw new OrderNotFoundException("Order ID [" + id + "] was not found");
		}
		return pizzaOrderDAO.getOrder(id);
	}

	@Override
	@Transactional
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		PizzaOrder order = pizzaOrderDAO.getOrder(id);
		if (order == null) {
			throw new OrderNotFoundException("Order ID [" + id + "] was not found");
		}
		pizzaOrderDAO.deleteOrder(id);
		
	}

}
