package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itwill.spring2.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
            locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
)
public class Repositoty {
    
    @Autowired // 구현하지 않은 인터페이스의 객체를 만들었다.
    private PostRepository postRepository;
    
    //@Test
    public void testUpdateTitleAndContent() {
        Post post = Post.builder()
                .id(41)
                .title("하이")
                .content("방가")
                .build();
        int result = postRepository.updateTitleAndContent(post);
        Assertions.assertEquals(1, result);
    }
    
    @Test
    public void testDeleteById() {
        int result = postRepository.deleteById(2);
        Assertions.assertEquals(1, result);
    }
    
    
    //@Test
    public void testSelectById() {
        Post post = postRepository.selectById(41);
        Assertions.assertNotNull(post);
        log.info("post = {}", post);
        
        post = postRepository.selectById(-1);
        Assertions.assertNull(post);
    }
    
    
    
    //@Test
    public void testSelectOrderByIdDesc() {
        List<Post> list = postRepository.selectOrderByIdDesc();
        for (Post p : list) {
            log.info(p.toString());
        }
    }
    
//    @Test
    public void testPostRepositoty() {
        Assertions.assertNotNull(postRepository);
        log.info("postRepository={}", postRepository);
        
        Post post = Post.builder()
                .title("MyBatis 테스트")
                .content("MyBatis를 이용한 insert")
                .author("admin")
                .build();
        log.info(post.toString());
        
        int result = postRepository.insert(post);
        Assertions.assertEquals(1, result);
        log.info("result = {}", result);
    }

}
