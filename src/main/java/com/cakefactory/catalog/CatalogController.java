package com.cakefactory.catalog;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author cvelasquez
 */
@Controller
public class CatalogController {
	
	@Autowired
	private CatalogService catalog;
	
	@GetMapping("/")
	ModelAndView index() {
		return new ModelAndView("catalog", Map.of("items", catalog.getItems()));
	}
}
