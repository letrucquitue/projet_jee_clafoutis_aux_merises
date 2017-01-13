package org.tutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MachineDAOImpl implements MachineDAO {

	@Override
	public List<Machine> findAllMachine() throws SQLException {
		List<Machine> l = new ArrayList<Machine>();
		Statement statement1 = null;
		Statement statement2 = null;
		ResultSet rs_p;// rs panne
		ResultSet rs_m = null;// rs machine

		Connection connexion = DBManager.getInstance().getConnection();

		try {
			statement1 = connexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rs_p = statement1.executeQuery("select type,id_machine from machine");

		while (rs_p.next()) {

			String type = rs_p.getString("type");// type

			// récupérer machine associée
			String m_id = rs_p.getString("id_machine");// id machine
			Machine m = new Machine(m_id, type);

			l.add(m);// ajout nouvelle panne dans la liste
		}

		DBManager.getInstance().cleanup(connexion, statement1, rs_p);

		return l;
	}

}
