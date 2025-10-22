package com.test.java.model;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//JUnit+Spring
//JUnit4: 생성자 의존 주입을 지원하지 않음. 필드 주입으로..
//JUnit4: 생성자 의존 주입 가능

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommonsDBCPTests {
	
	@Autowired
	private DataSource dataSource;
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	// @Ignore : 해당 annotation이 붙은 메서드를 테스트에서 제외
	// 메서드 이름이나 헤더 부분에서 우클릭 -> run as junit하면 해당 메서드만 실행 가능
	@Test @Ignore
	public void testGetDataSource() {
//		System.out.println(dataSource != null);
		assertNotNull(dataSource);
	}
	@Test
	public void testCreateConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(conn);
	}
	@Test
	public void testIsConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			System.out.println(conn.isClosed());
			assertFalse(conn.isClosed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
