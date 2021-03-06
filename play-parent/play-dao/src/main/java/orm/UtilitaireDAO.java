package orm;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import pojo.Computer;

public class UtilitaireDAO {
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
			cp.setIntroduced(gestionDateToJodaTime((Date) row.get("introduced")));
			cp.setDiscontinued(gestionDateToJodaTime((Date) row.get("introduced")));
			cp.setCompany((Integer) row.get("cid"), (String) row.get("cname"));
			computers.add(cp);
		}
		return computers;
	}

	public static Computer ResultSetToComputer(Map<String, Object> row) {

		Computer cp = new Computer();

		cp.setId((Integer) row.get("id"));
		cp.setName((String) row.get("name"));
		cp.setIntroduced(gestionDateToJodaTime((Date) row.get("introduced")));
		cp.setDiscontinued(gestionDateToJodaTime((Date) row.get("discontinued")));
		cp.setCompany((Integer) row.get("cid"), (String) row.get("cname"));

		return cp;
	}
	
	private static DateTime gestionDateToJodaTime(Date date){
		DateTime dt = null;
		if(date != null) {
			dt = LocalDate.fromDateFields(date).toDateTimeAtStartOfDay();
		}
			return dt;
	}

}
