package com.jsl.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class dbtest {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {

		}

	}

	@Test
	public void testConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jsldb";
		String password = "123123";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			log.info(conn);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}
