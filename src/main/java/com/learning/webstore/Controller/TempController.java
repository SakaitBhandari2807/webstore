package com.learning.webstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/custom")
public class TempController {

	@RequestMapping("/list")
	public String list(Model model){
		return "customers";
	}
	@RequestMapping("/process")
	public String proces() {
		return "redirect:/custom/list";
	}
}
