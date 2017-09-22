package com.service.impl;

import java.util.List;

import com.dao.ICuisineDao;
import com.dao.impl.CuisineDao;
import com.entity.Cuisine;
import com.service.ICuisineService;

public class CuisineService implements ICuisineService {
	private ICuisineDao cuisineDao = new CuisineDao();
	
	@Override
	public List<Cuisine> findAllCuisine() {
		List<Cuisine> list = null;
		try {
			list = cuisineDao.findAll();
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
	public void addCuisine(String name) {
		if (name.equals("") || name.length() == 0) {
			throw new RuntimeException("餐桌名不能为空");
			
		}
		Cuisine cuisine = new Cuisine();
		cuisine.setC_name(name);
		
		try {
			cuisineDao.add(cuisine);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCuisineName(int i, String name) {
		Cuisine t = new Cuisine();
		t.setC_id(i);
		t.setC_name(name);
		try {
			
			cuisineDao.update(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCuisineById(int id) {
		try {
			cuisineDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cuisine> findByName(String keyword) {
		List<Cuisine> list = null;
		try {
			
			list = cuisineDao.findCuisineByName(keyword);
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
