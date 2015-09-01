package nl.devlab.devLapp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import nl.devlab.devLapp.entity.Name;
import nl.devlab.devLapp.form.NameForm;
import nl.devlab.devLapp.service.NameService;
import nl.devlab.entity.Country;
import nl.devlab.service.CountryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"nameForm"})

/**
 * @author Marco Kortooms - Atos
 *
 */
public class DevLappController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Logger LOGGER = LoggerFactory.getLogger(DevLappController.class);

	private static final String NAMEFORM = "nameForm";

	@Autowired
	private CountryService countryService;
	@Autowired
	private NameService nameService;
	
	/**
	 * Prepare DevLapp Application for initial use
	 * 
	 * @param externalSessionId
	 * @param user_Id
	 * @param country_Id
	 * @param model
	 * @param session
	 * @param status
	 * @return
	 */
	@RequestMapping("/start")
	public String start(
			@RequestParam(value = "external-session-id", required=false) String externalSessionId,
			@RequestParam(value = "user-id", required=false) String user_Id,
			@RequestParam(value = "country-id", required=false) String country_Id,
			Map<String, Object> model,
			HttpSession session,
			SessionStatus status) {
	
		// Store country in session
		Country country = (Country) session.getAttribute("country");
		if (country == null || !country.getCountryCode().equals(country_Id)) {
			String countryCode = country_Id.trim().toUpperCase();
			if (countryCode.equals("XX") && user_Id.equals("xxxxxxxx") &&
					externalSessionId.equals("xxxxxxxxxxxxxxxxxxxxxxxx")) {
				country = countryService.getCountryByCode("nl");
			} else {
				country = countryService.getCountryByCode(countryCode);
			}
			session.setAttribute("country", country);
		}
		
		// Store userId in session
		String userId = (String) session.getAttribute("userId");
		if (userId == null || !userId.equals(user_Id)) {
			session.setAttribute("userId", user_Id);
		}

		// Check if country and userId are in session else throw error
		country = (Country) session.getAttribute("country");
		userId = (String) session.getAttribute("userId");
		if (country == null || userId == null) {
			return "error";
		}

		status.setComplete(); // clear current session attributes

		return "redirect:/displayNameForm.do";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Show helloWorld form
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/displayNameForm")
	public String displayNameForm(
		Map<String, Object> model,
		HttpSession session) {

		NameForm nameForm = (NameForm)model.get(NAMEFORM);
		if (nameForm == null) {
			nameForm = new NameForm();
		}
		model.put(NAMEFORM, nameForm);
		
		List<Name> nameList = nameService.getNameList();
		model.put("nameList", nameList);
		
		return "nameForm";
	}

	/**
	 * add name
	 * 
	 * @param nameForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/addName", method = RequestMethod.POST)
	public String addNameToNameForm (
			@ModelAttribute(NAMEFORM) NameForm nameForm,
			BindingResult result,
			Map<String, Object> model,
			HttpSession session) {

		// *** Validate form ***
		nameForm.validate(result);
		if (result.hasErrors()) {
			return "nameForm";
		}
		
		// *** Save entry on nameForm to database ***
		Name name = new Name();
		name.setName(nameForm.getName());
		nameService.saveName(name);
		
		// *** Normally redirect to next page, but now redisplay current page ***
		return "redirect:/displayNameForm.do";
	}
	
	/**
	 * delete name
	 * 
	 * @param nameForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/deleteName", method = RequestMethod.POST)
	public String deleteNameFromNameForm (
			@ModelAttribute(NAMEFORM) NameForm nameForm,
			BindingResult result,
			Map<String, Object> model,
			HttpSession session) {

		// *** Save entry on nameForm to database ***
		nameService.deleteName(nameForm.getNameId());
		
		// *** Normally redirect to next page, but now redisplay current page ***
		return "redirect:/displayNameForm.do";
	}

}

