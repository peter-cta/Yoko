package shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.AccountDAO;
import shop.dao.BrandDAO;
import shop.model.Brand;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired
	private BrandDAO brandDAO;
	
	@Override
	public int save(Brand b) {
		// TODO Auto-generated method stub
		return brandDAO.save(b);
	}

	@Override
	public int update(Brand b) {
		// TODO Auto-generated method stub
		return brandDAO.update(b);
	}

	@Override
	public Brand get(Integer id) {
		// TODO Auto-generated method stub
		return brandDAO.get(id);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return brandDAO.delete(id);
	}

	@Override
	public List<Brand> list() {
		// TODO Auto-generated method stub
		return brandDAO.list();
	}

}
