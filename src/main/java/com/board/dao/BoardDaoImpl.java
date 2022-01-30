package com.board.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVo;
import com.board.domain.Search;



@Repository
public class BoardDaoImpl implements BoardDao {

 @Inject
 private SqlSession sql;
 
 private static String namespace = "com.board.mappers.board";

 // 게시물 목록(메인 리스트 )
// 	@Override
// 	public List list() throws Exception { 
//  
// 			return sql.selectList(namespace + ".list");
// 		}
 
	// 게시물 목록 + 페이징
 @Override
 public List list(int displayPost, int postNum) throws Exception {

  HashMap data = new HashMap();
   
  data.put("displayPost", displayPost);
  data.put("postNum", postNum);
   
  return sql.selectList(namespace + ".list", data);
 }

 
 
 	// 글 작성 메소드
 	@Override
 	public void write(BoardVo vo) throws Exception {
 		sql.insert(namespace + ".write", vo);
 		
 	}
 // 게시물 조회
 	public BoardVo view(int idx) throws Exception {
 	 
 	 return sql.selectOne(namespace + ".view", idx);
 	}
 	
 	/* 글 수정*/
	@Override
	public void modify(BoardVo vo) throws Exception {
		sql.update(namespace + ".modify", vo);
	}
	
	@Override
	public void delete(String idx) throws Exception {
		sql.delete(namespace +  ".delete" , idx);
		
	}
	@Override
	public int count() throws Exception {
	   return sql.selectOne(namespace +  ".count" );
	}
	@Override
	public List<BoardVo> listAll(String searchOption, String keyword) throws Exception {
		Map<String, String> map = new HashMap<String , String>();
		map.put("keyword", keyword);
		map.put("searchOption", searchOption);
		return sql.selectList("listAll", map);
	}
	@Override
	public int countBoard(String searchOption, String keyword) throws Exception {
		Map<String, String> map = new HashMap<String , String>();
		map.put("keyword", keyword);
		map.put("searchOption", searchOption);
		return sql.selectOne("countBoard", map);
	}
	
	/*selectOne은 하나의 레코드  , SelectList는 여러(리스트니까) 레코드*/
	
	// 게시물 목록 + 페이징 + 검색
	 @Override
	 public List<BoardVo> listPageSearch(
	  String searchType, String keyword) throws Exception {

	  HashMap<String, Object> data = new HashMap<String, Object>();
	  
	  
	  
	  data.put("searchType", searchType);
	  data.put("keyword", keyword);
	  
	  return sql.selectList(namespace + ".listPageSearch", data);
	 }



	@Override
	public List<BoardVo> listSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		
		 HashMap<String, Object> data = new HashMap<String, Object>();
		  
		  data.put("displayPost", displayPost);
		  data.put("postNum", postNum);
		  
		  data.put("searchType", searchType);
		  data.put("keyword", keyword);
		  
		  return sql.selectList(namespace + ".listSearch", data);
	}
	
//	// 게시물 목록 + 페이징
//	 @Override
//	 public List listPage(int displayPost, int postNum) throws Exception {
//
//	  HashMap data = new HashMap();
//	   
//	  data.put("displayPost", displayPost);
//	  data.put("postNum", postNum);
//	   
//	  return sql.selectList(namespace + ".listPage", data);
//	 }
	
	
	

	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
	 
	 HashMap data = new HashMap();
	 
	 data.put("searchType", searchType);
	 data.put("keyword", keyword);
	 
	 return sql.selectOne(namespace + ".searchCount", data); 
	}

	
	
}