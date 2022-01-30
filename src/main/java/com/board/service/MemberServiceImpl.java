package com.board.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.MemberDao;
import com.board.domain.Member;



@Service // service bean으로 등록
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;
	
	@Override
	public boolean loginCheck(Member vo,HttpSession session) {
		
		boolean result = dao.loginCheck(vo);   //id pwd 잘넘어옴
		if (result == true) {	//true 일경우 세션 등록
			//세션 변수 등록
			session.setAttribute("userid",vo.getUserid());
		}
		
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		dao.logout(session);
	}


//
//@Override
//public Member viewMember(Member member) {
//	return memberDao.viewMember(member);
//}
}