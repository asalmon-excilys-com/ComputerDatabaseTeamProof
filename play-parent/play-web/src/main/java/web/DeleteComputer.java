package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import serviceAPI.InterfaceService;

@Controller
public class DeleteComputer {


	@Autowired
	private InterfaceService implServ;
	
	public void setImplServ(InterfaceService implServ) {
		this.implServ = implServ;
	}

	@RequestMapping(value = { "/delete.html" }, method = RequestMethod.POST)
	public String supprimerComputer(ModelMap model,
			@RequestParam(defaultValue = "0") Integer id) {
		try {
			implServ.DeleteComputer(id);
			return "redirect:/TableauComputer.html";
		} catch (Exception e) {
			model.addAttribute("error", "Erreur technique " + e.getMessage());
			e.printStackTrace();
			return "errorPage";
		}
	}
}
