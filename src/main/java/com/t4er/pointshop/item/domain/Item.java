package com.t4er.pointshop.item.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String name; // 상품 이름
    private int price; // 상품 가격
    private int quantity; // 상품 수량
    private LocalDateTime date; // 상품 등록 시간

}
