package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Page;
import serviceAPI.InterfaceService;

@Controller
public class EditComputer {

	@Autowired
	private InterfaceService implServ;
	
	public void setImplServ(InterfaceService implServ) {
		this.implServ = implServ;
	}

	@RequestMapping(value = { "/ModifyOrAdd.html" }, method = RequestMethod.GET)
	public String modifierAjouterComputer(ModelMap model,
			@RequestParam(defaultValue = "0") Integer id) {
		
			Page page = implServ.ModifyOrAddComputer(id);
			model.addAttribute("page", page);
			return page.getUrl();
	}
}
