package com.t4er.point.domain;

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
@Table(name = "points")
public class Point extends AbstractEntity {

    @Id @GeneratedValue
    private Long id;

    private Long point;
}
