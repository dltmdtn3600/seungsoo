package com.simple.jdbc;


import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)//스프링 프레임워크가 톰켓을 거치지 않고 독립적으로 실행환경을 만듦
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/DB-context.xml")//사용할 스프링 설정파일
public class JdbcTest {
	//반드시 junit라이브러리 4.12이상으로 맞춰야함
	//반드시 spring-test라이브러리 추가되어야 함
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	@Test //해당 어노테이션이 뭍은 메서드를 실행
	public void test() {
		
		System.out.println("-------템플릿 객체 : " + jdbcTemplate);
		System.out.println("-------데이터소스 : " + dataSource);
		
		try {
			Connection conn = dataSource.getConnection();
			System.out.println("-------커넥션객체 : " + conn);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}
