package pojo;

import java.util.List;

public class Page {
	private Integer s;
	private Integer p;
	private String f;
	private Integer tailleTable;
	private List<Computer> computers;
	private List<Company> companies;
	private Computer cp;
	private String url;
	
	public Integer getS() {
		return s;
	}
	public void setS(Integer s) {
		this.s = s;
	}
	public Integer getP() {
		return p;
	}
	public void setP(Integer p) {
		this.p = p;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public Integer getTailleTable() {
		return tailleTable;
	}
	public void setTailleTable(Integer tailleTable) {
		this.tailleTable = tailleTable;
	}
	public List<Computer> getComputers() {
		return computers;
	}
	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}
	public Computer getCp() {
		return cp;
	}
	public void setCp(Computer cp) {
		this.cp = cp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	public Page() {
	}

}
