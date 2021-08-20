package shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import shop.dao.AccountDAO;
import shop.dao.BrandDAO;
import shop.dao.CustomerDAO;
import shop.dao.ProductDAO;
import shop.model.Account;
import shop.model.Brand;
import shop.model.Customer;
import shop.model.Product;
import shop.service.AccountService;
import shop.service.BrandService;
import shop.service.CustomerService;
import shop.service.ProductService;



@Controller
public class MainController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(value = "/")
	public ModelAndView Login(ModelAndView model) {
		List<Product> listPro = productService.list();
		List<Brand> listBrand = brandService.list();
		model.addObject("listPro", listPro);
		model.addObject("listBrand", listBrand);
		model.addObject("status", "notlogin");
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/admin")
	public ModelAndView admin(ModelAndView model, @ModelAttribute Account acc) {
		List<Account> listAcc = accountService.list();
		List<Product> listPro = productService.list();
		List<Customer> listCus = customerService.list();
		List<Brand> listBrand = brandService.list();
		model.addObject("listAcc", listAcc);
		model.addObject("listPro", listPro);
		model.addObject("listCus", listCus);
		model.addObject("listBrand", listBrand);
		model.addObject("acc", acc);
		model.setViewName("admin");
		return model;
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView listContact(ModelAndView model , @RequestParam("username") String username, @RequestParam("password") String password) {

		Account acc = accountService.login(username, password);
		if(acc!=null) {	
			if(acc.getPosition().equals("admin")) {
				return new ModelAndView("redirect:/admin");
			}else if(acc.getPosition().equals("customer")) {
				List<Account> listAcc = accountService.list();
				List<Product> listPro = productService.list();
				List<Brand> listBrand = brandService.list();
				model.addObject("listAcc", listAcc);
				model.addObject("listPro", listPro);
				model.addObject("listBrand", listBrand);
				model.addObject("acc", acc);
				model.setViewName("home");
				return model;
			}
		}
		model.setViewName("login");
		return model;
		
	}
	
	
	

	

		

}
