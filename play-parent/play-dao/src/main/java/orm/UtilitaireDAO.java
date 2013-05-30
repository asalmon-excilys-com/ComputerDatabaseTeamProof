package orm;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pojo.Computer;

public class UtilitaireDAO {
	
	final static Logger logger = LoggerFactory.getLogger(UtilitaireDAO.class);
	
	public static String gestionTri(Integer s) {
		String[] type = { "c.name", "c.name", "c.name", "c.introduced",
				"c.discontinued", "cie.name" };
		String[] sens = { "ASC", "DESC" };

		StringBuilder sb = new StringBuilder();
		if (s < 0) {
			sb.append(type[-s]).append(" ").append(sens[1]);
		} else {
			sb.append(type[s]).append(" ").append(sens[0]);
		}
		return sb.toString();
	}
	
	public static List<Computer> ResultSetToComputers(
			List<Map<String, Object>> rows) {

		List<Computer> computers = new ArrayList<Computer>();

		for (Map<String, Object> row : rows) {
			Computer cp = new Computer();

			cp.setId((Integer) row.get("id"));
			cp.setName((String) row.get("name"));
			cp.setIntroduced((Date) row.get("introduced"));
			cp.setDiscontinued((Date) row.get("discontinued"));
			cp.setCompany((Integer) row.get("cid"), (String) row.get("cname"));
			computers.add(cp);
		}
		return computers;
	}

	public static Computer ResultSetToComputer(Map<String, Object> row) {

		Computer cp = new Computer();

		cp.setId((Integer) row.get("id"));
		cp.setName((String) row.get("name"));
		cp.setIntroduced((Date) row.get("introduced"));
		cp.setDiscontinued((Date) row.get("discontinued"));
		cp.setCompany((Integer) row.get("cid"), (String) row.get("cname"));

		return cp;
	}
	
	public static Date gestionNull(Calendar cal) {
		Date d;
		if (cal != null) {
			d = new Date(cal.getTimeInMillis());
		} else {
			d = null;
		}
		return d;
	}
	

}
