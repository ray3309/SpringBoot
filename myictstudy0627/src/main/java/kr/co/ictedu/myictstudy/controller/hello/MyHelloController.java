package kr.co.ictedu.myictstudy.controller.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class MyHelloController {

	@GetMapping("/hello")
	public String getMethodName() {
		return "안녕하세요 저는 스프링 부트입니다.";
	}
	
}
