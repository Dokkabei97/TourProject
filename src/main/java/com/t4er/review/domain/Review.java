package com.t4er.review.domain;

import com.t4er.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "reviews")
public class Review {

    private final static String POST_PREFIX = "rev_";

    @Id @GeneratedValue
    @Column(name = "reviews_id")
    private Long id;

    @Lob
    private String content;

    private Double star;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Member author;
}
