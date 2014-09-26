package org.rdgie.assetmanagement.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.rdgie.assetmanagement.DAO.EntryDAO;
import org.rdgie.assetmanagement.domain.Entry;
import org.rdgie.assetmanagement.domain.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EntryDAOImpl implements EntryDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(EntryDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Entry getEntryById(int EntryId) {
		Session session = this.sessionFactory.getCurrentSession();
		Entry d = (Entry) session.load(Entry.class, new Integer(EntryId));
		logger.info("Entry loaded successfully, Entry details=" + d);
		return d;
	}

	@Override
	public void addEntry(Entry entry) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(entry);
		logger.info("Entry saved successfully, Entry Details=" + entry);
	}

	@Override
	public void removeEntry(int EntryId) {
		Session session = this.sessionFactory.getCurrentSession();
		Entry d = (Entry) session.load(Entry.class, new Integer(EntryId));
		if (null != d) {
			session.delete(d);
		}
		logger.info("Entry deleted successfully, Entry details=" + d);
	}

	@Override
	public void updateEntry(Entry entry) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(entry);
		logger.info("Entry updated successfully, Entry Details=" + entry);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entry> listEntries() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Entry> entryList = session.createQuery("from Entry").list();
		return entryList;
	}

}