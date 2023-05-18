package com.itwill.spring2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller // 나는 컨트롤러다라고 dispatcherServlet에게 말해주는 애너테이션
@Slf4j // Logging기능을 사용하기 위한 애너테이션
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        log.info("home()");
        
        return "index";
    }
    
    

}
