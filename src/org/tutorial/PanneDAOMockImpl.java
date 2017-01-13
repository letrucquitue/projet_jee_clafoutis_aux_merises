package org.tutorial;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PanneDAOMockImpl implements PanneDAO {

	public List<Panne> findByAll() {
		List<Panne> l = new ArrayList<Panne>();
		Date d = new Date(2017, 1, 5, 20, 45);
		Machine m1 = new Machine("1", "PareFeux");
		Panne p1 = new Panne(d, "Réseau", m1, false);
		l.add(p1);
		Machine m2 = new Machine("2", "Serveur");
		Panne p2 = new Panne(d, "Crash Disque", m2, true);
		l.add(p2);
		Machine m3 = new Machine("3", "Routeur");
		Panne p3 = new Panne(d, "Réseau", m3, false);
		l.add(p3);
		Machine m4 = new Machine("4", "Serveur");
		Panne p4 = new Panne(d, "Problème Mémoire", m4, false);
		l.add(p4);
		return l;
	}

	public int findNumberOfPanne(int minute) {
		return 123;
	}

	public List<Panne> findByTitle(String searchText) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Panne> findByTime(String time) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReparee(String m_id, String type, boolean r) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPanne(Date date, String type, String machine) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
