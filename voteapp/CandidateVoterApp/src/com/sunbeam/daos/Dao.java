package com.sunbeam.daos;

import com.sunbeam.utils.DbUtil;
import java.sql.Connection;
import java.sql.DriverManager;



public class Dao implements AutoCloseable {
	protected Connection con;
	public Dao() throws Exception {
		con = DbUtil.getConnection();
	}
	@Override
	public void close() {
		try {
			if(con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}