package com.crud.crudPractice.domain.post.presentation.dto;

import com.crud.crudPractice.domain.member.Member;
import com.crud.crudPractice.domain.post.Post;
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
