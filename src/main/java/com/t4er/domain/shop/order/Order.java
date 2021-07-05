package com.t4er.domain.shop.order;

import com.t4er.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Table(name = "orders")
@Entity
public class Order extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "orders_id")
    private Long id;
    private int count;
}
