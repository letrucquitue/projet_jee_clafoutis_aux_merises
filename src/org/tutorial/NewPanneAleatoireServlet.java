package org.tutorial;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewPanneAleatoireServlet extends HttpServlet {

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
		String pageName = "/newPanne.jsp";
		RequestDispatcher rd;

		PanneService panneService = new PanneServiceImpl();
		MachineDAO machineDAO = new MachineDAOImpl();
		
		List<Machine> listeMachines = machineDAO.findAllMachine();
		
		int nb = (int) (Math.random() * listeMachines.size());//machine aléatoire
		String type_p = "";//type de panne
		String m_id = listeMachines.get(nb).getNom();//nom de la machine choisie
		String type_m = listeMachines.get(nb).getType();//type de cette machine
		System.out.println("type_m: "+type_m);
		System.out.println("m_id: "+m_id);
		
		if(type_m.equals("Serveur")){//si c'est un serveur
			nb = (int) (Math.random() * 3);
			switch (nb) {
			case 0:
				type_p = "Reseau";
				break;
			case 1:
				type_p = "Crash Disque";
				break;
			case 2:
				type_p = "Probleme Memoire";
				break;
			}
		}
		else//sinon, forcément une panne Reseau
			type_p = "Reseau";

		Date d = new Date();

		panneService.addPanne(d, type_p, m_id);//ajout de la panne dans la BD

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
