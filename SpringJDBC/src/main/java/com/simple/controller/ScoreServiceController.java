package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreDAO;
import com.simple.score.service.ScoreService;

@Controller
@RequestMapping("/service")
public class ScoreServiceController {
	
	//1st
//	private ScoreService sv  = new ScoreServiceImpl();이승수
	//2nd
//	@Autowired
//	private ScoreService scoreService;
	
	//3nd
	@Autowired
	@Qualifier("scoreService")
	private ScoreService scoreService;
	
	@Autowired
	@Qualifier("scoreDao")
	private ScoreDAO scoreDao;
	
	
	//화면처리
	@RequestMapping(value="/scoreRegist")
	public String scoreRegist() {
		return "service/scoreRegist";
	}
	
	//점수등록 메서드
	@RequestMapping(value="/scoreForm", method=RequestMethod.POST)
	public String scoreForm(ScoreVO vo) {
		
		scoreService.scoreRegist(vo);
		
		return "service/scoreResult";
	}
	
	//점수목록 화면처리
	@RequestMapping(value="/scoreList")
	public String scoreList(Model model) {	
		
		//DAO에 있는 arraylist를 화면까지 전달
		ArrayList<ScoreVO> scoreList = scoreService.scoregetList();
		//메서드 파라미터에 Mdel을 추가하고, model에 결과를 담음
		model.addAttribute("scoreList",scoreList);
		
		return "service/scoreList";
	}
	
	//점수삭제
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num") int num) {

		scoreService.scoreDelete(num);
		
		//삭제후 다시 컨트롤러를 태워서 보냄
		return "redirect:/service/scoreList";
		
	}
	
}
