package shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.CustomerDAO;
import shop.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public int save(Customer cus) {
		// TODO Auto-generated method stub
		return customerDAO.save(cus);
	}

	@Override
	public int update(Customer cus) {
		// TODO Auto-generated method stub
		return customerDAO.update(cus);
	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		return customerDAO.get(id);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return customerDAO.delete(id);
	}

	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return customerDAO.list();
	}

}
