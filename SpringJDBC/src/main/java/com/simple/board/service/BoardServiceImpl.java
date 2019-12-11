package com.simple.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.board.mapper.BoardMapper;
import com.simple.command.BoardVO;
import com.simple.command.ScoreVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

//	@Autowired
//	@Qualifier("boardDao")
//	private BoardDAO boardDao;
//	
//	@Override
//	public void register(BoardVO vo) {
//		boardDao.boardInsert(vo);
//	}
//
//	@Override
//	public ArrayList<BoardVO> getList() {
//		
//		return boardDao.boardSelect();
//	}
//
//	@Override
//	public void delete(int num) {
//		boardDao.boardDelete(num);
//	}
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public void register(BoardVO vo) {
		boardMapper.boardRegist(vo);
	}
	
	@Override
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = boardMapper.boardList();
		return list;
	}
	
	@Override
	public void delete(int num) {
		boardMapper.boardDelete(num);
	}
	
	
	
}
