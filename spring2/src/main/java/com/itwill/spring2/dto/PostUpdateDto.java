package com.itwill.spring2.dto;

import java.time.LocalDateTime;

import com.itwill.spring2.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Builder
public class PostUpdateDto {
    private long id;
    private String title;
    private String content;
    
    // PostUpdateDto 객체를 Post 타입 객체로 변환
    public Post toEntity() {
        return Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .modified_time(LocalDateTime.now())
                .build();
    }
}
