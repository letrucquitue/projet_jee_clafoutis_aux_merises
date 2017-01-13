package org.tutorial;

import java.sql.SQLException;
import java.util.List;

public interface MachineDAO {
	List<Machine> findAllMachine() throws SQLException;
}
