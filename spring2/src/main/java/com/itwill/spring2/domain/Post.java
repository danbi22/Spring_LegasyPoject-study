package com.itwill.spring2.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 기본생성자 
@AllArgsConstructor // 모든 속성을 갖는 생성자
@Builder // 빌더 패턴
@Getter
@Setter
@ToString
public class Post {
    
    private String title;
    private String content;
    private long id;
    private String author;
    private LocalDateTime created_time;
    private LocalDateTime modified_time;
}
