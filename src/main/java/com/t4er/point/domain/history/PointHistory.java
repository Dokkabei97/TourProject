package com.t4er.point.domain.history;

import com.t4er.common.entity.AbstractEntity;
import com.t4er.common.exception.InvalidParamException;
import com.t4er.point.domain.Point;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "point_historys")
public class PointHistory extends AbstractEntity {

    @Id @GeneratedValue
    @Column(name = "point_historys_id")
    private Long id;

    private String pointHistory;
    private Long changedPoint;
    private ZonedDateTime pointUsedAt;
    private Long beforePoint;
    private Long afterPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "points_id")
    private Point point;

    @Builder
    public PointHistory(String pointHistory, Long changedPoint, Point Point) {
        this.pointHistory = pointHistory;
        this.pointUsedAt = ZonedDateTime.now();
        this.beforePoint = point.getPoint();

        if (changedPoint > 0) { // 포인트 적립
            this.afterPoint = beforePoint + changedPoint;
        } else { // 포인트 사용
            if ((point.getPoint() - changedPoint) < 0) throw new InvalidParamException("포인트 부족");
            else this.afterPoint = beforePoint - changedPoint;
        }

    }
}
