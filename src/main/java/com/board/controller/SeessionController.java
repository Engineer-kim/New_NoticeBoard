package com.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.board.domain.Member;
import com.board.service.SeessionService;


@Controller
@RequestMapping("/board/")
@SessionAttributes("login")
public class SeessionController {
	
	@Inject
	SeessionService service;
	
	//회원탈퇴 페이지
	@RequestMapping(value="seession")
	public String seession() {
		return "board/seession";
	}
	
	//회원탈퇴
	@RequestMapping(value="seessionProc")  // 회원탈퇴시 타는 라우터
	public String seessionProc(Member vo,HttpSession session) {
		
		service.seession(vo,session);
		
		return "board/login";
	}
	
	//패스워드 체크
	@RequestMapping(value="passCheck", method=RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String passCheck(Member vo) {  // id 잘 넘어옴
		
		int result = service.passCheck(vo);   //id 잘 넘어옴  name 의 값을 못 넘어옴 (name 있을떄만)
		return Integer.toString(result);
	//	return String.valueOf(result);
	}
}
