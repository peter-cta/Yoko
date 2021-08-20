package shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.ProductDAO;
import shop.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public int save(Product pro) {
		// TODO Auto-generated method stub
		return productDAO.save(pro);
	}

	@Override
	public int update(Product pro) {
		// TODO Auto-generated method stub
		return productDAO.update(pro);
	}

	@Override
	public Product get(Integer id) {
		// TODO Auto-generated method stub
		return productDAO.get(id);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return productDAO.delete(id);
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return productDAO.list();
	}

}
