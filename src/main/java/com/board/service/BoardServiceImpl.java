package com.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.domain.BoardVo;




@Service
public class BoardServiceImpl implements BoardService {
	
	
	@Inject
	 private BoardDao dao;
	

	
//	@Override
//	public List<BoardVo> list() throws Exception{
//
//		return dao.list();
//	}
//	
	
	// 게시물 목록 + 페이징
	@Override
	public List list(int displayPost, int postNum) throws Exception {
	 return dao.list(displayPost, postNum);
	}


	@Override
	public void write(BoardVo vo) throws Exception {
		
		 dao.write(vo);
		
	}
	
	
	@Override
	public BoardVo view(int idx) throws Exception {
		
		return dao.view(idx);
		
	}
	@Override
	public void modify(BoardVo vo) throws Exception {
		
		 dao.modify(vo);
		
	}

	@Override
	public void delete(String idx) throws Exception {
		
		dao.delete(idx);
		
	}
	public int count() throws Exception{
		return dao.count();
	}

	
	/*필요없는 부분*/
	@Override
	public List<BoardVo> listAll(String searchOption, String keyword) throws Exception {
		
		return dao.listAll(searchOption, keyword);
	}
	/*지금은 필요없는 */
	@Override
	public int countBoard(String searchOption, String keyword) throws Exception {
		return dao.countBoard(searchOption, keyword);
	}

	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}


	// 게시물  검색
	@Override
	public List<BoardVo> listPageSearch(
	   String searchType, String keyword) throws Exception {
	 return  dao.listPageSearch( searchType, keyword);
	}
	
//	// 게시물 목록 + 페이징
//	@Override
//	public List listPage(int displayPost, int postNum) throws Exception {
//	 return dao.listPage(displayPost, postNum);
//	}
	// 게시물 목록 + 페이징 + 검색
	
	@Override
	public List<BoardVo> listSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		return  dao.listSearch(displayPost, postNum, searchType, keyword);
	}
	
	
	
	
	// 게시물 총 갯수
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
	 return dao.searchCount(searchType, keyword);
	}
	
}