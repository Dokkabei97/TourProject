package com.t4er.post.domain;

import com.t4er.member.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "posts")
public class Post {

    private final static String POST_PREFIX = "pos_";

    @Id @GeneratedValue
    @Column(name = "posts_id")
    private Long id;

    @Column(updatable = false)
    private String postToken;
    private String title;
    @Lob
    private String content;

    private String postImages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "members_id")
    private Member author;

}
