package org.rdgie.assetmanagement.service;

import java.util.List;

import org.rdgie.assetmanagement.domain.Entry;

public interface EntryService {

	public Entry getEntryById(int entryId);

	public void addEntry(Entry entry);

	public void removeEntry(int entryId);

	public void updateEntry(Entry entry);

	public List<Entry> listEntries();

}