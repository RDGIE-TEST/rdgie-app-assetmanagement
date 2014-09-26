package org.rdgie.assetmanagement.service;

import java.util.List;

import org.rdgie.assetmanagement.domain.IdentifierType;

public interface IdentifierTypeService {

	public IdentifierType getIdentifierTypeById(int identifierTypeId);

	public IdentifierType getIdentifierTypeByName(String name);

	public void addIdentifierType(IdentifierType identifierType);

	public void removeIdentifierType(int identifierTypeId);

	public void updateIdentifierType(IdentifierType identifierType);

	public List<IdentifierType> listIdentifierTypes();

}
