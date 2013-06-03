package service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ormAPI.InterfaceCompanyDAO;
import ormAPI.InterfaceComputerDAO;
import pojo.Computer;
import pojo.Page;
import serviceAPI.InterfaceService;

@Service
@Scope("singleton")
@Transactional(readOnly = true)
public class ImplementationService implements InterfaceService {

	@Autowired
	InterfaceCompanyDAO companyDAO;
	@Autowired
	InterfaceComputerDAO computerDAO;

	public InterfaceCompanyDAO getDAOcompany() {
		return companyDAO;
	}

	public void setDAOcompany(InterfaceCompanyDAO dAOcompany) {
		companyDAO = dAOcompany;
	}

	public InterfaceComputerDAO getImplDAO() {
		return computerDAO;
	}

	public void setImplDAO(InterfaceComputerDAO implDAO) {
		this.computerDAO = implDAO;
	}
	

	public Page ConstructionTableauAccueil(Page page){
		
		Integer sizeTable = computerDAO.getSizeComputers("%" + page.getF()
				+ "%");

		assert(sizeTable >=0): "La requete SQL a rencontré un problème.";
		page.setTailleTable(sizeTable);

		if(sizeTable>0){
		page.setComputers(computerDAO.getListComputersSlice(page.getP() * 10,
				page.getS(), "%" + page.getF() + "%"));
		}
		return page;
	}

	@Transactional(readOnly = false)
	public void DeleteComputer(Integer id){
		boolean b = computerDAO.deleteComputerByID(id);
		assert(b==true);
	}

	public Page ModifyOrAddComputer(Integer id){

		Page page = new Page();

		page.setCompanies(companyDAO.getListCompanies());

		assert(id>=0): "id = " + id + "is illegal.";
		if (id == 0) {
			page.setUrl("NewComputer");
		} else {
			page.setCp(computerDAO.getComputerByID(id));
			page.setUrl("Computer");
		}
		return page;
	}

	@Transactional(readOnly = false)
	public void SaveComputer(Integer id, String name, Calendar introduced,
			Calendar discontinued, String company_id){

		Computer cp;

		boolean newCp;

		Integer cid;
		if (company_id.equalsIgnoreCase("")) {
			cid = null;
		} else {
			cid = Integer.parseInt(company_id);
		}

		if (id == 0) {
			cp = new Computer(name, introduced, discontinued, cid);
			newCp = true;
		} else {
			cp = new Computer(id, name, introduced, discontinued, cid);
			newCp = false;

		}
		Boolean b =computerDAO.saveComputer(cp, newCp);
		assert(b==true);
	}
	

}
