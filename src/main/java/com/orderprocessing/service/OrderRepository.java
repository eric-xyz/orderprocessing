package com.orderprocessing.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orderprocessing.model.Order;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
