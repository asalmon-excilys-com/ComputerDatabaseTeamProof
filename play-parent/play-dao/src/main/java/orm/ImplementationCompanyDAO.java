package orm;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ormAPI.InterfaceCompanyDAO;

import pojo.Company;

@Repository
public class ImplementationCompanyDAO implements InterfaceCompanyDAO {

	private static final String SELECT_ALL_COMPANIES = "Select cie.id, cie.name from company cie order by cie.id;";

	@Autowired
	private DataSource ds;
	private JdbcTemplate jdbc;

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public List<Company> getListCompanies() throws Exception {
		jdbc = new JdbcTemplate(ds);
		List<Company> companies = jdbc.query(SELECT_ALL_COMPANIES,
				new BeanPropertyRowMapper<Company>(Company.class));
		return companies;
	}
}
