package com.base;

import java.util.List;

public interface IBaseDao<T> {
	
	/**
	 * 增
	 * @param t
	 */
	public void add(T t);
	
	/**
	 * 删
	 * @param t
	 */
	public void delete(int id);
	
	/**
	 * 改
	 * @param t
	 */
	public void update(T t);
	
	/**
	 * 查
	 * @param t
	 * @return
	 */
	public List<T> findAll();

	String findTimeById(int id);
}
