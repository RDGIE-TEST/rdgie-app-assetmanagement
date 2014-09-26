package org.rdgie.assetmanagement.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rdgie.assetmanagement.domain.User;
import org.rdgie.assetmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userSerice;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "login";
	}

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public String doLoging(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User(username, password);
		
		User foundUser = userSerice.checkUser(user);

		if (foundUser != null) {
			model.put("user",foundUser);
			return "home";
		} else {
			model.put("userError",user);
			return "login";
		}
	}
	
	
}
