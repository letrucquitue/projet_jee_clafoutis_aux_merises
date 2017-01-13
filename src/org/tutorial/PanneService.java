package org.tutorial;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface PanneService {
	List<Panne> getAllPannes() throws SQLException;

	int[] getNumberOfPanne() throws SQLException;

	public List<Panne> getPannesByTime(String time) throws SQLException;

	public void setReparee(String m_id, String type, boolean r) throws SQLException;
	
	public void addPanne(Date date, String type, String machine) throws SQLException;
}
