package shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.AccountDAO;
import shop.model.Account;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDAO accountDAO;

	@Override
	public int save(Account acc) {
		return accountDAO.save(acc);
	}

	@Override
	public int update(Account acc) {
		// TODO Auto-generated method stub
		return accountDAO.update(acc);
	}

	@Override
	public Account get(Integer id) {
		// TODO Auto-generated method stub
		return accountDAO.get(id);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return accountDAO.delete(id);
	}

	@Override
	public List<Account> list() {
		// TODO Auto-generated method stub
		return accountDAO.list();
	}

	@Override
	public Account login(String username, String password) {
		// TODO Auto-generated method stub
		return accountDAO.login(username, password);
	}
	
}
