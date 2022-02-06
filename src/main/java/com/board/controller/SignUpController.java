package com.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.domain.Member;
import com.board.service.SignUpService;

@Controller
@RequestMapping("/board/")
public class SignUpController {

	@Autowired
	SignUpService service;
	
	//리스트에서 SignUP 이나 로그인화면에서 회원가입 클릭시
	@RequestMapping(value ="/signUpPage")
	public String signUpPage(){
		
		return "board/signUp";
	}
	
	//회원가입페이지내에서 회원가입 버튼 클릭시
	@RequestMapping(value = "/signUp")
	public String signUp(Member vo) {
		
		service.signUp(vo);
		
		return "board/beforeLogin";
	}
	
	//produces는 ajax가 데이터 넘겨받을때 깨짐 방지
	@RequestMapping(value = "/idCheck",method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		
		String userid = request.getParameter("userid");
		int result=service.idCheck(userid);
		return Integer.toString(result);
	}
	
}
