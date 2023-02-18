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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip")
	private String zip;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<PizzaOrder> orders = new ArrayList<PizzaOrder>();
	
	public Customer () {
		
	}

	public Customer(String firstName, String lastName, String street, String city, String state, String zip) {
		setFirstName(firstName);
		setLastName(lastName);
		setStreet(street);
		setCity(city);
		setState(state);
		setZip(zip);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public List<PizzaOrder> getOrders() {
		return orders;
	}
	
	public void setOrders(List<PizzaOrder> orders) {
		this.orders = orders;
	}
	
	public void addOrder(PizzaOrder newOrder) {
		orders.add(newOrder);
		newOrder.setCustomer(this);
	}
	
	public void removeOrder(PizzaOrder order) {
		orders.remove(order);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	
}
