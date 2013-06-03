package serviceAPI;

import java.util.Calendar;

import pojo.Page;

public interface InterfaceService {

	Page ConstructionTableauAccueil(Page page);

	Page ModifyOrAddComputer(Integer id);

	void DeleteComputer(Integer id);

	void SaveComputer(Integer id, String name, Calendar introduced,
			Calendar discontinued, String company_id);
}
