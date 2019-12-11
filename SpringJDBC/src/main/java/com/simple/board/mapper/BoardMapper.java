package com.simple.board.mapper;

import java.util.ArrayList;

import com.simple.command.BoardVO;

public interface BoardMapper {
	public void boardRegist(BoardVO vo);
	public ArrayList<BoardVO> boardList();
	public int boardDelete(int num);
}
