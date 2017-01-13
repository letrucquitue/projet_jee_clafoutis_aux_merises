package org.tutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PanneDAOImpl implements PanneDAO {

	// Méthode Arthur
	// On retourne le nombre de pannes apparues entre le moment présent et
	// depuis le nombre de minutes en paramètre
	public int findNumberOfPanne(int minute) throws SQLException {
		int nombrePanne = 0;
		Statement statement = null;
		ResultSet rs_nbPanne; // Resultat de la requete SQL

		Connection connexion = DBManager.getInstance().getConnection(); // Ouverture
																		// de la
																		// connexion
		try {
			statement = connexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Requete minute
		rs_nbPanne = statement.executeQuery(
				"select count(*) from panne where date_apparition>(CURRENT_TIMESTAMP-INTERVAL " + minute + " MINUTE);");

		while (rs_nbPanne.next()) {
			nombrePanne = rs_nbPanne.getInt(1);
		}

		DBManager.getInstance().cleanup(connexion, statement, rs_nbPanne);

		return nombrePanne;
	}

	// Méthode de Léo
	// Retourne toutes les pannes
	public List<Panne> findByAll() throws SQLException {
		List<Panne> l = new ArrayList<Panne>();
		Statement statement1 = null;
		Statement statement2 = null;
		ResultSet rs_p;// rs panne
		ResultSet rs_m = null;// rs machine

		Connection connexion = DBManager.getInstance().getConnection();

		try {
			statement1 = connexion.createStatement();
			statement2 = connexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rs_p = statement1.executeQuery(
				"select type,date_apparition,id_machine,reparee from panne order by date_apparition DESC");

		while (rs_p.next()) {
			Date date = rs_p.getTimestamp("date_apparition");// date
			String type = rs_p.getString("type");// type
			Boolean r = rs_p.getBoolean("reparee");// is réparée?

			// récupérer machine associée
			String m_id = rs_p.getString("id_machine");// id machine
			System.out.println(m_id);
			rs_m = statement2.executeQuery("select type from machine where id_machine='" + m_id + "'");
			String m_type = null;
			while (rs_m.next()) {
				m_type = rs_m.getString("type");// type machine
			}
			Machine m = new Machine(m_id, m_type);

			l.add(new Panne(date, type, m, r));// ajout
												// nouvelle
												// panne
												// dans
												// la
			// liste
		}

		DBManager.getInstance().cleanup(connexion, statement1, rs_p);
		DBManager.getInstance().cleanup(connexion, statement2, rs_m);

		return l;

	}

	public List<Panne> findByTime(String time) throws SQLException {

		List<Panne> l = new ArrayList<Panne>();
		Statement statement_p = null;
		Statement statement_m = null;
		ResultSet rs_p;// rs panne
		ResultSet rs_m = null;// rs machine
		int minute = 1;

		Connection connexion = DBManager.getInstance().getConnection();

		try {
			statement_p = connexion.createStatement();
			statement_m = connexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (time.equals("minute"))
			minute = 1;
		else if (time.equals("heure"))
			minute = 60;
		else if (time.equals("jour"))
			minute = 1440;
		else if (time.equals("mois"))
			minute = 43800;

		// Requete minute
		rs_p = statement_p.executeQuery(
				"select type,date_apparition,id_machine,reparee from panne where date_apparition>(CURRENT_TIMESTAMP-INTERVAL "
						+ minute + " MINUTE) order by date_apparition DESC;");

		while (rs_p.next()) {
			Date date = rs_p.getTimestamp("date_apparition");// date
			String type = rs_p.getString("type");// type
			Boolean r = rs_p.getBoolean("reparee");// is réparée?

			// récupérer machine associée
			String m_id = rs_p.getString("id_machine");// id machine
			rs_m = statement_m.executeQuery("select type from machine where id_machine='" + m_id + "'");
			String m_type = null;
			while (rs_m.next()) {
				m_type = rs_m.getString("type");// type machine
			}
			Machine m = new Machine(m_id, m_type);

			l.add(new Panne(date, type, m, r));// ajout nouvelle panne dans la liste
		}

		DBManager.getInstance().cleanup(connexion, statement_p, rs_p);
		DBManager.getInstance().cleanup(connexion, statement_m, rs_m);

		return l;
	}

	public void setReparee(String m_id, String type, boolean r) throws SQLException {
		Statement statement = null;

		Connection connexion = DBManager.getInstance().getConnection();

		try {
			statement = connexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		statement.executeUpdate(
				"update panne set reparee=" + r + " where type='" + type + "' and id_machine='" + m_id + "';");
	}
	
	public void addPanne(Date date, String type, String machine) throws SQLException {
		Statement statement = null;

		Connection connexion = DBManager.getInstance().getConnection();

		try {
			statement = connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String d;
		if (date.getMonth() < 10) {
			d = ((1900 + date.getYear()) + "-0" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours()
					+ ":" + date.getMinutes() + ":" + date.getSeconds());
		} else {
			d = ((1900 + date.getYear()) + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours()
					+ ":" + date.getMinutes() + ":" + date.getSeconds());
		}
		System.out.println(d);

		statement.executeUpdate("replace into panne values(\"" + type + "\", \"" + d + "\", \"" + machine + "\", 0);");

	}
}
