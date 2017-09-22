package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Cuisine;
import com.entity.Dishes;
import com.entity.Tables;
import com.service.ICuisineService;
import com.service.IDishesService;
import com.service.ITablesService;
import com.service.impl.CuisineService;
import com.service.impl.DishesService;
import com.service.impl.TablesService;
import com.vo.JsonBean;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private ITablesService tableService = new TablesService();
    private ICuisineService cuisineService = new CuisineService();
    private IDishesService dishesService = new DishesService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String method = request.getParameter("method");
		
		switch (method) {
		case "searcht"://桌名模糊查询
			serarchTableInfo(request, response);
			break;
		case "searchc"://菜系模糊查询
			serarchCuisineInfo(request, response);
			break;
		case "searchd"://菜品模糊查询
			serarchDishesInfo(request, response);
			break;
		default:
			break;
		}
		
		
		
	}

	private void serarchDishesInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String keyword = request.getParameter("keyword");
		JsonBean bean = new JsonBean();
		List<Dishes> list = null;
		try {
			list = dishesService.findByName(keyword);
			
//			System.out.println(list.toString());
			bean.setCode(1);
			bean.setMsg(list);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
	}

	private void serarchCuisineInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String keyword = request.getParameter("keyword");
		JsonBean bean = new JsonBean();
		List<Cuisine> list = null;
		try {
			list = cuisineService.findByName(keyword);
			
//			System.out.println(list.toString());
			bean.setCode(1);
			bean.setMsg(list);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
	}

	private void serarchTableInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String keyword = request.getParameter("keyword");
		JsonBean bean = new JsonBean();
		List<Tables> list = null;
		try {
			list = tableService.findByName(keyword);
			
//			System.out.println(list.toString());
			bean.setCode(1);
			bean.setMsg(list);
		} catch (NumberFormatException e) {
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















