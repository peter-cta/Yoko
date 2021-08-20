package shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.dao.ProductDAO;
import shop.model.Product;
import shop.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public ModelAndView ProductDetail(ModelAndView model, @RequestParam Integer id) {
		Product product = productService.get(id);
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
		if (product.getId() == null) {
			productService.save(product);
		} else {
			productService.update(product);
		}

		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Product product = productService.get(id);

		ModelAndView model = new ModelAndView("product_form");

		model.addObject("product", product);

		return model;
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam Integer id) {
		productService.delete(id);
		return new ModelAndView("redirect:/admin");
	}

}
