package kr.co.ictedu.myictstudy.controller.memo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import kr.co.ictedu.myictstudy.vo.MemoVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


//http://localhost/myictstudy/memo 작동 
@RestController
@RequestMapping("/memo") //요청에서 대분류 지정
public class MemoController {

	//http://localhost/myictstudy/memo/add 작동
	//Post방식
	@PostMapping("/add") // 해당 작업 요청
	public ModelAndView addMemo(MemoVO vo) {
		System.out.println("번호:"+vo.getNum());
		System.out.println("작성자:"+vo.getWriter());
		System.out.println("내용:"+vo.getConts());
		System.out.println("아이피:"+vo.getMreip());
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		
		return mav;
	}
	//memo/list 
	//json형식으로 형식으로 출력을 해준다. @RestController 설정값이다.
	//@RequestMapping(value = "/list", method = RequestMethod.POST) =>@PostMapping 
	@RequestMapping(value = "/list", method = RequestMethod.GET) //=> @GetMapping
	//jsonArray로 반환 
	//@RequestMapping("/list") 
	public List<MemoVO> memoList(Model m){
		List<MemoVO> list = new ArrayList<>();
		
		for(int i=0; i<3; i++) {
			MemoVO vo = new MemoVO();
			vo.setNum(i+1);
			vo.setWriter("테스형"+i);
			vo.setConts("반가워요"+i);
			vo.setMreip("192.168.0.11");
			vo.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			list.add(vo);
		}
		return list;
	}
	//jsonObject으로 반환 
	//@RequestParam("파라미터이름") int 매개변수
	//localhost/myictstudy/memo/detail?num=1
	@GetMapping("/detail")
	public MemoVO memoDetail(@RequestParam("num") int num) {
		System.out.println("detail =>"+num);
		int i=num;
		MemoVO vo = new MemoVO();
		vo.setNum(i);
		vo.setWriter("테스형"+i);
		vo.setConts("반가워요"+i);
		vo.setMreip("192.168.0.11");
		vo.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return vo;
	}
	
	//삭제 처리 =>@DeleteMapping , @PostMapping
	//비동기식으로 method : 'delete; -> 비동기식 RestFulAPI 통신 
	@DeleteMapping("/delete")
	public ModelAndView memoDelete(@RequestParam("num") int num) {
		System.out.println("삭제 처리 :"+num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:list");
		return mav;
	}
	

	
	
	
	
	
}




