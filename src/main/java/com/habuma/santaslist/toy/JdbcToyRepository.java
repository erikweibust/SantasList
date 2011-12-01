package com.habuma.santaslist.toy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcToyRepository implements ToyRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcToyRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public long createToy(Toy toy) {
		jdbcTemplate.update("INSERT INTO toy (name, description, onhand) VALUES (?, ?, ?)", toy.getName(), toy.getDescription(), toy.getOnhand());
        return jdbcTemplate.queryForLong("call identity()");
	}

	public Toy getToy(long id) {
		List<Toy> toys = jdbcTemplate.query("SELECT id, name, description, onhand FROM toy WHERE id=?", new ToyMapper(), id);
		return (toys.size() > 0) ? toys.get(0) : null;
	}

	public List<Toy> getAllToys() {
		return jdbcTemplate.query("SELECT id, name, description, onhand FROM toy", new ToyMapper());
	}

	public void updateOnHand(long id, long onhand) {
		jdbcTemplate.update("UPDATE toy SET onhand=? HWERE id=?", onhand, id);
	}

	public void deleteToy(long id) {
		jdbcTemplate.update("DELETE FROM toy WHERE id=?", id);
	}

	private static class ToyMapper implements RowMapper<Toy> {
		public Toy mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Toy(rs.getLong("id"), rs.getString("name"), rs.getString("description"), rs.getLong("onhand"));
		}
	}
}
