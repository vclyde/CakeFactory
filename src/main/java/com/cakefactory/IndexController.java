package com.cakefactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author cvelasquez
 */
@Controller
public class IndexController {

	@GetMapping("/index")
	String index() {
		return "index";
	}
}