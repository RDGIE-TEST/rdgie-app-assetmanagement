package org.rdgie.assetmanagement.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.rdgie.assetmanagement.DAO.ItemDAO;
import org.rdgie.assetmanagement.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOImpl implements ItemDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ItemDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Item getItemById(int itemId) {
		Session session = this.sessionFactory.getCurrentSession();
		Item t = (Item) session.load(Item.class, new Integer(itemId));
		logger.info("Item loaded successfully, Item details=" + t);
		return t;
	}

	@Override
	public void addItem(Item item) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(item);
		logger.info("Item saved successfully, Item Details=" + item);
	}

	@Override
	public void removeItem(int itemId) {
		Session session = this.sessionFactory.getCurrentSession();
		Item t = (Item) session.load(Item.class, new Integer(itemId));
		if (null != t) {
			session.delete(t);
		}
		logger.info("Item deleted successfully, Item details=" + t);
	}

	@Override
	public void updateItem(Item item) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(item);
		logger.info("Item updated successfully, Item Details=" + item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> listItems() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Item> listItems = session.createQuery("from Item").list();
		for (Item t : listItems) {
			logger.info("Item List::" + t);
		}
		return listItems;
	}

}
