package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dao.ITableDao;
import com.dao.impl.TableDao;
import com.entity.Cuisine;
import com.entity.Tables;
import com.service.ITablesService;

public class TablesService implements ITablesService {
	private ITableDao tableDao = new TableDao();
	/**
	 * 查询所有的餐桌信息
	 */
	@Override
	public List<Tables> findAllTables() {
		List<Tables> list = null;
		try {
			list = tableDao.findAll();
			/*
			for (Tables tables : list) {
				System.out.println("2" + tables.toString());
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void addTable(String name) {
		
		if (name.equals("") || name.length() == 0) {
			throw new RuntimeException("餐桌名不能为空");
			
		}
		Tables table = new Tables();
		table.setT_name(name);
		table.setT_state("空闲");
		/*
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		table.setT_time(time);*/
		
		
		try {
			tableDao.add(table);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String updateState(int i) {

		String state = null;
		try {
			state = tableDao.updateStateById(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	@Override
	public void deleteTableById(int id) {
		try {
			tableDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Tables> findByName(String keyword) {
		List<Tables> list = null;
		try {
			
			list = tableDao.findTablesByName(keyword);
			/*
			for (Tables tables : list) {
				System.out.println("2" + tables.toString());
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}














