package com.service;

import java.util.List;

import com.entity.Dishes;

public interface IDishesService {
	public List<Dishes> findAllDishes();

	public void addDishes(Dishes d);

	public void updateDishesName(int i, String name);

	public void deleteDishesById(int id);
	
	public List<Dishes> findByName(String keyword);

	public void updateDishes(Dishes d);
}
