package com.orderprocessing.service;

/*
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.orderprocessing.model.Order;

@Service
public class OrderServiceBeanInMemory implements OrderService{
	private static Map<Integer, Order> testMap = new HashMap<>();
	static{
		String orderId1 = UUID.randomUUID().toString();
		Date date = new Date();
		
		Order order1 = new Order();
		order1.setId(1);
		order1.setDestination("China");
		order1.setTime(date.getTime());
		order1.setStatus(false);
		
		Order order2 = new Order();
		String orderId2 = UUID.randomUUID().toString();
		order2.setId(2);
		order2.setDestination("United States");
		order2.setTime(date.getTime());
		order2.setStatus(false);
		
		testMap.put(1, order1);
		testMap.put(2, order2);
	}

	@Override
	public Collection<Order> findAll() {
		Collection<Order> orders = null;
		orders = testMap.values();
		return orders;
	}

	@Override
	public Order findById(int orderId) {
		return testMap.get(orderId);
	}

	@Override
	public Order createOrder(Order order) {
		testMap.put(order.getId(), order);
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		testMap.put(order.getId(), order);
		return order;
	}

	@Override
	public void deleteOrder(int orderId) {
		Order order = testMap.get(orderId);
		if(null != order){
			order.setStatus(true);
		}
	}

}
*/
