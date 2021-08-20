package shop.service;

import java.util.List;

import shop.model.Customer;

public interface CustomerService {
	public int save(Customer cus);
	public int update(Customer cus);
	public Customer get(Integer id);
	public int delete(Integer id);
	public List<Customer> list();
}
