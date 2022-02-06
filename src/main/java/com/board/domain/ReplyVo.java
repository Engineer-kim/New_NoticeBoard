package com.board.domain;



public class ReplyVo {
	
	
	/*답글 idx*/
	private int replyIdx;
	
	/*게시글 idx(PK  board 테이블에서 참조함)*/
	private int idx;
	
	/*작성자*/
	private String writer;
	
	/* 글내용*/
	private String content;
	
	

	public int getReplyIdx() {
		return replyIdx;
	}

	public void setReplyIdx(int replyIdx) {
		this.replyIdx = replyIdx;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	
}
