package com.search.web.dao;

import com.search.web.model.Content;

public interface SearchDao {
	
	public void insertLogs();
	public Content getDocument(String documentId);

}
