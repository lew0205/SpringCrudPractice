package com.crud.crudPractice.post.domain;

import com.crud.crudPractice.member.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostForm {
    String Title;
    String Content;
    Long Author;
}
