package com.itwill.spring1.dto;

import lombok.Data;

// DTO(Data Transfer Object): 계층 간의 데이터 전달을 위한 객체.
// DispacherServlet <-- Data --> Controller
// Controller <-- Data --> Service

// VO(Value Object): 값을 저장하기 위한 객체.
// 데이터베이스의 테이블 구조를 자바 클래스로 표현한 객체

@Data // 롬복에 있는 어노테이션 @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.를 자동으로 만들어준다.
public class UserDto {
    // 폼에서 전달한 요청 파라미터 값들을 저장하기 위한 클래스
    // DispacherServlet은 필드의 이름에 맞춰서 브라우저에서 받은 값을 넣어준다. -> 필드선언과 JSP의 input name을 맞춰줘야한다.
    private String username;
    private int age;
    private int x;
    
}
