package org.rdgie.assetmanagement.service.impl;

import java.util.List;

import org.rdgie.assetmanagement.DAO.IdentifierDAO;
import org.rdgie.assetmanagement.domain.Identifier;
import org.rdgie.assetmanagement.service.IdentifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdentifierServiceImpl implements IdentifierService {
	@Autowired
	private IdentifierDAO identifierDAO;

	public void setIdentifierDAO(IdentifierDAO identifierDAO) {
		this.identifierDAO = identifierDAO;
	}

	@Override
	@Transactional
	public Identifier getIdentifierById(int identifierId) {
		return this.identifierDAO.getIdentifierById(identifierId);
	}

	@Override
	@Transactional
	public void addIdentifier(Identifier identifier) {
		this.identifierDAO.addIdentifier(identifier);
	}

	@Override
	@Transactional
	public void removeIdentifier(int identifierId) {
		this.identifierDAO.removeIdentifier(identifierId);
	}

	@Override
	@Transactional
	public void updateIdentifier(Identifier identifier) {
		this.identifierDAO.updateIdentifier(identifier);
	}

	@Override
	@Transactional
	public List<Identifier> listIdentifiers() {
		return this.identifierDAO.listIdentifiers();
	}

}
