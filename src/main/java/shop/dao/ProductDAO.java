package shop.dao;

import java.util.List;

import shop.model.Product;

public interface ProductDAO {
	public int save(Product pro);
	public int update(Product pro);
	public Product get(Integer id);
	public int delete(Integer id);
	public List<Product> list();
}
