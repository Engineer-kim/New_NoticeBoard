package com.board.service;

import com.board.domain.Member;

public interface SignUpService {

	//아이디 중복 체크
	public int idCheck(String userid);
	
	//회원 가입
	public void signUp(Member vo);

}
