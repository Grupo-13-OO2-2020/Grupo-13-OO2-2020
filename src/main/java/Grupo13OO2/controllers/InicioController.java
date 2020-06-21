package Grupo13OO2.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/")

public class InicioController {

	
	    @GetMapping("")
	    public String getInternationalPage() {
	        return "index.html";
	    }
	
}
