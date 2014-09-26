package org.rdgie.assetmanagement.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.rdgie.assetmanagement.DAO.impl.ItemDAOImpl;
import org.rdgie.assetmanagement.domain.Item;
import org.rdgie.assetmanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDAOImpl itemDAO;

	public void setItemDAO(ItemDAOImpl itemDAO) {
		this.itemDAO = itemDAO;
	}

	@Override
	@Transactional
	public Item getItemById(int itemId) {
		return this.itemDAO.getItemById(itemId);
	}

	@Override
	@Transactional
	public void addItem(Item item) {
		this.itemDAO.addItem(item);
	}

	@Override
	@Transactional
	public void removeItem(int itemId) {
		this.itemDAO.removeItem(itemId);
	}

	@Override
	@Transactional
	public void updateItem(Item item) {
		this.itemDAO.updateItem(item);
	}

	@Override
	@Transactional
	public List<Item> listItems() {
		return this.itemDAO.listItems();
	}

}
