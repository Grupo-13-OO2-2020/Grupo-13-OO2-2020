package Grupo13OO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Grupo13OO2.Entities.User;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.repositories.IUserRepository;
import Grupo13OO2.services.IEmpleadoService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/")

public class InicioController {
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	

	@Autowired
	private IUserRepository userRepository;

	
	    @GetMapping("")
	    public ModelAndView getInternationalPage() {
			ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			mAV.addObject("usuario", auth.getName());
			User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
			EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
			mAV.addObject("empleado", e);
	        return mAV;
	    }
	
}
