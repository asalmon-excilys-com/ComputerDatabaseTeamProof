package orm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ormAPI.InterfaceComputerDAO;

import pojo.Computer;

@Repository
public class ImplementationComputerDAO implements InterfaceComputerDAO {
	private static final String DELETE_COMPUTER = "DELETE FROM `computerDatabase`.`computer` WHERE id = ?;";
	private static final String INSERT_COMPUTER = "INSERT INTO `computerDatabase`.`computer` (`name`, `introduced`, `discontinued`, `company_id`) VALUES (?, ?, ?, ?);";
	private static final String UPDATE_COMPUTER = "UPDATE `computerDatabase`.`computer` SET `name`=?, `introduced`=?, `discontinued`=?, `company_id`=? WHERE `id`=?;";
	private static final String UPDATE_COMPUTER_WITHOUT_CID = "UPDATE `computerDatabase`.`computer` SET `name`=?, `introduced`=?, `discontinued`=? ,`company_id`=NULL WHERE `id`=?;";
	private static final String INSERT_COMPUTER_WITHOUT_CID = "INSERT INTO `computerDatabase`.`computer` (`name`, `introduced`, `discontinued`) VALUES (?, ?, ?);";
	private static final String COUNT_COMPUTERS = "SELECT count(c.id) FROM computer c where c.name like ?;";
	private static final String SELECT_ALL_COMPUTERS = "SELECT c.id, c.introduced, c.discontinued, c.name, cie.id cid, cie.name cname FROM computer c left outer join company cie on c.company_id = cie.id where c.name like ? order by ";
	private static final String LIMIT_SELECT = " limit ? , 10;";
	private static final String SELECT_ONE_COMPUTER_BY_ID = "SELECT c.id, c.introduced, c.discontinued, c.name, cie.id cid, cie.name cname FROM computer c left outer join company cie on c.company_id = cie.id where c.id = ?;";

	@Autowired
	private DataSource ds;

	private JdbcTemplate jdbc;

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public List<Computer> getListComputersSlice(Integer starter, Integer s,
			String clause) throws Exception {

		jdbc = new JdbcTemplate(ds);
		ArrayList<Object> insert = new ArrayList<Object>();
		insert.add(clause);
		insert.add(starter);

		StringBuilder sb = new StringBuilder(SELECT_ALL_COMPUTERS).append(
				UtilitaireDAO.gestionTri(s)).append(LIMIT_SELECT);

		List<Map<String, Object>> rows = jdbc.queryForList(sb.toString(),
				insert.toArray());
		return UtilitaireDAO.ResultSetToComputers(rows);
	}

	public Computer getComputerByID(Integer ID) throws Exception {

		jdbc = new JdbcTemplate(ds);
		ArrayList<Object> insert = new ArrayList<Object>();
		insert.add(ID);

		Map<String, Object> row = jdbc.queryForMap(SELECT_ONE_COMPUTER_BY_ID,
				insert.toArray());

		return UtilitaireDAO.ResultSetToComputer(row);
	}

	public Integer getSizeComputers(String clause) throws Exception {
		jdbc = new JdbcTemplate(ds);
		ArrayList<Object> insert = new ArrayList<Object>();
		insert.add(clause);

		// TODO deprecated
		@SuppressWarnings("deprecation")
		int result = jdbc.queryForInt(COUNT_COMPUTERS, insert.toArray());
		return result;
	}

	public void saveComputer(Computer cp, boolean newCp) throws Exception {

		jdbc = new JdbcTemplate(ds);

		ArrayList<Object> insert = new ArrayList<Object>();
		insert.add(cp.getName());
		insert.add(UtilitaireDAO.gestionNull(cp.getIntroduced()));
		insert.add(UtilitaireDAO.gestionNull(cp.getDiscontinued()));

		if (cp.getCompany().getId() == null) {
			if (newCp == true) {
				jdbc.update(INSERT_COMPUTER_WITHOUT_CID, insert.toArray());

			} else {
				insert.add(cp.getId());
				jdbc.update(UPDATE_COMPUTER_WITHOUT_CID, insert.toArray());
			}

		} else {
			insert.add(cp.getCompany().getId());
			if (newCp == true) {
				jdbc.update(INSERT_COMPUTER, insert.toArray());
			} else {
				insert.add(cp.getId());
				jdbc.update(UPDATE_COMPUTER, insert.toArray());
			}
		}
	}

	public void deleteComputerByID(Integer id) throws Exception {
		jdbc = new JdbcTemplate(ds);
		ArrayList<Object> insert = new ArrayList<Object>();
		insert.add(id);
		jdbc.update(DELETE_COMPUTER, insert.toArray());
	}

}
