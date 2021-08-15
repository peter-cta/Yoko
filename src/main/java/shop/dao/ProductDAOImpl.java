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
import shop.model.Product;

public class ProductDAOImpl implements ProductDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public ProductDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	@Override
	public int save(Product pro) {
		String sql = "INSERT INTO Product (name, img, price, des, brandID) VALUES(?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, pro.getName(), pro.getImg(), pro.getPrice(), pro.getDes(), pro.getBrandID());
	}

	@Override
	public int update(Product pro) {
		String sql = "UPDATE Product Set name = ?, img = ?, price = ?, des = ?, brandID = ?  WHERE id = ?";
		return jdbcTemplate.update(sql, pro.getName(), pro.getImg(), pro.getPrice(), pro.getDes(), pro.getBrandID(), pro.getId());
	
	}

	@Override
	public Product get(Integer id) {
		String sql = "Select * from Product where id = "+id;
		
		ResultSetExtractor<Product> extractor = new  ResultSetExtractor<Product>() {

			@Override
			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String img = rs.getString("img");
					Double price = rs.getDouble("price");
					String des = rs.getString("des");
					Integer brandID = rs.getInt("brandID");
					return new Product(id, name, img, price, des, brandID);
				}
				return null;
				
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "Delete from Product where id = "+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Product> list() {
		String sql = "SELECT * FROM Product";
		
		RowMapper<Product> rowMapper = new RowMapper<Product>() {
		
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String img = rs.getString("img");
				Double price = rs.getDouble("price");
				String des = rs.getString("des");
				Integer brandID = rs.getInt("brandID");
				return new Product(id, name, img, price, des, brandID);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
