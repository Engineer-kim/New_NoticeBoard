package com.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.Member;
import com.board.service.MemberService;


@Controller // 컨트롤러 빈으로 등록 
@RequestMapping("/board/")
@SessionAttributes("login")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("login")
	public String login() {
		return "board/login";
	}
	
	//로그인 처리
		@RequestMapping(value="/loginCheck")
		public ModelAndView loginCheck(@ModelAttribute Member vo,HttpSession session) {
			
			boolean result = memberService.loginCheck(vo, session); //id ,pwd 잘 넘어옴
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("board/login");
			
			if(result) {
				mav.addObject("msg","성공");
			}else {
				mav.addObject("msg","실패");
			}
			
			return mav;
		}
//		//로그인 시 게시판 이동 
//		@RequestMapping(value="/loginSession")
//		public ModelAndView loginSession(@ModelAttribute Member vo, HttpSession session) {
//			
//			boolean result = memberService.loginCheck(vo, session); //id ,pwd 잘 넘어옴
//			
//			ModelAndView mav = new ModelAndView();
//			mav.setViewName("board/loginSuccess");
//			
//			if(result) {
//				mav.addObject("msg","성공");
//			}else {
//				mav.addObject("msg","실패");
//			}
//			
//			return mav;
//		}
//		
//		
		//로그아웃 처리
		@RequestMapping("logout")
		public ModelAndView logout(HttpSession session) {
			
			memberService.logout(session);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("home");
			mav.addObject("msg", "logout");
			
			return mav;
		}


 }