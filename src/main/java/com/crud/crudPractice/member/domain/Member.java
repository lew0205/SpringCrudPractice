package com.crud.crudPractice.member.domain;

import com.crud.crudPractice.post.domain.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNum;
    private Long age;
    @OneToMany
    private List<Post> posts;
}
