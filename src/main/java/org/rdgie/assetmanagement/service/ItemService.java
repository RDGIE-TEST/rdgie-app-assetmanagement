package org.rdgie.assetmanagement.service;

import java.util.List;

import org.rdgie.assetmanagement.domain.Item;

public interface ItemService {

	public Item getItemById(int itemId);

	public void addItem(Item item);

	public void removeItem(int itemId);

	public void updateItem(Item item);

	public List<Item> listItems();

}