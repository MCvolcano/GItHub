package com.dao;

import java.util.List;

import com.base.IBaseDao;
import com.entity.Dishes;

public interface IDishesDao extends IBaseDao<Dishes>{
	List<Dishes> findDishesByName(String keyword);
}
