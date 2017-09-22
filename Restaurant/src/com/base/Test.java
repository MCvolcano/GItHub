package com.base;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.entity.Tables;
import com.util.JDBCUtils;

public class Test {
	public static void main(String[] args) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "select * from tables";
		List<Tables> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Tables.class));
			for (Tables tables : list) {
				System.out.println(tables.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
