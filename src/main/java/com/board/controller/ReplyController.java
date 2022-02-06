package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVo;
import com.board.domain.ReplyVo;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	private ReplyService replyService;
	
	// 댓글 작성   GET 방식으로 입력 받은 파라미터를 잘 읽어옴
	@RequestMapping(value = "/write", method= RequestMethod.POST)
	public String replyWirte(ReplyVo vo) throws Exception {
	    
	    replyService.write(vo);
	    
	    return "redirect:/board/view?idx=" + vo.getIdx();
	}
	
//	//댓글 리스트
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public void replyList(Model model ,@RequestParam("idx") int idx) throws Exception {
//	 
//		
//
//		List<ReplyVo> list = null; 
//		list = replyService.list(idx);
//
//		model.addAttribute("list", list);   
//	}
//
	
	
//	http://localhost:8080/reply/delete?replyIdx=65   댓글 삭제 버튼 클릭시
//	http://localhost:8080/reply/modify?idx=117?replyIdx=65  댓글 수정버튼 클릭시
	 
	
	
	
	
	@RequestMapping(value ="/delete" , method = RequestMethod.GET)
	public String delete(BoardVo vo , int replyIdx , Model model ) throws Exception{
			
		replyService.delete(replyIdx);
	//	model.addAttribute("idx",idx );
	    return "redirect:/board/view?idx=" + vo.getIdx();   //삭제는 되는데 view.idx= 0 으로 받아옴  ,삭제 쿼리는 실제로 돌아서 해당 데이터 삭제됨 
	    //하지만 라우터 오류로  해당 댓글이 달려있던 게시판 상세페이지로 이동불가 500 error board.idx  관한 오류
	}
		
	
	@RequestMapping(value = "/replyModify", method = RequestMethod.GET)
	public void Modify(@RequestParam("replyIdx") int replyIdx, Model model) throws Exception {
		
		ReplyVo vo =replyService.reply_view(replyIdx);
		//vo.setReplyIdx(replyIdx);

		
		model.addAttribute("reply_view",vo);
	}
	
	

	
	// 게시물 수정 
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String Modify(ReplyVo vo) throws Exception {

	replyService.modify(vo);
		   
	return "redirect:/board/view?idx=" + vo.getIdx();  // 상세페이지로 다시 이동
	
	}
		
}
