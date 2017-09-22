package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dao.ICuisineDao;
import com.entity.Cuisine;
import com.util.JDBCUtils;

public class CuisineDao implements ICuisineDao {

	@Override
	public void add(Cuisine c) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "insert into cuisine(c_name) values(?)";
		
		try {
			qr.update(sql, c.getC_name());
			System.out.println("插入成功" + c.getC_name());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "delete from cuisine where c_id=?";
		
		try {
			qr.update(sql, id);
			System.out.println("删除成功" + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Cuisine c) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "update cuisine set c_name=? where c_id=?";
		System.out.println(c.getC_id() + " " + c.getC_name());
		try {
			qr.update(sql, c.getC_name(), c.getC_id());
			System.out.println("cname修改成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cuisine> findAll() {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "select * from cuisine";
		List<Cuisine> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Cuisine.class));
			
			/*for (Tables tables : list) {
				System.out.println(tables.toString());
			}*/
		
			System.out.println("查询成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String findTimeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cuisine> findCuisineByName(String keyword) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		StringBuilder sql = new StringBuilder("select * from cuisine where 1=1");
		List<Cuisine> list = null;
		String param = "";
		if(keyword!=null && !keyword.trim().equals("")){
			sql.append(" and c_name like ?");
			param = "%" + keyword + "%";
		}
		
		try {
			list = qr.query(sql.toString(), new BeanListHandler<>(Cuisine.class), param);
			
			for (Cuisine c : list) {
				System.out.println(c.toString());
			}
		
			System.out.println("查询成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
