package Grupo13OO2.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
public class InicioController {

	
	    @GetMapping("/")
	    public String getInternationalPage() {
	        return "index.html";
	    }
	
}
