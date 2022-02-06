package com.board.service;

import java.util.List;
import java.util.Map;

import com.board.domain.BoardVo;


public interface BoardService {

//	public List<BoardVo> list()  throws Exception;
	
	public List list(int displayPost, int postNum) throws Exception;

	/*글작성 메소드*/
	public  void write (BoardVo vo) throws Exception;
	
	/*글 상세보기*/
	public BoardVo view (int idx) throws Exception;
	
	/*글 수정*/
	public  void modify (BoardVo vo) throws Exception;
	
	/*글 삭제*/
	public void delete (String idx) throws Exception;

	
	public int count() throws Exception;

	/*검색 부분*/	
	public List<BoardVo> listAll(String searchOption, String keyword) throws Exception;

	public int countBoard(String searchOption, String keyword) throws Exception;

	public List<Map<String, Object>> list(Map<String, Object> map);

	// 게시물  검색
	public List<BoardVo> listPageSearch(
	   String searchType, String keyword) throws Exception;

	



	public List<BoardVo> listSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;

//	// 게시물 목록 + 페이징
//	public List listPage(int displayPost, int postNum) throws Exception;

	
	public int searchCount(String searchType, String keyword) throws Exception;



}
