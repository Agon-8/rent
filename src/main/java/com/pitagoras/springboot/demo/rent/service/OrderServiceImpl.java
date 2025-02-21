package com.pitagoras.springboot.demo.rent.service;

import com.pitagoras.springboot.demo.rent.entity.Order;
import com.pitagoras.springboot.demo.rent.repository.OrderRepository;
import com.pitagoras.springboot.demo.rent.exception.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> order = this.orderRepository.findById(id);

        if (!order.isPresent()) {
            throw new CarNotFoundException("Car with id " + id + " not found.");
        }
        return order.get();
    }
    @Override
    public Order updateOrder(Order theOrder) {
        Optional<Order> toUpdatedOrder = this.orderRepository.findById(theOrder.getId());
        if (toUpdatedOrder == null) {
            throw new CarNotFoundException("Order with id " + theOrder + " not found to update");
        }

        return this.orderRepository.save(theOrder);

    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Order> order = this.orderRepository.findById(id);
        if (!order.isPresent()) {
            throw new CarNotFoundException("Order with id " + id + " was not found");
        }
        this.orderRepository.deleteById(id);
        return true;

    }
}
