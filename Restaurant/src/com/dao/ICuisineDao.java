package com.dao;

import java.util.List;

import com.base.IBaseDao;
import com.entity.Cuisine;

public interface ICuisineDao extends IBaseDao<Cuisine>{

	List<Cuisine> findCuisineByName(String keyword);
	
}
