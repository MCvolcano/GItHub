package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ICuisineService;
import com.service.IDishesService;
import com.service.ITablesService;
import com.service.impl.CuisineService;
import com.service.impl.DishesService;
import com.service.impl.TablesService;
import com.vo.JsonBean;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITablesService tableService = new TablesService();
    private ICuisineService cuisineService = new CuisineService();
    private IDishesService dishesService = new DishesService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		
		switch (method) {
		case "deltables":
			delTables(request, response);
			break;
		case "delcuisine":
			delCuisine(request, response);
			break;
		case "deldishes":
			delDishes(request, response);
			break;

		default:
			break;
		}
		
	}

	private void delDishes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		JsonBean bean = new JsonBean();
		try {
			dishesService.deleteDishesById(Integer.parseInt(id));
			bean.setCode(1);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
		
		
	}

	private void delCuisine(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		JsonBean bean = new JsonBean();
		try {
			cuisineService.deleteCuisineById(Integer.parseInt(id));
			bean.setCode(1);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
		
		
		
	}

	private void delTables(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		
		try {
			tableService.deleteTableById(Integer.parseInt(id));
			System.out.println(request.getContextPath() + "/detail/borderList.html");
			response.sendRedirect(request.getContextPath() + "/detail/boardList.html");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
