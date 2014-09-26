package org.rdgie.assetmanagement.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.rdgie.assetmanagement.DAO.IdentifierDAO;
import org.rdgie.assetmanagement.domain.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdentifierDAOImpl implements IdentifierDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(IdentifierDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Identifier getIdentifierById(int identifierId) {
		Session session = this.sessionFactory.getCurrentSession();
		Identifier i = (Identifier) session.load(Identifier.class, new Integer(
				identifierId));
		logger.info("Identifier loaded successfully, Identifier details=" + i);
		return i;
	}

	@Override
	public void addIdentifier(Identifier identifier) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(identifier);
		logger.info("Identifier saved successfully, Identifier Details=" + identifier);
	}

	@Override
	public void removeIdentifier(int identifierId) {
		Session session = this.sessionFactory.getCurrentSession();
		Identifier i = (Identifier) session.load(Identifier.class, new Integer(
				identifierId));
		if (null != i) {
			session.delete(i);
		}
		logger.info("Identifier deleted successfully, Identifier details=" + i);
	}

	@Override
	public void updateIdentifier(Identifier identifier) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(identifier);
		logger.info("Identifier updated successfully, Identifier Details=" + identifier);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Identifier> listIdentifiers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Identifier> identifiersList = session.createQuery(
				"from Identifier").list();
		for (Identifier i : identifiersList) {
			logger.info("Identifier List::" + i);
		}
		return identifiersList;
	}

}
