package edu.wccnet.mbrown99.pizzaApp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.mbrown99.pizzaApp.entity.PizzaOrder;
import edu.wccnet.mbrown99.pizzaApp.service.PizzaOrderService;

@RestController
@RequestMapping("/api")
public class OrderRestController {
	@Autowired
	PizzaOrderService pizzaOrderService;
	
	@GetMapping("/orders")
	public List<PizzaOrder> getOrders() {
		return pizzaOrderService.getPizzaOrders();
	}
	
	@GetMapping("/orders/{orderId}")
	public PizzaOrder getOrders(@PathVariable int orderId) {
		return pizzaOrderService.getOrder(orderId);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public void deleteCustomer(@PathVariable int orderId) {
		pizzaOrderService.deleteOrder(orderId);
	}
	
	@PostMapping("/orders")
	public PizzaOrder addOrder(@RequestBody PizzaOrder pizzaOrder) {
		pizzaOrder.setId(0);
		pizzaOrderService.saveOrder(pizzaOrder);
		return pizzaOrder;
	}
	
	@PutMapping("/orders")
	public PizzaOrder updateOrder(@PathVariable PizzaOrder pizzaOrder) {
		pizzaOrderService.saveOrder(pizzaOrder);
		return pizzaOrder;
	}
	
	@ExceptionHandler
	public ResponseEntity<OrderNotFoundErrorResponse> handleException(OrderNotFoundException e) {
		OrderNotFoundErrorResponse error = new OrderNotFoundErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<OrderNotFoundErrorResponse> handleException(Exception e) {
		OrderNotFoundErrorResponse error = new OrderNotFoundErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
