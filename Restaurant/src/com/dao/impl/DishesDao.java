package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dao.IDishesDao;
import com.entity.Cuisine;
import com.entity.Dishes;
import com.util.JDBCUtils;

public class DishesDao implements IDishesDao {

	@Override
	public void add(Dishes t) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "insert into dishes(d_name, d_cuisine_name, d_price, d_vip_price, d_image) values(?,?,?,?,?)";
		
		Object[] params = new Object[]{t.getD_name(), t.getD_cuisine_name(), t.getD_price(), t.getD_vip_price(), t.getD_image()}; 
		try {
			qr.update(sql, params);
			System.out.println("添加菜品成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "delete from dishes where d_id=?";
		
		try {
			qr.update(sql, id);
			System.out.println("删除成功" + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Dishes t) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "update dishes set d_name=?, d_cuisine_name=?, d_price=?, d_vip_price=?,d_image=? where d_id=?";
		
		Object[] params = new Object[]{t.getD_name(), t.getD_cuisine_name(), t.getD_price(), t.getD_vip_price(), t.getD_image(), t.getD_id()}; 
		try {
			qr.update(sql, params);
			System.out.println("修改菜品成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Dishes> findAll() {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "select * from dishes";
		List<Dishes> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Dishes.class));
			
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
	public List<Dishes> findDishesByName(String keyword) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		StringBuilder sql = new StringBuilder("select * from dishes where 1=1");
		List<Dishes> list = null;
		String param = "";
		if(keyword!=null && !keyword.trim().equals("")){
			sql.append(" and d_name like ?");
			param = "%" + keyword + "%";
		}
		
		try {
			list = qr.query(sql.toString(), new BeanListHandler<>(Dishes.class), param);
			
		
			System.out.println("查询成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}


















