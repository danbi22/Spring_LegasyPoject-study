package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itwill.spring2.domain.Reply;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
            locations = {"file:src/main/webapp/WEB-INF/application-context.xml"}
)
public class ReplyRepositoryTest {

    // Repoditory 객체를 주입받음(의존성 주입, DI). MyBatis가 의존성 주입해줌
    @Autowired
    private ReplyRepository replyRepository;
    
    //@Test
    public void test() {
        Assertions.assertNotNull(replyRepository);
        log.info("replyRepository = ({})", replyRepository);
        
        List<Reply> list = replyRepository.selectByPostId(101);
        for (Reply reply : list) {
            log.info(reply.toString());
        }
    }
    
    //@Test
    public void testInsert() {
        Reply reply = Reply.builder()
                            .post_id(101)
                            .writer("guest")
                            .reply_text("JUnit test")
                            .build();
        int result = replyRepository.insert(reply);
        log.info("result = {}", result);
    }
    
    
    //@Test
    public void testUpdate() {
        Reply entity = Reply.builder()
                            .id(4)
                            .reply_text("댓글 수정")
                            .build();
        int result = replyRepository.update(entity);
        log.info("result = {}", result);
    }
    
    //@Test
    public void testDelete() {
        int result = replyRepository.delete(2);
        log.info("result = {}", result);
    }
    
    @Test
    public void testSelectReplyCountWithPostID() {
        long result = replyRepository.selectReplyCountWithPostID(102);
        log.info("result = {}", result);
    }
    
}
