package com.board.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.board.domain.BoardVo;
import com.board.domain.Page;
import com.board.domain.ReplyVo;
import com.board.service.BoardService;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Inject
	private BoardService service;
	
	@Inject
	private ReplyService replyService;
	

    
	// 게시물 목록 + 페이징 추가(검색 안됨 밑의 listSearch 가 검색+ 페이징)
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public void list(Model model, @RequestParam("num") int num) throws Exception {
		 
			Page page = new Page();
			
			page.setNum(num);
			page.setCount(service.count());  

			List<BoardVo> list = null; 
			list = service.list(page.getDisplayPost(), page.getPostNum());

			model.addAttribute("list", list);   
 
			
			model.addAttribute("page",page);

			model.addAttribute("select", num);
		}
	
	
	
	// 게시물 작성P
	//POST 로 데이터를 전송할 때 길이 제한이 따로 없어 용량이 큰 데이터를 보낼 때 사용하거나 보안에서 사용


	// 게시물 작성 버튼 클릭시 제일먼저 타고 
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void Write() throws Exception {
	   
	}
	
	// 폼으로 이어 준다
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String Write(BoardVo vo, Model model ,@RequestParam("num") int num) throws Exception {
	 
//		System.out.println("dsaxsd");
		service.write(vo);
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(service.count());  

		List<BoardVo> list = null; 
		list = service.list(page.getDisplayPost(), page.getPostNum());

		model.addAttribute("list", list);   

		
		model.addAttribute("page",page);

		model.addAttribute("select", num);
	

	  return "redirect:/board/listSearch?num=1";
	}
	// 상세 페이지
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void View(@RequestParam("idx") int idx, Model model) throws Exception {
		
		BoardVo vo =service.view(idx);
		
		model.addAttribute("view",vo);
	
			/*댓글 상세 조회*/
		
		List<ReplyVo> reply = null;  // null 로 최기화
		reply = replyService.list(idx);
		model.addAttribute("reply", reply);
	
	}
	
	
	// 수정 페이지 이동
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void Modify(@RequestParam("idx") int idx, Model model) throws Exception {
		
		BoardVo vo =service.view(idx);
		
		model.addAttribute("view",vo);
	}
	
	// 게시물 수정 페이지 이동후 데이터 불러오는 곳
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String Modify(BoardVo vo) throws Exception {

	 service.modify(vo);
	   
	 return "redirect:/board/view?idx=" + vo.getIdx();  // 상세페이지로 다시 이동
	}
	
	
	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete( String idx) throws Exception {
	  
         service.delete(idx);  
         String str = String.valueOf(idx);   // 선택 삭제를 위해 기존 자료형인 int 가 아닌 String 으로 받아야 삭제가 가능하기에 형변환 을 해주었다
       
         return "redirect:/board/listSearch?num=1";      //쿼리는 정상적으로 돌아서 데이터 삭제가 가능하다 BUt, 삭제이후  해당 링크로 이동 되지 않는 오류 
	}
	

	  //게시물 선택삭제
    	@RequestMapping(value = "/delete")
    public String selectDelete(HttpServletRequest request) throws Exception {
            
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
       for(int i=0; i<size; i++) {
        	service.delete(ajaxMsg[i]);
        }
       return "redirect:/board/listSearch?num=1";
    }

	
	/*게시판 페이지네이션 , 검색, CRUD 가능 , delete 경우 쿼리는 잘일고 데이터는 잘지우는데  list jsp (라우터 문제였음) 로 재이동 불가; 라우터 문제   --> 해결함 2022/01/25*/
	@RequestMapping(value = "/listSearch", method = RequestMethod.GET)
	public void list(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType",required = false, defaultValue = "title") String searchType,
			   @RequestParam(value = "keyword",required = false, defaultValue = "") String keyword) throws Exception {
	 
		 Page page = new Page();
		 
		 page.setNum(num);
		 page.setCount(service.searchCount(searchType, keyword));  
		 
		 
		 page.setSearchType(searchType);
		 page.setKeyword(keyword);
		 
		 List<BoardVo> list = null; 
		
		 list = service.listSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		 
		 model.addAttribute("list", list);
		 model.addAttribute("page", page);
		 model.addAttribute("select", num);
		 
		 
		 
	}


	
	
}