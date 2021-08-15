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



@Controller
public class MainController {
	
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private BrandDAO brandDAO;
	
	@RequestMapping(value = "/")
	public ModelAndView Login(ModelAndView model) {
		List<Product> listPro = productDAO.list();
		List<Brand> listBrand = brandDAO.list();
		model.addObject("listPro", listPro);
		model.addObject("listBrand", listBrand);
		model.setViewName("home");
		return model;
	}
	
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
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView listContact(ModelAndView model , @RequestParam("username") String username, @RequestParam("password") String password) {

		Account acc = accountDAO.login(username, password);
		if(acc!=null) {	
			if(acc.getPosition().equals("admin")) {
				List<Account> listAcc = accountDAO.list();
				List<Product> listPro = productDAO.list();
				List<Customer> listCus = customerDAO.list();
				List<Brand> listBrand = brandDAO.list();
				model.addObject("listAcc", listAcc);
				model.addObject("listPro", listPro);
				model.addObject("listCus", listCus);
				model.addObject("listBrand", listBrand);
				model.addObject("acc", acc);
				model.setViewName("admin");
				return model;
			}else if(acc.getPosition().equals("customer")) {
				List<Account> listAcc = accountDAO.list();
				List<Product> listPro = productDAO.list();
				List<Brand> listBrand = brandDAO.list();
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
	
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public ModelAndView ProductDetail(ModelAndView model, @RequestParam Integer id) {
		Product product = productDAO.get(id);
		model.addObject("product", product);
		model.setViewName("product_detail");
		return model;
	}
	
// Them , sua, xoa Product
	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public ModelAndView newProduct(ModelAndView model) {
		Product newProduct = new Product();
		model.addObject("product", newProduct);
		model.setViewName("product_form");
		return model;
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute Product product) {		
		if(product.getId() == null) {
			productDAO.save(product);
		}else {
			productDAO.update(product);
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Product product = productDAO.get(id);
		
		ModelAndView model = new ModelAndView("product_form");
		
		model.addObject("product", product);

		return model;
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam Integer id) {
		productDAO.delete(id);
		return new ModelAndView("redirect:/");
	}

	
// Them , sua, xoa Customer
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public ModelAndView newCustomer(ModelAndView model) {
		Customer newCustomer = new Customer();
		model.addObject("customer", newCustomer);
		model.setViewName("customer_form");
		return model;
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute Customer customer) {		
		if(customer.getId() == null) {
			customerDAO.save(customer);
		}else {
			customerDAO.update(customer);
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editCustomer(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDAO.get(id);
		
		ModelAndView model = new ModelAndView("customer_form");
		
		model.addObject("customer", customer);

		return model;
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam Integer id) {
		customerDAO.delete(id);
		return new ModelAndView("redirect:/");
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
			if(account.getId() == null) {
				accountDAO.save(account);
			}else {
				accountDAO.update(account);
			}
			
			return new ModelAndView("redirect:/");
		}
		
		@RequestMapping(value = "/editAccount", method = RequestMethod.GET)
		public ModelAndView editAccount(HttpServletRequest request) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Account account = accountDAO.get(id);
			
			ModelAndView model = new ModelAndView("account_form");
			
			model.addObject("account", account);

			return model;
		}
		
		@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
		public ModelAndView deleteAccount(@RequestParam Integer id) {
			accountDAO.delete(id);
			return new ModelAndView("redirect:/");
		}
		
// Them , sua, xoa Brand
				@RequestMapping(value = "/newBrand", method = RequestMethod.GET)
				public ModelAndView newBrand(ModelAndView model) {
					Brand newBrand = new Brand();
					model.addObject("brand", newBrand);
					model.setViewName("brand_form");
					return model;
				}
				
				@RequestMapping(value = "/saveBrand", method = RequestMethod.POST)
				public ModelAndView saveBrand(@ModelAttribute Brand brand) {		
					if(brand.getId() == null) {
						brandDAO.save(brand);
					}else {
						brandDAO.update(brand);
					}
					
					return new ModelAndView("redirect:/");
				}
				
				@RequestMapping(value = "/editBrand", method = RequestMethod.GET)
				public ModelAndView editBrand(HttpServletRequest request) {
					Integer id = Integer.parseInt(request.getParameter("id"));
					Brand brand = brandDAO.get(id);
					
					ModelAndView model = new ModelAndView("brand_form");
					
					model.addObject("brand", brand);

					return model;
				}
				
				@RequestMapping(value = "/deleteBrand", method = RequestMethod.GET)
				public ModelAndView deleteBrand(@RequestParam Integer id) {
					brandDAO.delete(id);
					return new ModelAndView("redirect:/");
				}
		
}
