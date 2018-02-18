package com.workflow.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/")
	public String test(Model model) {
		model.addAttribute("pageTitle", "Login");
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("pageTitle", "Dashboard");
		//return "dashboard";
                return "redirect:/dashboard"; 
	}
                
        @RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("pageTitle", "Dashboard");
		//return "dashboard";
                return "dashboard"; 
	}
}
