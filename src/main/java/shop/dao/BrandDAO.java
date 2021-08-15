package shop.dao;

import java.util.List;

import shop.model.Brand;

public interface BrandDAO {
	public int save(Brand b);
	public int update(Brand b);
	public Brand get(Integer id);
	public int delete(Integer id);
	public List<Brand> list();
}
