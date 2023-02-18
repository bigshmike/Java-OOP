package edu.wccnet.mbrown99.pizzaApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pizza_order")
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pizzaOrder", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Pizza> pizzas = new ArrayList<Pizza>();
	
	public PizzaOrder() {
		
	}
	
	public PizzaOrder(Customer customer) {
		setCustomer(customer); 
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@JsonIgnore
	public List<Pizza> getPizza() {
		return pizzas;
	}
	
	@JsonIgnore
	public void setPizza(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	public void add(Pizza newPizza) {
		pizzas.add(newPizza);
		newPizza.setPizza_order(this);
	}
	
	public void remove(Pizza pizza) {
		pizzas.remove(pizza);
	}
	
	@Override
	public String toString() {
		return "PizzaOrder [id=" + id + ", customer=" + customer + "]";
	}
	
	
}
