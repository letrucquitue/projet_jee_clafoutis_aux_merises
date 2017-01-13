package org.tutorial;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MajRepareeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String pageName = "/majReparee.jsp";
		RequestDispatcher rd;
		String id_machine = request.getParameter("machine");
		String type = request.getParameter("type");
		String r = request.getParameter("reparee");

		PanneService panneService = new PanneServiceImpl();

		panneService.setReparee(id_machine, type, true);
		
		request.setAttribute("m_id", id_machine);
		request.setAttribute("type", type);

		rd = getServletContext().getRequestDispatcher(pageName);

		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
