package br.com.proxyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableController {

	@RequestMapping( "/table" )
	public String greeting( Model model ) {
		//model.addAttribute( "name", name );
		return "table";
	}
}
