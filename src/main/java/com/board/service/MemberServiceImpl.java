package com.board.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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

	
	
	/*회원 정보 상세*/
	
	@Override
	public Member detail(String userid) {
		return dao.detail(userid);
	}
	
	/*회원 정보 수정*/
	@Override
	public int update(String userid) throws Exception {
		return dao.update(userid);
	}
	
	/*아이디 찿기 */
	@Override
	public List<Member> findId(String email)throws Exception{
		return dao.findId(email);
	}
	
	@Override
	public int findIdCheck(String email)throws Exception{
		return dao.findIdCheck(email);
	}
	
	/*패스워드 찿기 */
	@Override
	public int findPwCheck(Member member)throws Exception{
		return dao.findPwCheck(member);
	}
    
    	@Override
	public void findPw(String memberEmail,String memberId)throws Exception{
    		//TO DO: mail Smtp 구성후 코딩 
	}	
	
}