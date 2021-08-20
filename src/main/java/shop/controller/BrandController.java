package shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.dao.BrandDAO;
import shop.model.Brand;
import shop.service.BrandService;

@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;

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
		if (brand.getId() == null) {
			brandService.save(brand);
		} else {
			brandService.update(brand);
		}

		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping(value = "/editBrand", method = RequestMethod.GET)
	public ModelAndView editBrand(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Brand brand = brandService.get(id);

		ModelAndView model = new ModelAndView("brand_form");

		model.addObject("brand", brand);

		return model;
	}

	@RequestMapping(value = "/deleteBrand", method = RequestMethod.GET)
	public ModelAndView deleteBrand(@RequestParam Integer id) {
		brandService.delete(id);
		return new ModelAndView("redirect:/admin");
	}

}
