package com.dante.demo1;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer id;
	private String name;
	private Set<Orders> orders = new HashSet<>();

	public Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

}
