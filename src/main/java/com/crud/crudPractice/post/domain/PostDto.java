package com.crud.crudPractice.post.domain;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    String title;
    String content;
    Long author;

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
