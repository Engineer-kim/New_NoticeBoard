package com.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.domain.Member;

@Repository
public class MemberDao {

	@Autowired
	SqlSession sqlSession;
	
	//로그인 체크
	public boolean loginCheck(Member vo) {
		System.out.println("===> Mybatis로 loginCheck() 기능 처리");
		int result = sqlSession.selectOne("com.board.mappers.member.loginCheck",vo); //id pwd 잘넘어옴
		
		// 검색이 안되면 0을 반환해주기 때문에 0과 비교해서 참이면 false, 틀리면 true를 반환
		return (result==0)?false:true;
	}
	
	//로그 아웃
	public void logout(HttpSession session) {
		System.out.println("===> 로그아웃 기능 처리");
		session.invalidate();
	}
	
	// 회원정보 상세
	public Member detail(String userid) {
		
		return sqlSession.selectOne("com.board.mappers.member.detail" ,userid);
	}
	
	/*회원정보 수정*/
	public int update(String userid) {
		
		return sqlSession.update("com.board.mappers.member.update" ,userid);
	}
	

//	@Transactional
//	public int findPw(Member member) throws Exception{
//		return sqlSession.update("com.board.mappers.member.findPw", member);
//	}
	
	
	/*아이디 첯기*/
	
	public List<Member> findId(String email)throws Exception{
		return sqlSession.selectList("com.board.mappers.member.findId", email);
	}
	
	/*아이디 찿기 성공시 보여줌(실제 아이디가 출력되는곳)*/
	public int findIdCheck(String email)throws Exception{
		return sqlSession.selectOne("com.board.mappers.member.findIdCheck", email);
	}
	
	
	/*비밀번호 찿기 관련 부부*/
	
	public int findPwCheck(Member member)throws Exception{
	return sqlSession.selectOne("com.board.mappers.member.findPwCheck", member);	
	}


	
	public int findPw(String email,String userid,String passwd)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("userid", userid);
		map.put("passwd", passwd);
		return sqlSession.update("com.board.mappers.member.findPw", map);
	}
	
}

