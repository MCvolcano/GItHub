package com.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.ITableDao;
import com.entity.Cuisine;
import com.entity.Tables;
import com.util.JDBCUtils;

public class TableDao implements ITableDao {

	
	@Override
	public void add(Tables t) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "insert into tables(t_name, t_state, t_time) values (?,?,?)";
		
		try {
			qr.update(sql, new Object[]{t.getT_name(), t.getT_state(), t.getT_time()});
			System.out.println("插入成功" + t.getT_name());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "delete from tables where t_id=?";
		
		try {
			qr.update(sql, id);
			System.out.println("删除成功" + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Tables t) {
		
	}

	@Override
	public List<Tables> findAll() {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "select * from tables";
		List<Tables> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(Tables.class));
			
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
	public Tables findById(int id) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "select * from tables where t_id=?";
		Tables table = null;
		try {
			table = qr.query(sql, new BeanHandler<>(Tables.class), id);
			System.out.println("查询成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}

	@Override
	public Tables findByName(String name) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "select * from tables where t_name=?";
		Tables table = null;
		try {
			table = qr.query(sql, new BeanHandler<>(Tables.class), name);
			System.out.println("查询成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}

	@Override
	public String updateStateById(int id) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		
		String oldState = findStateById(id);
		String oldtime = findTimeById(id);
		
		String sql = "update tables set t_state=? where t_id=?";
		String sqlt = "update tables set t_time=? where t_id=?";
		String state = null;
		try {
			if (oldState.equals("预定")) {
				qr.update(sql, "空闲", id);	
				qr.update(sqlt, "", id);	
				
				state = "空闲";
			} else {
				qr.update(sql, "预定", id);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = format.format(new Date());
				
				
				qr.update(sqlt, time, id);	
				state = "预定";
			}
			System.out.println("更新状态成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	@Override
	public String findStateById(int id) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "select t_state from tables where t_id=?";
		String s = null;
		try {
			s = qr.query(sql, new ScalarHandler<String>(), id);
			System.out.println("查询成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String findTimeById(int id) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "select t_time from tables where t_id=?";
		String s = null;
		try {
			s = qr.query(sql, new ScalarHandler<String>(), id);
			System.out.println("查询成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Tables> findTablesByName(String keyword) {
		QueryRunner qr = JDBCUtils.getQueryRunner();
		StringBuilder sql = new StringBuilder("select * from tables where 1=1");
		List<Tables> list = null;
		String param = "";
		if(keyword!=null && !keyword.trim().equals("")){
			sql.append(" and t_name like ?");
			param = "%" + keyword + "%";
		}
		
		try {
			list = qr.query(sql.toString(), new BeanListHandler<>(Tables.class), param);
			
			System.out.println("查询成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
