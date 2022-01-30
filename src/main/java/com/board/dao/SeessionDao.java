package com.board.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.Member;

@Repository
public class SeessionDao {
	
	@Inject
	SqlSession sqlsessoin;
	
	//패스워드 체크
	public int passCheck(Member vo) {
		int result=sqlsessoin.selectOne("com.board.mappers.member.loginCheck",vo);

		return result;
	}
	
	//회원탈퇴
	public void seession(Member vo,HttpSession session) {
		
		sqlsessoin.delete("com.board.mappers.member.seession",vo);
		//세션 삭제
		session.invalidate();
	}

	
}
