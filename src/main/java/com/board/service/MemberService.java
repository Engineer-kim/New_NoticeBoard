package com.board.service;

import javax.servlet.http.HttpSession;

import com.board.domain.Member;

public interface MemberService {

	
		public boolean loginCheck(Member vo,HttpSession session);
		
		
		public void logout(HttpSession session);
}
