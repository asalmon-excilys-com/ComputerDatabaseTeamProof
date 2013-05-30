package ormAPI;

import java.util.List;

import pojo.Company;

public interface InterfaceCompanyDAO {

	public abstract List<Company> getListCompanies() throws Exception;

}