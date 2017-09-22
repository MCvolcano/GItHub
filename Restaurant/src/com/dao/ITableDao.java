package com.dao;

import java.util.List;

import com.base.IBaseDao;
import com.entity.Cuisine;
import com.entity.Tables;

public interface ITableDao extends IBaseDao<Tables>{

	/**
	 * 按餐桌id查找
	 * @param id
	 * @return
	 */
	public Tables findById(int id);
	
	/**
	 * 按餐桌名查找
	 * @param name
	 * @return
	 */
	public Tables findByName(String name);
	
	/**
	 * 更新餐桌状态
	 * @param id
	 */
	public String updateStateById(int id);
	
	/**
	 * 查询餐桌状态
	 * @param id
	 * @return
	 */
	public String findStateById(int id);
	
	List<Tables> findTablesByName(String keyword);
}
