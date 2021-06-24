package com.t4er.pointshop.order.domain;

import com.t4er.common.entity.BaseEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "orders_id")
    private Long id;
    private int count;
}
