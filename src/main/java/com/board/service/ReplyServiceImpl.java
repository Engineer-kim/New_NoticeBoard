package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.ReplyDao;
import com.board.domain.ReplyVo;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyDao dao;

	// 댓글 조회
	@Override
	public List<ReplyVo> list(int idx) throws Exception {
	    return dao.list(idx);
	}

	@Override
	public void write(ReplyVo vo) throws Exception {
	    dao.write(vo);     //regDt == null 로 넘어와서 500 error 댓글 등록안되는 오류 
	}

	@Override
	public void modify(ReplyVo vo) throws Exception {
	    dao.modify(vo);
	}

	@Override
	public void delete(ReplyVo vo) throws Exception {
	    dao.delete(vo);
	}
}
