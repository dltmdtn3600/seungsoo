package com.simple.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.jdbc.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/DB-context.xml")
public class MyBatisTest {

	//DB-context.xml 파일에서 mybatis-scan 명령으로 해당패키지를 읽어 빈으로 생성
	
	@Autowired
	private TestMapper testMapper;
	
	@Test
	public void test() {
		
		String result = testMapper.getTime();
		System.out.println(result);
		
	}
	
	
	
}
