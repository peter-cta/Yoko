package shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.dao.CustomerDAO;
import shop.model.Customer;
import shop.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

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
		if (customer.getId() == null) {
			customerService.save(customer);
		} else {
			customerService.update(customer);
		}

		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editCustomer(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerService.get(id);

		ModelAndView model = new ModelAndView("customer_form");

		model.addObject("customer", customer);

		return model;
	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam Integer id) {
		customerService.delete(id);
		return new ModelAndView("redirect:/admin");
	}
}
