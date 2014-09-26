package org.rdgie.assetmanagement.web;

import java.util.Map;

import org.rdgie.assetmanagement.domain.User;
import org.rdgie.assetmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String goToCreateUser(Map<String, Object> model) {
		model.put("user", new User());
		return "user/createUser";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String postuser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "login";

	}

}
