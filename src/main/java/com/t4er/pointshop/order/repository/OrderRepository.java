package com.t4er.pointshop.order.repository;

import com.t4er.pointshop.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
