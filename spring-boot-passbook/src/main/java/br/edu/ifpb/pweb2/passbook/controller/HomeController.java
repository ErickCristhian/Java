package br.edu.ifpb.pweb2.passbook.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Home(HttpSession session, ModelAndView modelAndView) {
		if (session.getAttribute("usuarioLogado") != null) {
			modelAndView.setViewName("home");			
		} else {
			modelAndView.setViewName("redirect:/login");
		}
		return modelAndView;
	}

}