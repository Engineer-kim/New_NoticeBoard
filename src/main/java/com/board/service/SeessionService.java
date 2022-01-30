package com.board.service;

import javax.servlet.http.HttpSession;

import com.board.domain.Member;

public interface SeessionService {
	
	//패스워드 체크
	public int passCheck(Member vo);
	
	//회원 탈퇴
	public void seession(Member vo,HttpSession session);
}

