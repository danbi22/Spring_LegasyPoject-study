package com.itwill.spring2.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring2.domain.Reply;
import com.itwill.spring2.dto.ReplyCreateDto;
import com.itwill.spring2.dto.ReplyReadDto;
import com.itwill.spring2.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController // 리턴을 하면 dispacherServlet이 jackson-databind를 활용하여 json형식의 문자열로 바꿔준다.
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/reply")
public class ReplyController {

    private final ReplyService replyService;
    
    @PostMapping
    public ResponseEntity<Integer> createReply(
            @RequestBody ReplyCreateDto dto) { // @RequestBody가 기본생성자를 만들고 RequestBody의 값을 가져와 setter메서드를 이용해 값을 넣어줌
        log.info("createReply(dto={})", dto);
        
        int result = replyService.create(dto);
        
        // TODO
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/all/{postId}")
    public ResponseEntity<List<ReplyReadDto>> read(@PathVariable long postId) { // @PathVariable 패스 변수의 값을 꺼내서 저장해준다.
        log.info("read(postId={})", postId);
        
        List<ReplyReadDto> list = replyService.read(postId);
        log.info("# of replies = {}", list.size());
        
        return ResponseEntity.ok(list);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteReply(@PathVariable long id) {
        log.info("deleteReply(id={}", id);
        
        int result = replyService.delete(id);
        
        return ResponseEntity.ok(result);
    }
    
//    @Data @AllArgsConstructor
//    public class Test {
//        private int age;
//        private String name;
//    }
//    
//    @GetMapping
//    public Test hello() {
//        log.info("hello()");
//        
//        return new Test(26, "다한");
//    }
    
}
