package org.rdgie.assetmanagement.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.rdgie.assetmanagement.DAO.IdentifierTypeDAO;
import org.rdgie.assetmanagement.domain.IdentifierType;
import org.rdgie.assetmanagement.service.IdentifierTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentifierTypeServiceImpl implements IdentifierTypeService {

	@Autowired
	private IdentifierTypeDAO identifierTypeDAO;

	public void setIdentifierTypeDAO(IdentifierTypeDAO identifierTypeDAO) {
		this.identifierTypeDAO = identifierTypeDAO;
	}

	@Override
	@Transactional
	public IdentifierType getIdentifierTypeById(int identifierTypeId) {
		return this.identifierTypeDAO.getIdentifierTypeById(identifierTypeId);
	}

	@Override
	@Transactional
	public IdentifierType getIdentifierTypeByName(String name) {
		return this.identifierTypeDAO.getIdentifierTypeByName(name);
	}

	@Override
	@Transactional
	public void addIdentifierType(IdentifierType identifierType) {
		this.identifierTypeDAO.addIdentifierType(identifierType);

	}

	@Override
	@Transactional
	public void removeIdentifierType(int identifierTypeId) {
		this.identifierTypeDAO.removeIdentifierType(identifierTypeId);

	}

	@Override
	@Transactional
	public void updateIdentifierType(IdentifierType identifierType) {
		this.identifierTypeDAO.updateIdentifierType(identifierType);

	}

	@Override
	@Transactional
	public List<IdentifierType> listIdentifierTypes() {

		return this.identifierTypeDAO.listIdentifierTypes();
	}

}
