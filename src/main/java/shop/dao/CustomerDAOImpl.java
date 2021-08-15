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
import shop.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	
	@Override
	public int save(Customer cus) {
		String sql = "INSERT INTO Customer (name, email, phone, address, account_id) VALUES(?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, cus.getName(), cus.getEmail(), cus.getPhone(), cus.getAddress(), cus.getAccount_id());
	}

	@Override
	public int update(Customer cus) {
		String sql = "UPDATE Customer Set name = ?, email = ?, phone = ?, address = ?, account_id = ? WHERE id = ?";
		return jdbcTemplate.update(sql, cus.getName(), cus.getEmail(), cus.getPhone(), cus.getAddress(), cus.getAccount_id(), cus.getId());
	
	}

	@Override
	public Customer get(Integer id) {
		String sql = "Select * from Customer where id = "+id;
		
		ResultSetExtractor<Customer> extractor = new  ResultSetExtractor<Customer>() {

			@Override
			public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					Integer account_id = rs.getInt("account_id");
					return new Customer(id, name, email, phone, address, account_id);
				}
				return null;
				
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "Delete from Customer where id = "+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Customer> list() {
		String sql = "SELECT * FROM Customer";
		
		RowMapper<Customer> rowMapper = new RowMapper<Customer>() {
		
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Integer account_id = rs.getInt("account_id");
				return new Customer(id, name, email, phone, address, account_id);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
