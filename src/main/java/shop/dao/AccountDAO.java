package shop.dao;

import java.util.List;

import shop.model.Account;

public interface AccountDAO {
	public int save(Account acc);
	public int update(Account acc);
	public Account get(Integer id);
	public int delete(Integer id);
	public List<Account> list();
	public Account login(String username, String password);
}
