package com.board.dao;

import java.util.List;

import com.board.domain.ReplyVo;

public interface ReplyDao {
	
	// 댓글 조회
	public List<ReplyVo> list(int idx) throws Exception;

	// 댓글 조회
	public void write(ReplyVo vo) throws Exception;

	// 댓글 수정
	public void modify(ReplyVo vo) throws Exception;

	// 댓글 삭제
	public void delete(int replyIdx) throws Exception;

	// 댓글 상세
	public ReplyVo reply_view(int replyIdx) throws Exception;
}
