package edu.wccnet.mbrown99.pizzaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.wccnet.mbrown99.pizzaApp.entity.Customer;
import edu.wccnet.mbrown99.pizzaApp.entity.Pizza;
import edu.wccnet.mbrown99.pizzaApp.entity.PizzaOrder;
import edu.wccnet.mbrown99.pizzaApp.service.CustomerService;
import edu.wccnet.mbrown99.pizzaApp.service.PizzaOrderService;
import edu.wccnet.mbrown99.pizzaApp.service.PizzaService;

@Controller
@RequestMapping("/customer")
public class MainController {
	private PizzaOrder pizzaOrder;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private PizzaOrderService pizzaOrderService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		return "list-customers";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@PostMapping("/processCustomer") 
	public String processCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(Model model, @RequestParam("customerId") int id) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@RequestMapping("/orderPizza")
	public ModelAndView orderPizza(Model model, @RequestParam("customerId") int id) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customerName", customer.getFirstName() + " " + customer.getLastName());
		if (pizzaOrder == null) {
			pizzaOrder = new PizzaOrder(customer);
		}
		return new ModelAndView("order-pizza", "newPizza", new Pizza());
	}
	
	@PostMapping("/processPizza")
	public String processPizza(Model model, @ModelAttribute("newPizza") Pizza pizza) {
		pizzaOrder.add(pizza);
		model.addAttribute("pizzaOrder", pizzaOrder);
		return "confirmation";
	}
	
	@RequestMapping("/placeOrder")
	public String placeOrder(@RequestParam("customerId") int id, RedirectAttributes redirectAttributes) {
		pizzaService.orderPizza(pizzaOrder);
		pizzaOrder = null;
		redirectAttributes.addAttribute("customerId", id);
		return "redirect:/customer/pizzaHistory";
		
	}
	
	@PostMapping("/deleteOrder")
	public String deleteOrder(@RequestParam("orderId") int id, RedirectAttributes redirectAttributes) {
		int customerId = ((PizzaOrder) pizzaOrderService.getOrder(id)).getCustomer().getId();
		pizzaOrderService.deleteOrder(id);
		redirectAttributes.addAttribute("customerId", customerId);
		return "redirect:/customer/pizzaHistory";
	}
	
	@RequestMapping("/pizzaHistory")
	public String listPizzas(Model model, @RequestParam("customerId") int id) {
		model.addAttribute("orders", pizzaOrderService.getPizzaOrders(id));
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customerName", customer.getFirstName() + " " + customer.getLastName());
		model.addAttribute("customerId", customer.getId());
		return "order-history";
	}
	
	@InitBinder
	public void initialBinderForTrimmingSpaces(WebDataBinder webDataBinder) {
	    StringTrimmerEditor stringTrimEditor = new StringTrimmerEditor(true);
	    webDataBinder.registerCustomEditor(String.class, stringTrimEditor);
	}
	
	@ModelAttribute
	public void populateFormWithData(Model model) {
		model.addAttribute("sizes", pizzaService.populatePizzaSizes());
		model.addAttribute("toppings", pizzaService.populatePizzaToppings());
		model.addAttribute("states", customerService.populateStates());
	}
}
