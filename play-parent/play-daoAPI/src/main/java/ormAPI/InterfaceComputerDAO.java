package ormAPI;

import java.util.List;

import pojo.Computer;

public interface InterfaceComputerDAO {
	// Listes
	public List<Computer> getListComputersSlice(Integer starter,
			Integer s, String clause) throws Exception;

	public Computer getComputerByID(Integer ID) throws Exception;

	// Size
	public Integer getSizeComputers(String clause) throws Exception;

	// Save
	public void saveComputer(Computer cp, boolean newCp) throws Exception;

	// Delete
	public void deleteComputerByID(Integer id) throws Exception;

}