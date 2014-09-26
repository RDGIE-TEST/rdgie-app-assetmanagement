package org.rdgie.assetmanagement.service.impl;

import java.util.List;

import org.rdgie.assetmanagement.DAO.EntryDAO;
import org.rdgie.assetmanagement.domain.Entry;
import org.rdgie.assetmanagement.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntryServiceImpl implements EntryService {
	@Autowired
	private EntryDAO entryDAO;

	public void setEntryDAO(EntryDAO entryDAO) {
		this.entryDAO = entryDAO;
	}

	@Override
	@Transactional
	public Entry getEntryById(int entryId) {
		return this.entryDAO.getEntryById(entryId);
	}

	@Override
	@Transactional
	public void addEntry(Entry entry) {
		this.entryDAO.addEntry(entry);
	}

	@Override
	@Transactional
	public void removeEntry(int entryId) {
		this.entryDAO.removeEntry(entryId);
	}

	@Override
	@Transactional
	public void updateEntry(Entry entry) {
		this.entryDAO.updateEntry(entry);
	}

	@Override
	@Transactional
	public List<Entry> listEntries() {
		return this.entryDAO.listEntries();
	}

}