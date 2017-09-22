package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Dishes;
import com.service.ICuisineService;
import com.service.IDishesService;
import com.service.impl.CuisineService;
import com.service.impl.DishesService;
import com.vo.JsonBean;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICuisineService cuisineService = new CuisineService(); 
	private IDishesService dishesService = new DishesService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		
		System.out.println(method);
		
		switch (method) {
		case "updatec":
			updateCuisineInfo(request, response);
			break;
		case "updateDishes":
			updateDishesInfo(request, response);
			break;
		default:
			break;
		}
	}

	private void updateDishesInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("id");
		String cName = request.getParameter("cid");
		String footName = request.getParameter("foodName");
		String price = request.getParameter("price");
		String vPrice = request.getParameter("mprice");
		String image = request.getParameter("image");

		Dishes d = new Dishes();
		d.setD_id(Integer.parseInt(id));
		d.setD_name(footName);
		d.setD_cuisine_name(cName);
		d.setD_price(Double.parseDouble(price));
		d.setD_vip_price(Double.parseDouble(vPrice));
		d.setD_image(image);
		
		JsonBean bean = new JsonBean();
		try {
			dishesService.updateDishes(d);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
	}

	private void updateCuisineInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		System.out.println(id + " " + name);
		JsonBean bean = new JsonBean();
		try {
			cuisineService.updateCuisineName(Integer.parseInt(id), name);
			bean.setCode(1);
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










