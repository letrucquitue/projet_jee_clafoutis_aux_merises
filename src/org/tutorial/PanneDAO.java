package org.tutorial;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface PanneDAO {
	List<Panne> findByAll() throws SQLException;

	int findNumberOfPanne(int minute) throws SQLException;

	List<Panne> findByTime(String time) throws SQLException;

	public void setReparee(String m_id, String type, boolean r) throws SQLException;
	
	void addPanne(Date date, String type, String machine) throws SQLException;
}
