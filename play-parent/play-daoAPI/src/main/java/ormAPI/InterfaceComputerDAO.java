package ormAPI;

import java.util.List;

import pojo.Computer;

public interface InterfaceComputerDAO {
	// Listes
	public List<Computer> getListComputersSlice(Integer starter,
			Integer s, String clause);

	public Computer getComputerByID(Integer ID);

	// Size
	public Integer getSizeComputers(String clause);

	// Save
	public boolean saveComputer(Computer cp, boolean newCp);

	// Delete
	public boolean deleteComputerByID(Integer id);

}