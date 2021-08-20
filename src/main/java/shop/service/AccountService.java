package shop.service;

import java.util.List;

import shop.model.Account;

public interface AccountService {
	public int save(Account acc);
	public int update(Account acc);
	public Account get(Integer id);
	public int delete(Integer id);
	public List<Account> list();
	public Account login(String username, String password);
}
