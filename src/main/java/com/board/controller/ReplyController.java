package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVo;
import com.board.domain.Page;
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
}
