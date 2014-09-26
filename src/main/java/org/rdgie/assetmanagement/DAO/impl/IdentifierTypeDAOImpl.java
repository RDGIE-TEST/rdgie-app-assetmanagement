package org.rdgie.assetmanagement.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.rdgie.assetmanagement.DAO.IdentifierTypeDAO;
import org.rdgie.assetmanagement.domain.IdentifierType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdentifierTypeDAOImpl implements IdentifierTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public IdentifierType getIdentifierTypeById(int identifierTypeId) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(IdentifierType.class);
		cr.add(Restrictions.eq("identifierTypeId", identifierTypeId));
		IdentifierType i = (IdentifierType) cr.list().get(0);
		return i;
	}

	@Override
	public IdentifierType getIdentifierTypeByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(IdentifierType.class);
		cr.add(Restrictions.eq("name", name));

		IdentifierType i = (IdentifierType) cr.list().get(0);
		return i;
	}

	@Override
	public void addIdentifierType(IdentifierType identifierType) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(identifierType);

	}

	@Override
	public void removeIdentifierType(int identifierTypeId) {
		Session session = this.sessionFactory.getCurrentSession();
		IdentifierType i = (IdentifierType) session.load(IdentifierType.class,
				new Integer(identifierTypeId));
		if (null != i) {
			session.delete(i);
		}

	}

	@Override
	public void updateIdentifierType(IdentifierType identifierType) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(identifierType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IdentifierType> listIdentifierTypes() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(IdentifierType.class);
		List<IdentifierType> identifierTypesList = cr.list();
		return identifierTypesList;
	}

}
