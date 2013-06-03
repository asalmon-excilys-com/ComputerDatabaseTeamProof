package pojo;

/**
 * @author excilys
 *
 */

public class Company {

	
	private Integer id;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Company(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Company(Integer id) {
		this.id = id;
	}
	public Company() {};
}
