package Grupo13OO2.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Grupo13OO2.helpers.ViewRouteHelper;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/")

public class InicioController {

	
	    @GetMapping("")
	    public ModelAndView getInternationalPage() {
			ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			mAV.addObject("usuario", auth.getName());
	        return mAV;
	    }
	
}
