 package edu.wccnet.mbrown99.pizzaApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pizza")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "toppings")
	private String toppings;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private PizzaOrder pizzaOrder;
	
	public Pizza() {
		
	}

	public Pizza(String size, String toppings) {
		setSize(size);
		setToppings(toppings);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getToppings() {
		return toppings;
	}

	public void setToppings(String toppings) {
		this.toppings = toppings;
	}

	public PizzaOrder getPizzaOrder() {
		return pizzaOrder;
	}

	public void setPizza_order(PizzaOrder pizzaOrder) {
		this.pizzaOrder = pizzaOrder;
	}

	@Override
	public String toString() {
		return "Pizza [size=" + size + ", toppings=" + toppings + ", pizzaOrder=" + pizzaOrder + "]";
	}
}
