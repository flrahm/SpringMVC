package net.websnet.dbTest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testConn() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userid = "jsldb";
			String password = "123123";
			Connection conn = DriverManager.getConnection(url,userid,password);
			log.info(conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
