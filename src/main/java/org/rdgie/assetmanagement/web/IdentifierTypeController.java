package org.rdgie.assetmanagement.web;

import org.rdgie.assetmanagement.domain.IdentifierType;
import org.rdgie.assetmanagement.service.IdentifierTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IdentifierTypeController {
	@Autowired
	private IdentifierTypeService identifierTypeService;
	
	@RequestMapping(value = "/createIdentifierType", method = RequestMethod.GET)
	public String goToCreateIdentifierType(Model model) {
		model.addAttribute("identifierType", new IdentifierType());
		return "identifierType/createIdentifierType";
	}

	@RequestMapping(value = "/createIdentifierType", method = RequestMethod.POST)
	public String handleCreateIdentifierType(@ModelAttribute("identifierType") IdentifierType identifierType,Model model) {

		this.identifierTypeService.addIdentifierType(identifierType);
		
		model.addAttribute("identifierTypeList", this.identifierTypeService.listIdentifierTypes());
		return "redirect:/listIdentifierTypes";

	}
	
	@RequestMapping(value = "/listIdentifierTypes", method = RequestMethod.GET)
	public String listIdentifiers(Model model) {
		
		model.addAttribute("identifierTypeList", this.identifierTypeService.listIdentifierTypes());
		return "identifierType/listIdentifierTypes";
	}

}
