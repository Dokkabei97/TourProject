package com.t4er.point.domain.history;

import com.t4er.common.entity.AbstractEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "point_historys")
public class PointHistory extends AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String pointHistory;

    private Long point;

}
