package com.orderprocessing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="orders")
public class Order {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String destination;
	
	private long orderTime;

	private String customerId;
	
	private String orderId;
	
	private float price;
	
	private boolean cancelled;
	
	
	public Order(){
		
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}

	public long getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getOrderId() {
		return orderId;
	}


	public void setOrdered(String orderId) {
		this.orderId = orderId;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	
	public boolean getCancelled() {
		return cancelled;
	}


	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}
