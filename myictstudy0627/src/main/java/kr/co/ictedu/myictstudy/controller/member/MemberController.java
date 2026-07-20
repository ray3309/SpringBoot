package kr.co.ictedu.myictstudy.controller.member;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ictedu.myictstudy.vo.MemberVO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



//memberAdd() : post방식으로 데이터를 입력후 list로 이동하기
//
//membrerList(): JsonArray 출력
//
//memberDetail() :  매개변수를 받아서 JsonObject출력
@RestController
@RequestMapping("/member")
public class MemberController {

   @PostMapping("/add")
   public ModelAndView memberAdd(MemberVO vo) {
       ModelAndView mav = new ModelAndView();
       System.out.println(vo.getUsername());
       mav.setViewName("redirect:list");
	   return mav;
   }
   @GetMapping("/list")
   public List<MemberVO> memberList() {
       List<MemberVO> list = new ArrayList<>();

       for (int i = 0; i < 3; i++) {
           MemberVO vo = new MemberVO();
           vo.setMemberId((long) (i + 1));
           vo.setUsername("user" + i);
           vo.setPassword("pass" + i);
           vo.setName("홍길동" + i);
           vo.setEmail("user" + i + "@example.com");
           vo.setPhone("010-1234-567" + i);
           vo.setAddress("서울시 강남구 " + i + "번지");
           vo.setRole("USER");
           vo.setRegDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
           list.add(vo);
       }

       return list;
   }
   @GetMapping("/detail")
   public MemberVO memberDetail(@RequestParam("memberId") Long memberId) {
       System.out.println("detail => " + memberId);

       MemberVO vo = new MemberVO();
       vo.setMemberId(memberId);
       vo.setUsername("user" + memberId);
       vo.setPassword("pass" + memberId);
       vo.setName("홍길동" + memberId);
       vo.setEmail("user" + memberId + "@example.com");
       vo.setPhone("010-1234-567" + memberId);
       vo.setAddress("서울시 강남구 " + memberId + "번지");
       vo.setRole("USER");
       vo.setRegDate(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));

       return vo;
   }

}
