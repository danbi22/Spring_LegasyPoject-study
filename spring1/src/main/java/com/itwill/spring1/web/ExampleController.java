package com.itwill.spring1.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.spring1.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

// POJO(Plain Old Java Object): 평범한 자바 객체
// 특정 클래스를 상속해야만 하거나, 상속 후에 메서드들을 override해야만 하는 클래스
// 스프링 프레임워크는 POJO로 작성된 클래스를 controller로 사용할 수 있음.

@Slf4j // Logger 객체(log)를 생성.
@Controller // Spring MVC 컴포넌트 애너테이션들 중 하나. Controller 컴포넌트라는 것을 dispatcherServlet에게 알려줌.
// -> 이 클래스는 컨트롤러 컴포넌트라는 것을 dispatcher
// Spring MVC 컴포넌트 애너테이션들 중에는 (@Component, @Controller, @Service, @Repository, ...)이 있다
public class ExampleController {
    
    @GetMapping("/") // get방식의 요청 주소가 "/" (context root)인 요청을 처리하는 메서드.
    public String home(Model model) {
        log.info("home()");
        // controller에서 데이터를 뷰에 전달하려면 dispatcherServlet에게 모델을 요청해서 그 속성에 데이터를 넣어서 뷰에 보내준다.
        
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("now", now); // 뷰에 전달할 데이터를 세팅.
        
        return "index"; // 뷰의 이름(/WEB-INF/views/index.jsp)
    }
    
    @GetMapping("/ex1")
    public void example1() {
        log.info("example1() 호출");
        // 컨트롤러 메서드가 void인 경우(뷰의 이름을 리턴하지 않는 경우)
        // 요청주소의 이름이 뷰의 이름이 됨.
    }
    
    @GetMapping("/ex2")
    public void getParamEx(String username, int age) { // 파라미터에 쿼리스트링 name을 입력하면 dispatcherServlet이 값을 넣어준다.
        log.info("getParamEx(username={}, age={})", username, age);
        // 컨트롤러 메서드를 선언할 때 파라미터의 이름을 요청 파라미터 이름과 같게 선언하면,
        // DispatcherServlet이 컨트롤러 메서드를 호출하면서 요청 파라미터의 값들을
        // argument로 전달해줌!
    }
    
    @PostMapping("/ex3")
    public String getParamEx2(
            @RequestParam(name = "username") String name, 
            // @RequestParam 애너테이션 name 속성을 사용하면 dispatcherServlet이 name 속성의 값(username)을 분석해서 username을 name의 값에 넣어준다.  
            @RequestParam(defaultValue = "0") int age 
            // 브라우저에서 age input에 빈 문자열을 넣으면 에러가 나기 때문에 @RequestParam(defaultValue = "0")을 통해 기본값을 넣어줌다.
    ) {
        log.info("getParamEx2(name={}, age={})", name, age);
        // 컨트롤러 메서드를 선언할 때, 파라미터 선언 앞에 @RequestParam 애너테이션을 사용하는 경우:
        // (1) 메서드 파라미터와 요청 파라미터 이름이 다를 때, name 속성으로 요청 파라미터 이름을 설정.
        // (2) 요청 파라미터 값이 없거나 비어있을 때, defaultValue 속성 설정.
        return "ex2"; // 만들어진 JSP를 사용하기 위해 JSP 파일 이름을 리턴한다.
    }
    
    @GetMapping("/ex4")
    public String getParamEx3(UserDto user) { // dispatcherServlet이 UserDto객체를 만들어 값을 넣어서 전달해줬다.
        log.info("getParamEx3(user={})", user);
        // DispatcherServlet은 컨트롤러의 메서드를 호출하기 위해서,
        // 1. 요청 파라미터들을 분석(request.getParameter()).
        // 2. UserDto의 기본 생성자를 호출해서 객체를 생성.
        // 3. 요청 파라미터들의 이름으로 UserDto의 setter 메서드를 찾아서 호출.
        // 4. UserDto 객체를 컨트롤러 메서드를 호출할 때 argument로 전달.
        
        return "ex2";
    }
    
    @GetMapping("/sample")
    public void sample() {
        log.info("sample()");
    }

    @GetMapping("/forward") // 요청주소가 남아있는 방식: forward방식
    public String forwardTest() {
        log.info("forwardTest()");
        
        // 컨트롤러 메서드에서 다른 페이지(요청 주소)로 forward하는 방법: forward:(요청 주소)
        // "forward:"으로 시작하는 문자열을 리턴하면,
        // DispatcherServlet은 리턴값이 뷰의 이름이 아니라 포워드 이동할 페이지 주소로 인식.
        return "forward:/sample";
    }
    
    @GetMapping("/redirect") // Post요청이 왔을 때 처리하고 결과를 보여줄 페이지로 Redirect할 때 많이 사용됨 
    public String redirectTest(RedirectAttributes attrs) {
        log.info("redirectTest()");
        
        // 컨트롤러 메서드에서 리다이렉트되는 페이지까지 유지되는 정보를 저장할 때:
        attrs.addFlashAttribute("redAttr", "테스트");
        
        // 컨트롤러 메서드에서 다른 페이지(요청 주소)로 redirect하는 방법: redirect:(요청 주소)
        // "redirect:"으로 시작하는 문자열을 리턴하면,
        // 302: 응답 다시 요청해라
        // DispatcherServlet은 리턴값이 뷰의 이름의 Controller를 찾아
        return "redirect:/sample";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
