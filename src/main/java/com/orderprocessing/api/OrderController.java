package com.orderprocessing.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orderprocessing.model.Order;
import com.orderprocessing.service.OrderRepository;


@RestController
@RequestMapping(value = "/api")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository ;
	
	@RequestMapping(
			value = "orders",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Iterable<Order>> getAllOrders(){
			Iterable<Order> orders = orderRepository.findAll();
			return new ResponseEntity<Iterable<Order>>(orders, HttpStatus.OK);			
	}
	
	@RequestMapping(
	value = "orders",
	method = RequestMethod.POST,
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		Order returnedOrder = orderRepository.save(order);
		if(null == returnedOrder){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Order>(returnedOrder, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "orders/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Order> getOrder(@PathVariable("id") long id){
			Order order = orderRepository.findOne(id);
			if(null == order || order.getCancelled()){
				if(order.getCancelled()){
					System.out.println("order exists but cancelled");
				}
				return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "orders/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Order> updateOrder(@RequestBody Order order){
			Order oldOrder = orderRepository.findOne(order.getId());
			if(null == oldOrder){
				return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
			}
			orderRepository.save(order);
			return new ResponseEntity<Order>(oldOrder, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value = "orders/{id}",
			method = RequestMethod.DELETE )
	public ResponseEntity<Order> deleteOrder(@PathVariable("id") long id){
			Order targetOrder = orderRepository.findOne(id);
			if(null != targetOrder){
				targetOrder.setCancelled(true);
				orderRepository.save(targetOrder);
			}
			return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
	}
	
}
