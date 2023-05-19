package com.itwill.spring2.dto;

import com.itwill.spring2.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter, Setter, toString, equals, hashCode
@AllArgsConstructor // 모든 필드를 갖는 생성자
@NoArgsConstructor // 기본 생성자
@Builder // 빌더패턴 생성
public class PostCreateDto {
    
    private String title;
    private String content;
    private String author;
    
    // PostCreateDto 타입의 객체를 Post 타입의 객체로 변환해서 리턴.
    // 객체가 가지고 있는 필드를 가지고 만들기에 static이 아님 
    public Post toEntity() { 
        // return new Post(0, title, content, author, null, null);
        // -> 직관적이지 않음, 순서가 변경되면 다른 값이 들어갈 위험이 있음.
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
