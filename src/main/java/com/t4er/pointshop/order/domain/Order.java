package com.t4er.pointshop.order.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue
    @Column(name = "orders_id")
    private Long id;
    private int count;
}
