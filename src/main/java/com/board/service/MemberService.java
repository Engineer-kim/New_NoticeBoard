package com.board.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.board.domain.Member;

public interface MemberService {

		/*로그인 여부 확인(세션)*/
		public boolean loginCheck(Member vo,HttpSession session);
		
		
		/*로그아웃*/
		public void logout(HttpSession session);

		/*회원 상세정보 페이지*/
		public Member detail(String userid);

		/*회원정보 수정 페이지*/
		public int update(String userid)throws Exception;

		/*아이디 찿기 관련*/		
		public List<Member> findId(String email)throws Exception;
		
		public int findIdCheck(String email)throws Exception;
		
	   /*비밀번호 찿기 관련  email Smtp 구현 안됨*/
		public void findPw(String email,String userid)throws Exception;

		public int findPwCheck(Member member)throws Exception; 
}


