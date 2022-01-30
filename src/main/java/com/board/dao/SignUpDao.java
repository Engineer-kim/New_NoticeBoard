package com.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.domain.Member;

@Repository
public class SignUpDao {
	
	@Autowired
	SqlSession sqlsession;
	
	//아이디 체크
	public int idCheck(String userid) {
		System.out.println("===> Mybatis로 idCheck");
		int result = sqlsession.selectOne("com.board.mappers.member.idCheck",userid);
		return result;
	}
	
	//회원가입
	public void signUp(Member vo) {
		System.out.println("===> Mybatis로 회원가입(signUp)");
		sqlsession.insert("com.board.mappers.member.signUp",vo);
	}
}
