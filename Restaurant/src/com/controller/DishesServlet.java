package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Dishes;
import com.service.IDishesService;
import com.service.impl.DishesService;
import com.vo.JsonBean;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DishesServlet
 */
public class DishesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IDishesService dishesService = new DishesService();   
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JsonBean bean = new JsonBean();
		
		try {
			List<Dishes> list = dishesService.findAllDishes();
			
			bean.setCode(1);
			bean.setMsg(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
