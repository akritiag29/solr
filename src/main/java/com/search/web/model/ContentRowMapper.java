package com.search.web.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.jdbc.core.RowMapper;

public class ContentRowMapper implements RowMapper<Object> {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Content content = new Content();
		content.setId(rs.getString("ID"));
		content.setBody(rs.getString("BODY"));
		content.setTitle(rs.getString("TITLE"));
		String[] rec = rs.getString("RECOMMENDATION").split(":");
		content.setRecommendations(Arrays.asList(rec));
		return content;
	}

}
