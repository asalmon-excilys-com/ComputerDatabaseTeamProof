package pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

public class Computer {

	private Integer id;
	private String name;
	private DateTime introduced;
	private DateTime discontinued;
	private Company company;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateTime getIntroduced() {
		return introduced;
	}
	
	public String dateTimetoString(DateTime dt) {
		
		SimpleDateFormat df = (SimpleDateFormat) DateFormat.getDateInstance();
		df.applyPattern("yyyy-MM-dd");
		df.setLenient(false);
		
		return df.format(dt.toDate());
	}

	public void setIntroduced(DateTime introduced) {
		this.introduced = introduced;
	}

	public DateTime getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(DateTime discontinued) {
		this.discontinued = discontinued;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Integer company_id, String name) {
		this.company = new Company(company_id, name);
	}

	public void setCompany(Integer company_id) {
		this.company = new Company(company_id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Computer() {
	};

	public Computer(Integer id, String name, DateTime introduced,
			DateTime discontinued, Integer company_id, String name_company) {
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = new Company(company_id, name_company);
	}

	public Computer(String name, DateTime introduced, DateTime discontinued,
			Integer cid) {

		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = new Company(cid);
	}

	public Computer(Integer id, String name, DateTime introduced,
			DateTime discontinued, Integer cid) {
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = new Company(cid);
	}
}
