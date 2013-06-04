package serviceAPI;

import org.joda.time.DateTime;

import pojo.Page;

public interface InterfaceService {

	Page ConstructionTableauAccueil(Page page);

	Page ModifyOrAddComputer(Integer id);

	void DeleteComputer(Integer id);

	void SaveComputer(Integer id, String name, DateTime introduced,
			DateTime discontinued, String company_id);
}
