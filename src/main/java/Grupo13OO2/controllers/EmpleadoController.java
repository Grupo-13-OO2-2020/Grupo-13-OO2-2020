package Grupo13OO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import Grupo13OO2.Entities.Empleado;
import Grupo13OO2.Entities.Producto;
import Grupo13OO2.Entities.User;
import Grupo13OO2.Models.ClienteModel;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.repositories.IUserRepository;
import Grupo13OO2.services.IEmpleadoService;
import Grupo13OO2.services.ILocalService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")

@RequestMapping("/empleados")
public class EmpleadoController {
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	

	@Autowired
	private IUserRepository userRepository;
	

	@Autowired
	@Qualifier("localService")
	private ILocalService localService;

	@GetMapping("")
	public ModelAndView index(@RequestParam Map<String, Object> params, Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_INDEX);
		//paginacion
		int page =params.get("page") !=null ? (Integer.valueOf(params.get("page").toString()) -1) : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 4);
		
		Page<EmpleadoModel> pageEmpleado = empleadoService.getAllPages(pageRequest);
		
		int totalPage= pageEmpleado.getTotalPages();
		if(totalPage>0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			mAV.addObject("pages",pages);
		}

		mAV.addObject("empleados", pageEmpleado.getContent());
		mAV.addObject("current", page+1);
		mAV.addObject("next" ,page+2);
		mAV.addObject("prev" ,page);
		mAV.addObject("last", totalPage);
		//datos de usuario
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
		EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
		mAV.addObject("empleado", e);
		
		return mAV;
	}

	@GetMapping("/sueldos/{id}")
	public @ResponseBody List<EmpleadoModel> sueldos(@PathVariable("id") int id) {
		return localService.calculoSueldos(id);
	}

	@GetMapping("/sueldo/{id}")
	public @ResponseBody Double sueldo(@PathVariable("id") int id) {
		return empleadoService.sueldoxEmpleado(empleadoService.ListarId(id));
	}

	
	@GetMapping("{id}")
	public ModelAndView local(@PathVariable("id") int id, Model model,@RequestParam Map<String, Object> params) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_INDEX_LOCAL);
		//agrego local
		mAV.addObject("local", localService.findById(id));
		//paginacion
int page =params.get("page") !=null ? (Integer.valueOf(params.get("page").toString()) -1) : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 4);
		
		Page<EmpleadoModel> pageEmpleado = empleadoService.getAllPages(pageRequest);
		
		int totalPage= pageEmpleado.getTotalPages();
		if(totalPage>0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			mAV.addObject("pages",pages);
		}

		mAV.addObject("empleados", pageEmpleado.getContent());
		mAV.addObject("current", page+1);
		mAV.addObject("next" ,page+2);
		mAV.addObject("prev" ,page);
		mAV.addObject("last", totalPage);
		
		//datos de usuario
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
		EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
		mAV.addObject("empleado", e);
		
		return mAV;
		
		
	
	}


	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_FORM);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
		EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
		mAV.addObject("empleado", e);
		mAV.addObject("empleado", new EmpleadoModel());
		mAV.addObject("locales", localService.getAll());
		return mAV;
	}

	@PostMapping("/save")
	public String create(@Valid @ModelAttribute("empleado") EmpleadoModel empleadoModel, BindingResult result) {
		if (result.hasErrors()) {
			return ViewRouteHelper.EMPLEADO_FORM;

		}
		empleadoService.insertOrUpdate(empleadoModel);
		return "redirect:/empleados";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView get(@PathVariable("id") int id) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_FORM);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
		EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
		mAV.addObject("empleado", e);
		mAV.addObject("empleado", empleadoService.ListarId(id));
		mAV.addObject("locales", localService.getAll());
		return mAV;
	}

	@GetMapping("/eliminar/{id}")

	public RedirectView delete(Model model, @PathVariable("id") int id, RedirectAttributes redirect){

		if (!empleadoService.findDependency(id)){
			empleadoService.delete(id);
			return new RedirectView("/empleados");
		}else
			redirect.addFlashAttribute("popUp", "error");
			return new RedirectView("/empleados");
	}

	
	
	@GetMapping("/partial/{id}")
	public ModelAndView getPartial(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_INDEX);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
		EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
		mAV.addObject("empleado", e);
		mAV.addObject("person", empleadoService.ListarId(id));
		return mAV;
	}

}