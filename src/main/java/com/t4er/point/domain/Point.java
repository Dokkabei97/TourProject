package com.t4er.point.domain;

import com.google.common.collect.Lists;
import com.t4er.common.entity.AbstractEntity;
import com.t4er.member.domain.Member;
import com.t4er.point.domain.history.PointHistory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "points")
public class Point extends AbstractEntity {

    @Id @GeneratedValue
    @Column(name = "points_id")
    private Long id;

    private Long point;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Member member;

    @OneToMany(mappedBy = "point")
    private List<PointHistory> pointHistory = Lists.newArrayList();

    public Point(Long point) {
        this.point = point;
    }

    public void usedPoint(Long point) {
        this.point = this.point - point;
    }

    public void addPoint(Long point) {
        this.point = this.point + point;
    }
}
