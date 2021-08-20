package shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.dao.AccountDAO;
import shop.model.Account;
import shop.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/logout")
	public ModelAndView Logout(ModelAndView model) {
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView model) {
		model.setViewName("login");
		return model;
	}

	// Them , sua, xoa Account
	@RequestMapping(value = "/newAccount", method = RequestMethod.GET)
	public ModelAndView newAccount(ModelAndView model) {
		Account newAccount = new Account();
		model.addObject("account", newAccount);
		model.setViewName("account_form");
		return model;
	}

	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public ModelAndView saveAccount(@ModelAttribute Account account) {
		if (account.getId() == null) {
			accountService.save(account);
		} else {
			accountService.update(account);
		}

		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping(value = "/editAccount", method = RequestMethod.GET)
	public ModelAndView editAccount(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Account account = accountService.get(id);

		ModelAndView model = new ModelAndView("account_form");

		model.addObject("account", account);

		return model;
	}

	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public ModelAndView deleteAccount(@RequestParam Integer id) {
		accountService.delete(id);
		return new ModelAndView("redirect:/admin");
	}
}
