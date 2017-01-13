package org.tutorial;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PanneServiceImpl implements PanneService {

	// private PanneDAO panneDao = new PanneDAOMockImpl();
	private PanneDAO panneDao = new PanneDAOImpl();

	public List<Panne> getAllPannes() throws SQLException {
		return panneDao.findByAll();
	}

	public int[] getNumberOfPanne() throws SQLException {
		int[] tabResultatNombrePanne = new int[4];
		tabResultatNombrePanne[0] = panneDao.findNumberOfPanne(1);
		tabResultatNombrePanne[1] = panneDao.findNumberOfPanne(60);
		tabResultatNombrePanne[2] = panneDao.findNumberOfPanne(1440);
		tabResultatNombrePanne[3] = panneDao.findNumberOfPanne(43800);
		return tabResultatNombrePanne;
	}

	public List<Panne> getPannesByTime(String time) throws SQLException {
		return panneDao.findByTime(time);
	}

	public void setReparee(String m_id, String type, boolean r) throws SQLException {
		panneDao.setReparee(m_id, type, r);
	}
	
	public void addPanne(Date date, String type, String machine) throws SQLException {
		panneDao.addPanne(date, type, machine);
	}

}
