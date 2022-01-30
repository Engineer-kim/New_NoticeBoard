//package com.board.controller;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.UUID;
//
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.board.domain.BoardVo;
//import com.board.service.BoardService;
//import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
//
//@Controller
//@SessionAttributes("board")
//public class FileDownController {
//	
//		@Autowired
//		private BoardService boardService;
//		
//		//글 목록 검색
//		@RequestMapping("/getBoardList.do")
//		public String List(BoardVo vo, Model model) {
//			 List<BoardVo> boardList = boardService.List();
//			 
//			// Model 정보 저장
//			model.addAttribute("boardList",boardList);
//			return "boardList"; // View 이름 리턴
//		}
//
//		// 글 상세 조회
//		@RequestMapping("/view")
//		public String View(BoardVo vo, Model model) {
//			model.addAttribute("board", boardService.view(vo)); // Model 정보 저장
//			return "content"; // View 이름 리턴
//		}
//		
//		// 글 쓰기
//		@RequestMapping(value="/listSearch") 
//		public @ResponseBody String insertBoard(BoardVo vo) throws IOException { 
//				// 파일 업로드 처리
//				String fileName=null;
//				MultipartFile uploadFile = vo.getUploadFile();
//				if (!uploadFile.isEmpty()) {
//					String originalFileName = uploadFile.getOriginalFilename();
//					String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
//					UUID uuid = UUID.randomUUID();	//UUID 구하기
//					fileName=uuid+"."+ext;
//					uploadFile.transferTo(new File("D:\\upload\\" + fileName));
//				}
//				vo.setFileName(fileName);
//				boardService.listSearch(vo); 
//				return "redirect:getBoardList.do"; 
//		}
//		
//		
//
//		// 글 수정
//		@RequestMapping("/modify")
//		public String updateBoard(@ModelAttribute("board") BoardVo vo) {
//			boardService.modify(vo);
//			return "redirect:getBoardList.do";
//		}
//
//		// 글 삭제
//		@RequestMapping("/delete")
//		public String deleteBoard(BoardVo vo) {
//			boardService.delete(vo);
//			return "redirect:getBoardList.do";
//		}
//}
