package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Tables;
import com.service.ITablesService;
import com.service.impl.TablesService;
import com.vo.JsonBean;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class TablesServlet
 */
public class TablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITablesService tableService = new TablesService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TablesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JsonBean bean = new JsonBean();
		
		try {
			List<Tables> list = tableService.findAllTables();
			/*for (Tables tables : list) {
				System.out.println("3" + tables.toString());
			}*/
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
