package org.rdgie.assetmanagement.web;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rdgie.assetmanagement.domain.Entry;
import org.rdgie.assetmanagement.domain.Item;
import org.rdgie.assetmanagement.service.EmployeeService;
import org.rdgie.assetmanagement.service.EntryService;
import org.rdgie.assetmanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EntryController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ItemService itemsService;
	
	@Autowired
	private EntryService entryService;

	@RequestMapping(value = "/createEntry", method = RequestMethod.GET)
	public String goToCreateEntry(Model model) {
		
		model.addAttribute("entry", new Entry());
		model.addAttribute("employeeList", this.employeeService.listEmployees());
		model.addAttribute("entryTypeList",Entry.EntryType.values());
		model.addAttribute("itemList", this.itemsService.listItems());
		return "entry/createEntry";
	}
	
	@RequestMapping(value = "/createEntry", method = RequestMethod.POST)
	public String handleCreateEntry(
			@ModelAttribute("entry") Entry entry,
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) {		
		
		int employeeId = Integer.parseInt(request.getParameter("employeeListFromPage"));
		
		
		String itemIds = request.getParameter("itemListFromPage");
		String[] ids = itemIds.split(",");		
		Set<Item> selectedItems = new HashSet<Item>();
		
		for (String string : ids) {
           selectedItems.add(itemsService.getItemById(Integer.valueOf(string)));
		}
		
		entry.setEmployee(employeeService.getEmployeeById(employeeId));
		entry.setItems(selectedItems);
		entry.setDate(new Date());
		
		this.entryService.addEntry(entry);	
		model.addAttribute("entryList",this.entryService.listEntries());
		return "redirect:/listEntries";
		
	}
	
	@RequestMapping(value = "/listEntries", method = RequestMethod.GET)
	public String goToEntryList(Model model) {
		model.addAttribute("entryList",this.entryService.listEntries());
		return "entry/listEntries";
	}
	
	@RequestMapping("/editEntry/{entryId}")
	public String editItems(@PathVariable("entryId") int entryId, Model model) {
		
		model.addAttribute("entry", this.entryService.getEntryById(entryId));
		
		model.addAttribute("entryList", this.entryService.listEntries());
		model.addAttribute("itemList", this.itemsService.listItems());
		
		return "entry/createEntry";
	}

	
	
	
	
}