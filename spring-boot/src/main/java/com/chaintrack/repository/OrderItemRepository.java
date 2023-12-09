package com.chaintrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaintrack.modal.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
