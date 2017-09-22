package com.service.impl;

import java.util.List;

import com.dao.IDishesDao;
import com.dao.impl.DishesDao;
import com.entity.Cuisine;
import com.entity.Dishes;
import com.service.IDishesService;

public class DishesService implements IDishesService {
private IDishesDao dishesDao = new DishesDao();
	
	@Override
	public List<Dishes> findAllDishes() {
		List<Dishes> list = null;
		try {
			list = dishesDao.findAll();
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
	public void addDishes(Dishes d) {
		// TODO Auto-generated method stub
		try {
			dishesDao.add(d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateDishesName(int i, String name) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteDishesById(int id) {
		try {
			dishesDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Dishes> findByName(String keyword) {
		List<Dishes> list = null;
		try {
			
			list = dishesDao.findDishesByName(keyword);
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
	public void updateDishes(Dishes d) {
		try {
			
			dishesDao.update(d);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
}
