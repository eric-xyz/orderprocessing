package com.orderprocessing.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.orderprocessing.model.Order;


@Transactional
public interface OrderRepository extends CrudRepository<Order, Long>{

}
