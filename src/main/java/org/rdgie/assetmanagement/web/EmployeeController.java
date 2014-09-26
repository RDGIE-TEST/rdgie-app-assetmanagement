package org.rdgie.assetmanagement.web;


import java.util.Set;

import org.rdgie.assetmanagement.domain.Employee;
import org.rdgie.assetmanagement.domain.Identifier;
import org.rdgie.assetmanagement.domain.IdentifierType;
import org.rdgie.assetmanagement.service.EmployeeService;
import org.rdgie.assetmanagement.service.IdentifierTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
	@Autowired
	private IdentifierTypeService identifierTypeService;
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
	public String goToCreateEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("identifierTypeList", identifierTypeService.listIdentifierTypes());
		return "employee/createEmployee";
	}
	
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public String handleCreateEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		
		Identifier employeeIdentifier = employee.getIdentifier();
		
		IdentifierType idType = identifierTypeService.getIdentifierTypeByName(employeeIdentifier.getIdentifierType().getName());
		
		employeeIdentifier.setIdentifierType(idType);
		
		Set<Identifier> identifiers = employee.getIdentifiers();		
		identifiers.add(employeeIdentifier);	
		for (Identifier identifier : identifiers) {
			identifier.setEmployee(employee);
		}
		employee.setIdentifiers(identifiers);
		employeeService.addEmployee(employee);
		model.addAttribute("employeeList", this.employeeService.listEmployees());
		return "redirect:/listEmployees";

	}

	@RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
	public String listEmployee(Model model) {
		model.addAttribute("employeeList", this.employeeService.listEmployees());
		return "employee/listEmployees";
	}

	@RequestMapping("/editEmployee/{employeeId}")
	public String editItems(@PathVariable("employeeId") int employeeId, Model model) {
		
		model.addAttribute("employee", this.employeeService.getEmployeeById(employeeId));
		model.addAttribute("identifierTypeList", identifierTypeService.listIdentifierTypes());
					
		return "employee/createEmployee";
	}
}
