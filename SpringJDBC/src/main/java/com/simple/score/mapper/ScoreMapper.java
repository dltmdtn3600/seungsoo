package com.simple.score.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.simple.command.ScoreVO;

public interface ScoreMapper {
	
	//public void scoreRegist(HashMap<String, String> map);
	public void scoreRegist(ScoreVO vo);
	public ArrayList<ScoreVO> scoreList();
	public int scoreDelete(int num);
	
}
