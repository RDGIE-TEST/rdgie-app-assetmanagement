package org.rdgie.assetmanagement.DAO;

import java.util.List;

import org.rdgie.assetmanagement.domain.Identifier;

public interface IdentifierDAO {

	public Identifier getIdentifierById(int identifierId);

	public void addIdentifier(Identifier identifier);

	public void removeIdentifier(int identifierId);

	public void updateIdentifier(Identifier identifier);

	public List<Identifier> listIdentifiers();

}
