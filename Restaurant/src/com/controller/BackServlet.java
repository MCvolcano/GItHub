package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ITablesService;
import com.service.impl.TablesService;

/**
 * Servlet implementation class BackServlet
 */
public class BackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITablesService tableService = new TablesService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		try {
			tableService.updateState(Integer.parseInt(id));
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
