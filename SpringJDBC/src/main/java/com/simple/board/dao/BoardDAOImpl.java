package com.simple.board.dao;

import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.simple.command.BoardVO;

@Repository("boardDao")
public class BoardDAOImpl implements BoardDAO{

	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void boardInsert(BoardVO vo) {
		String sql = "insert into board01(bno, writer, title, content) values(board01_seq.nextval, ?, ?, ?)";
		int result = jdbcTemplate.update(sql, new Object[] {vo.getWriter(), vo.getTitle(), vo.getContent()});
		
		System.out.println("성공실패 : " + result);
	}

	@Override
	public ArrayList<BoardVO> boardSelect() {

		String sql = "select * from board01";
		
		List<BoardVO> list = jdbcTemplate.query(sql,new Object[] {}, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				//rs에는 쿼리에 결과가 담겨있고, rowNum의 개수 만큼 반복
				//rs를 분해해서 return으로 실행결과를 반환
				BoardVO vo = new BoardVO();
				
				vo.setBno( rs.getInt("bno") );
				vo.setWriter( rs.getString("writer") );
				vo.setTitle( rs.getString("title") );
				vo.setContent( rs.getString("content") );
				
				return vo;
				
			}
			
		});
		
		return (ArrayList<BoardVO>)list;
	}

	@Override
	public void boardDelete(int bno) {
		String sql = "delete from board01 where bno = ?";
		
		int result = jdbcTemplate.update(sql,new Object[] {bno });
		System.out.println("삭제여부 : " + result);
	}

}
