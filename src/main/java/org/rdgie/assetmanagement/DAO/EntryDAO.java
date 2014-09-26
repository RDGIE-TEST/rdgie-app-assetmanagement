package org.rdgie.assetmanagement.DAO;

import java.util.List;

import org.rdgie.assetmanagement.domain.Entry;

public interface EntryDAO {

	public Entry getEntryById(int EntryId);

	public void addEntry(Entry entry);

	public void removeEntry(int EntryId);

	public void updateEntry(Entry entry);

	public List<Entry> listEntries();

}