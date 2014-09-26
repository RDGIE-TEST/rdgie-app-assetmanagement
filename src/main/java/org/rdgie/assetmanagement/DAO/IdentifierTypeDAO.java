package org.rdgie.assetmanagement.DAO;

import java.util.List;

import org.rdgie.assetmanagement.domain.IdentifierType;

public interface IdentifierTypeDAO {

	public IdentifierType getIdentifierTypeById(int identifierTypeId);

	public IdentifierType getIdentifierTypeByName(String name);

	public void addIdentifierType(IdentifierType identifierType);

	public void removeIdentifierType(int identifierTypeId);

	public void updateIdentifierType(IdentifierType identifierType);

	public List<IdentifierType> listIdentifierTypes();

}
