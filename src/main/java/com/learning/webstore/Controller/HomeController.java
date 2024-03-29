package com.learning.webstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

	 @RequestMapping
	 public String welcome(Model model,RedirectAttributes redirectAttributes) {
		 
		model.addAttribute("greeting","Welcome to web Store!");
		model.addAttribute("tagline","The one and only amazing store");
		redirectAttributes.addFlashAttribute("greeting","Welcome to web store");
		redirectAttributes.addFlashAttribute("tagline", "The one and only Amazing store");
		return "redirect:/welcome/greeting"; 
	 }
	 @RequestMapping("/welcome/greeting")
	 public String greeting() {
		 return "welcome";
	 }
}
