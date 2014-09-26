package org.rdgie.assetmanagement.web;

import java.util.Set;

import org.rdgie.assetmanagement.domain.Identifier;
import org.rdgie.assetmanagement.domain.IdentifierType;
import org.rdgie.assetmanagement.domain.Item;
import org.rdgie.assetmanagement.service.IdentifierTypeService;
import org.rdgie.assetmanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@Autowired
	private IdentifierTypeService identifierTypeService;

	@RequestMapping(value = "/createItem", method = RequestMethod.GET)
	public String goToCreateItem(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("itemStatusList", Item.Status.values());
		model.addAttribute("itemConditionList", Item.Condition.values());
		model.addAttribute("identifierTypeList",
				identifierTypeService.listIdentifierTypes());
		return "item/createItem";
	}

	@RequestMapping(value = "/createItem", method = RequestMethod.POST)
	public String handleCreateItem(@ModelAttribute("item") Item item,
			Model model) {
		Identifier itemIdentifier = item.getIdentifier();

		IdentifierType idType = identifierTypeService
				.getIdentifierTypeByName(itemIdentifier.getIdentifierType()
						.getName());

		itemIdentifier.setIdentifierType(idType);

		Set<Identifier> identifiers = item.getIdentifiers();
		identifiers.add(itemIdentifier);

		for (Identifier identifier : identifiers) {
			identifier.setItem(item);
		}
		item.setIdentifiers(identifiers);
		this.itemService.addItem(item);

		model.addAttribute("itemList", this.itemService.listItems());
		return "redirect:/listItems";

	}

	@RequestMapping(value = "/listItems", method = RequestMethod.GET)
	public String listItems(Model model) {
		model.addAttribute("itemList", this.itemService.listItems());
		return "item/listItems";
	}

	@RequestMapping("/editItem/{itemId}")
	public String editItems(@PathVariable("itemId") int itemId, Model model) {

		model.addAttribute("item", this.itemService.getItemById(itemId));
		model.addAttribute("identifierTypeList",
				identifierTypeService.listIdentifierTypes());
		return "item/createItem";
	}

}
