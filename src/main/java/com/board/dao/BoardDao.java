package com.board.dao;

import java.util.List;

import com.board.domain.BoardVo;

import com.board.domain.Search;

public interface BoardDao {
	
	//메인 리스트 출력 
//	public List<BoardVo> list() throws Exception; 
	
	
	 public List list(int displayPost, int postNum) throws Exception;
	
	// 글 작성 
	public void write(BoardVo vo) throws Exception;
	
	//상세보기
	public BoardVo view(int idx) throws Exception;
	
	
	public void modify(BoardVo vo) throws Exception;
	
	// 게시물 삭제
	public void delete(String idx) throws Exception;

	// 게시물 총 갯수
	public int count()  throws Exception;

	public List<BoardVo> listAll(String searchOption, String keyword) throws Exception;

	public int countBoard(String searchOption, String keyword) throws Exception;
   
	//검색
	 public List<BoardVo> listPageSearch(
	    String searchType, String keyword) throws Exception;
	 
	 
//	// 게시물 목록 + 페이징
//	 public List listPage(int displayPost, int postNum) throws Exception;

	// 게시물 목록 + 페이징 + 검색
	 public List<BoardVo> listSearch(
	   int displayPost, int postNum, String searchType, String keyword) throws Exception;
	 
	 
	
	 public int searchCount(String searchType, String keyword) throws Exception;
}
