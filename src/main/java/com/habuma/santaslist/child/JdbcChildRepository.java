package com.habuma.santaslist.child;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcChildRepository implements ChildRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcChildRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public long createChild(Child child) {
		jdbcTemplate.update("INSERT INTO child (name, address, naughty) VALUES (?, ?, ?)", child.getName(), child.getAddress(), child.isNaughty());
        return jdbcTemplate.queryForLong("call identity()");
	}

	public Child getChild(long id) {
		List<Child> children = jdbcTemplate.query("SELECT id, name, address, naughty FROM child WHERE id=?", new ChildMapper(), id);
		return (children.size() > 0) ? children.get(0) : null;
	}

	public List<Child> getAllChildren() {
		return jdbcTemplate.query("SELECT id, name, address, naughty FROM child", new ChildMapper());
	}

	public void updateStatus(long id, boolean naughty) {
		jdbcTemplate.update("UPDATE child SET naughty=? WHERE id=?", naughty, id);
	}

	private static class ChildMapper implements RowMapper<Child> {
		public Child mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Child(rs.getLong("id"), rs.getString("name"), rs.getString("address"), rs.getBoolean("naughty"));
		}		
	}
}
