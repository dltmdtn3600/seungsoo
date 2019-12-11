package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.board.dao.BoardDAO;
import com.simple.board.service.BoardService;
import com.simple.command.BoardVO;
import com.simple.command.ScoreVO;


@Controller
@RequestMapping("/service")
public class BoardServiceComtroller {

	
	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	
	@Autowired
	@Qualifier("boardDao")
	private BoardDAO boardDao;
	
	@RequestMapping(value="/boardRegister")
	public String boardRegister() {
		return "service/boardRegister";
	}
	
	@RequestMapping(value="/boardForm", method=RequestMethod.POST)
	public String boardForm(BoardVO vo) {
		
		boardService.register(vo);
		
		return "service/boardResult";
	}
	
	@RequestMapping(value="/boardList")
	public String boardList(Model model) {	
			
		ArrayList<BoardVO> boardList = boardService.getList();
		model.addAttribute("boardList",boardList);
		
		return "service/boardList";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int num) {

		boardService.delete(num);
		
		return "redirect:/service/boardList";
		
	}
	
	
}
