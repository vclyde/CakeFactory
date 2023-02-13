package com.cakefactory.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author cvelasquez
 */
@Controller
public class IndexController {

	@GetMapping("/")
	String index() {
		return "index";
	}

}
