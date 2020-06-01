package Grupo13OO2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

	
	    @GetMapping("/")
	    public String getInternationalPage() {
	        return "index.html";
	    }
	
}
