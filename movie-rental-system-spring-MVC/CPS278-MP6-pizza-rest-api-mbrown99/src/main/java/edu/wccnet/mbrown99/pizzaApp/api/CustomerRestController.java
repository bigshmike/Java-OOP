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

import edu.wccnet.mbrown99.pizzaApp.entity.Customer;
import edu.wccnet.mbrown99.pizzaApp.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		return customerService.getCustomer(customerId);
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers/{customerId}")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerNotFoundErrorResponse> handleException(CustomerNotFoundException e) {
		CustomerNotFoundErrorResponse error = new CustomerNotFoundErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerNotFoundErrorResponse> handleException(Exception e) {
		CustomerNotFoundErrorResponse error = new CustomerNotFoundErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
