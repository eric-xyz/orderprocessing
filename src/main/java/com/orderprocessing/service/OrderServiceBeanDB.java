package com.orderprocessing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orderprocessing.model.Order;

@Service
public class OrderServiceBeanDB implements OrderRepository{
	
	@Autowired 
	private OrderRepository orderRepository;
	
	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public void delete(Long id) {
		Order order = orderRepository.findOne(id);
		order.setCancelled(true);
		orderRepository.save(order);
	}

	@Override
	public void delete(Order order) {
		delete(order.getId());
	}

	@Override
	public void delete(Iterable<? extends Order> orders) {
		for(Order order : orders){
			delete(order.getId());
		}
	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
	}

	@Override
	public boolean exists(Long id) {
		return orderRepository.exists(id);
	}

	@Override
	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Iterable<Order> findAll(Iterable<Long> ids) {
		List<Order> orderList = new ArrayList<>();
		for(long id : ids){
			Order tempOrder = orderRepository.findOne(id);
			if(null != tempOrder){
				orderList.add(tempOrder);
			}
		}
		return orderList;
	}

	@Override
	public Order findOne(Long id) {
		Order order = orderRepository.findOne(id);
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Order save(Order order) {
		if(null == order) return null;
		System.out.println(order.toString());
		orderRepository.save(order);
		return order;
	}

	@Override
	public <S extends Order> Iterable<S> save(Iterable<S> orders) {
		orderRepository.save(orders);
		return orders;
	}

	
	
}
