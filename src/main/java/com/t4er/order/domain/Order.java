package com.t4er.order.domain;

import com.t4er.common.entity.AbstractEntity;
import com.t4er.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    @Id @GeneratedValue
    private Long id;

    private String orderToken;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ORDER_INIT("주문 시작"),
        ORDER_COMPLETE("주문 완료"),
        IN_DELIVERY("기프티콘 발송"),
        DELIVERY_COMPLETE("기프티콘 발송완료");

        private final String description;
    }

}
