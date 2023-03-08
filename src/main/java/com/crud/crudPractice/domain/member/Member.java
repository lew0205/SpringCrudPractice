package com.crud.crudPractice.domain.member;

import com.crud.crudPractice.domain.post.Post;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String password;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "author")
    List<Post> posts;
}
