package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Cuisine;
import com.entity.Tables;
import com.service.ICuisineService;
import com.service.impl.CuisineService;
import com.vo.JsonBean;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CuisineServlet
 */
public class CuisineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICuisineService cuisineService = new CuisineService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuisineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JsonBean bean = new JsonBean();
		
		try {
			List<Cuisine> list = cuisineService.findAllCuisine();
			
			System.out.println(list.toString());
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
