package com.service;

import java.util.List;

import com.entity.Tables;

public interface ITablesService {
	public List<Tables> findAllTables();

	public void addTable(String string);

	public String updateState(int i);

	public void deleteTableById(int id);

	public List<Tables> findByName(String keyword);
}
