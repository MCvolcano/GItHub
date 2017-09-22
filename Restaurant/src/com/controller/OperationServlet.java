package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Dishes;
import com.service.ICuisineService;
import com.service.IDishesService;
import com.service.ITablesService;
import com.service.impl.CuisineService;
import com.service.impl.DishesService;
import com.service.impl.TablesService;
import com.vo.JsonBean;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class OperationServlet
 */
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITablesService tableService = new TablesService();
    private ICuisineService cuisineService = new CuisineService();
    private IDishesService dishesService = new DishesService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationServlet() {
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
		case "add":
			addTableInfo(request, response);
			break;
		case "addc":
			addCuisineInfo(request, response);
			break;
		case "addDish":
			addDishesInfo(request, response);
			break;
		default:
			break;
		}
		
		
		
	}

	private void addDishesInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String dCuisineName = request.getParameter("cuisineName");
		String dName = request.getParameter("dName");
		String dPrice = request.getParameter("dPrice");
		String dVipPrice = request.getParameter("dVipPrice");
		String dImage = request.getParameter("dImage");
		
		System.out.println(dCuisineName + " " + dName + " " + dPrice + " " + dVipPrice + " " + dImage);
		
		Dishes d = new Dishes();
		d.setD_name(dName);
		d.setD_cuisine_name(dCuisineName);
		d.setD_price(Double.parseDouble(dPrice));
		d.setD_vip_price(Double.parseDouble(dVipPrice));
		d.setD_image(dImage);
		
		//添加导数据库
		JsonBean bean = new JsonBean();
		try {
			dishesService.addDishes(d);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
	}

	private void addCuisineInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		
		JsonBean bean = new JsonBean();
		try {
			cuisineService.addCuisine(name);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
	}

	/*private void deleteTableInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		
		int i = Integer.parseInt(id.trim());
		
		JsonBean bean = new JsonBean();
		try {
			tableService.deleteTableById(i);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		System.out.println(JSONObject.fromObject(bean).toString());
		response.getWriter().write(JSONObject.fromObject(bean).toString());
	}

	private void backTableInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		
		int i = Integer.parseInt(id.trim());
		
		JsonBean bean = new JsonBean();
		try {
			String state = tableService.updateState(i);
			bean.setCode(1);
			bean.setMsg(state);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		System.out.println(JSONObject.fromObject(bean).toString());
		response.getWriter().write(JSONObject.fromObject(bean).toString());
	}

	private void bookTableInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		
		int i = Integer.parseInt(id.trim());
		
		JsonBean bean = new JsonBean();
		try {
			String state = tableService.updateState(i);
			bean.setCode(1);
			bean.setMsg(state);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		System.out.println(JSONObject.fromObject(bean).toString());
		response.getWriter().write(JSONObject.fromObject(bean).toString());
	}
*/
	private void addTableInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		
		JsonBean bean = new JsonBean();
		try {
			tableService.addTable(name);
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
