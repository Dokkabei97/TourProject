package com.t4er.order.domain;

import com.t4er.common.entity.AbstractEntity;
import com.t4er.common.util.TokenGenerator;
import com.t4er.member.domain.Member;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    private static final String ORDER_PREFIX = "ord_";

    @Id
    @GeneratedValue
    private Long id;

    private String orderToken;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private ZonedDateTime orderedAt;

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

    @Builder
    public Order(Member member) {
        this.orderToken = TokenGenerator.randomCharacterWithPrefix(ORDER_PREFIX);
        this.member = member;
        this.orderedAt = ZonedDateTime.now();
        this.status = Status.ORDER_INIT;
    }
}
