package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pojo.Page;
import serviceAPI.InterfaceService;

@Controller
public class MainTableController {

	@Autowired
	private InterfaceService implServ;

	public void setImplServ(InterfaceService implServ) {
		this.implServ = implServ;
	}

	@RequestMapping(value = { "/index.html", "/TableauComputer.html" })
	public String affichageTableau(ModelMap model,
			@RequestParam(defaultValue = "0") Integer s,
			@RequestParam(defaultValue = "0") Integer p,
			@RequestParam(defaultValue = "") String f) {

		Page page = new Page();
		page.setS(s);
		page.setP(p);
		page.setF(f);

		model.addAttribute("page", implServ.ConstructionTableauAccueil(page));
		return "TableauComputer";
	}
}
