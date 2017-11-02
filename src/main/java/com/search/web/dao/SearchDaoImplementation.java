package com.search.web.dao;

import com.search.web.model.Content;
import com.search.web.model.ContentRowMapper;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SearchDaoImplementation extends JdbcDaoSupport implements SearchDao {

	@Override
	public void insertLogs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Content getDocument(String documentId) {
		String sql = "SELECT * from CONTENT where id = ?";
		Content content = (Content) getJdbcTemplate().queryForObject(sql, new Object[] {documentId},
				new ContentRowMapper());
		return content;
	}
}
