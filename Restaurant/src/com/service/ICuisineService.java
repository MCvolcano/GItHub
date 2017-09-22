package com.service;

import java.util.List;

import com.entity.Cuisine;

public interface ICuisineService {

	public List<Cuisine> findAllCuisine();

	public void addCuisine(String string);

	public void updateCuisineName(int i, String name);

	public void deleteCuisineById(int id);

	public List<Cuisine> findByName(String keyword);
}
