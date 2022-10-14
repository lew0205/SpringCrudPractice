package com.crud.crudPractice.post.domain;

import com.crud.crudPractice.member.domain.Member;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    String title;
    String content;
    Long author;

    public Post toEntity(Member author){
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
