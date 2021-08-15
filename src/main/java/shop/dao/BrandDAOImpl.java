package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import shop.model.Account;
import shop.model.Brand;

public class BrandDAOImpl implements BrandDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public BrandDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	@Override
	public int save(Brand b) {
		String sql = "INSERT INTO Brand (name, address, phone, des) VALUES(?, ?, ?, ?)";
		return jdbcTemplate.update(sql, b.getName(), b.getAddress(), b.getPhone(), b.getDes());
	}

	@Override
	public int update(Brand b) {
		String sql = "UPDATE Brand Set name = ?, address = ?, phone = ?, des = ? WHERE id = ?";
		return jdbcTemplate.update(sql, b.getName(), b.getAddress(), b.getPhone(), b.getDes(), b.getId());
	}

	@Override
	public Brand get(Integer id) {
		String sql = "Select * from Brand where id = "+id;
		
		ResultSetExtractor<Brand> extractor = new  ResultSetExtractor<Brand>() {

			@Override
			public Brand extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String des = rs.getString("des");
					return new Brand(id, name, address, phone, des);
				}
				return null;
				
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "Delete from Brand where id = "+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Brand> list() {
		String sql = "SELECT * FROM Brand";
		
		RowMapper<Brand> rowMapper = new RowMapper<Brand>() {
		
			@Override
			public Brand mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String des = rs.getString("des");
				return new Brand(id, name, address, phone, des);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
