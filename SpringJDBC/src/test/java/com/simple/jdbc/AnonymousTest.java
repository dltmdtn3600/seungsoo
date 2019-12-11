package com.simple.jdbc;

import org.junit.Test;

interface Car {
	public void run(); //추상 method
}

public class AnonymousTest {
	
	//보통의 경우는 구현하는 클래스를 생성해서 사용하지만,
	//재사용할 일이 없다면 익명클래스(이름없는 클래스)로 선언해서
	//1회성으로 사용할 수 있씀.
	
	@Test  //test어노테이션 붙어있는 메서드실행
	public void test() {
		Car car = new Car() {

			@Override
			public void run() {
				System.out.println("ㅎㅇ");
			}
			
		};
		
		car.run(); //overriding된 메서드 실행
		
		
	}
	
}
