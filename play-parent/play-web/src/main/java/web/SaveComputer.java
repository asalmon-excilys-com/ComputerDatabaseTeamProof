package web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import serviceAPI.InterfaceService;


@Controller
public class SaveComputer {

	@Autowired
	private InterfaceService implServ;
	
	@Autowired
	private EditComputer edit;
	
	public void setImplServ(InterfaceService implServ) {
		this.implServ = implServ;
	}
	
	public void setEdit(EditComputer edit) {
		this.edit = edit;
	}

	@RequestMapping(value = { "/saveComputer.html" }, method = RequestMethod.POST)
	public String sauverComputer(
			ModelMap model,
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "0") Integer id,
			@RequestParam(value = "introduced", defaultValue = "") String introducedS,
			@RequestParam(value = "discontinued", defaultValue = "") String discontinuedS,
			@RequestParam(value = "company", defaultValue = "") String company_id) {
		// Verif name
		if (name.isEmpty()) {
			model.addAttribute("nameError", "error");
		
			return edit.modifierAjouterComputer(model, id);
		}

		// Verif dates
		SimpleDateFormat df = (SimpleDateFormat) DateFormat.getDateInstance();
		df.applyPattern("yyyy-MM-dd");
		df.setLenient(false);
		Calendar introduced = Calendar.getInstance();
		Calendar discontinued = Calendar.getInstance();

		if (introducedS.isEmpty()) {
			introduced = null;
		} else {
			try {
				introduced.setTime(df.parse(introducedS));
			} catch (ParseException e) {
				model.addAttribute("introducedError", "error");
				return edit.modifierAjouterComputer(model, id);
			}
		}

		if (discontinuedS.isEmpty()) {
			discontinued = null;
		} else {
			try {
				discontinued.setTime(df.parse(discontinuedS));
			} catch (ParseException e) {
				model.addAttribute("discontinuedError", "error");
				return edit.modifierAjouterComputer(model, id);
			}
		}

		try {
			implServ.SaveComputer(id, name, introduced, discontinued,
					company_id);
			return "redirect:/TableauComputer.html";

		} catch (Exception e) {
			model.addAttribute("error", "Erreur technique " + e.getMessage());
			e.printStackTrace();
			return "errorPage";
		}
	}

	
}
