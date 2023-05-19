package com.itwill.spring2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.dto.PostCreateDto;
import com.itwill.spring2.dto.PostListDto;
import com.itwill.spring2.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그
@Controller // dispacherServlet에게 컨트롤러 컴포넌트로 등록
@RequiredArgsConstructor // 생성자에 의한 의존성 주입
@RequestMapping("/post") // PostController 클래스의 메서드들은 요청 주소가 "/post"로 시작.
public class PostController {
    
    private final PostService postService; // 생성자에 의한 의존성 주입
    
    @GetMapping("/list")
    public void list(Model model) { // 리턴 값이 없는 경우 뷰의 이름은 요청주소의 이름과 같다
        log.info("list()");
        // 리턴 값이 없는 경우 뷰의 이름은 요청 주소와 같은
        // /WEB-INF/views/post/list.jsp
        
        // 컨트롤러는 서비스 계층의 메서드를 호출해서 서비스 기능을 수행
        List<PostListDto> list = postService.read();
        
        // 뷰에 보여줄 데이터를 Model에 저장
        model.addAttribute("posts", list);
    }
    
    @GetMapping("/create")
    public void create() {
        log.info("GET: create()");
    }
    
    @PostMapping("/create")
    public String create(PostCreateDto dto) {
        log.info("POST: create({})", dto);
        
        // 서비스 계층의 메서드를 호출 - 새 포스트 등록
        int result = postService.create(dto);
        log.info("포스트 등록 결과 = {}", result);
               
        return "redirect:/post/list";
    }

}
