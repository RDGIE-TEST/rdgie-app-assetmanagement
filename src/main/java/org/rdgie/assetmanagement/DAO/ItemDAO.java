package org.rdgie.assetmanagement.DAO;

import java.util.List;

import org.rdgie.assetmanagement.domain.Item;

public interface ItemDAO {

	public Item getItemById(int itemId);

	public void addItem(Item item);

	public void removeItem(int itemId);

	public void updateItem(Item item);

	public List<Item> listItems();

}
