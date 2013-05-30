package serviceAPI;

import java.util.Calendar;

import pojo.Page;

public interface InterfaceService {

	Page ConstructionTableauAccueil(Page page) throws Exception;

	Page ModifyOrAddComputer(Integer id) throws Exception;

	void DeleteComputer(Integer id) throws Exception;

	void SaveComputer(Integer id, String name, Calendar introduced,
			Calendar discontinued, String company_id) throws Exception;
}
