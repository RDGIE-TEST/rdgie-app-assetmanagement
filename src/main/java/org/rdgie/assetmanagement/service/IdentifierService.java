package org.rdgie.assetmanagement.service;

import java.util.List;

import org.rdgie.assetmanagement.domain.Identifier;

public interface IdentifierService {

	public Identifier getIdentifierById(int identifierId);

	public void addIdentifier(Identifier identifier);

	public void removeIdentifier(int identifierId);

	public void updateIdentifier(Identifier identifier);

	public List<Identifier> listIdentifiers();

}
