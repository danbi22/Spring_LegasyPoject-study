package com.itwill.spring2.service;

import org.springframework.stereotype.Service;

import com.itwill.spring2.domain.Reply;
import com.itwill.spring2.dto.ReplyCreateDto;
import com.itwill.spring2.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화하는 생성자. 생성자에 의한 의존성 주입
@Service // 스프링 컨텍스트에 서비스 컴포넌트 객체로 등록
public class ReplyService {
    
    private final ReplyRepository replyRepository; // final은 선언과 동시에 초기화 되어야하는데 @RequiredArgsConstructor가 초기화 해준다.

    public int create(ReplyCreateDto dto) {
        log.info("create(dto={})", dto);
        
        return replyRepository.insert(dto.toEntity());
    }
    
    
    
}
