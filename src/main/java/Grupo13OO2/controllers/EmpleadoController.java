package Grupo13OO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IEmpleadoService;
import Grupo13OO2.services.ILocalService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;

	@Autowired
	@Qualifier("localService")
	private ILocalService localService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_INDEX);
		mAV.addObject("empleados", empleadoService.getAll());
		return mAV;
	}

	@GetMapping("/sueldo/{id}")
	public ModelAndView sueldo(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_INDEX_LOCAL);
		mAV.addObject("empleados", localService.calcularSueldos(id));
		mAV.addObject("locales", localService.findById(id));
		return mAV;
	}

	
	@GetMapping("{id}")
	public ModelAndView local(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_INDEX_LOCAL);
		mAV.addObject("empleados", localService.findById(id).getEmpleados());
		mAV.addObject("locales", localService.findById(id));
		return mAV;
	}


	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_FORM);
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
		mAV.addObject("empleado", empleadoService.ListarId(id));
		mAV.addObject("locales", localService.getAll());
		return mAV;
	}

	@GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable("id") int id) {
		empleadoService.delete(id);
		return new RedirectView("/empleados");
	}

	@GetMapping("/partial/{id}")
	public ModelAndView getPartial(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_INDEX);
		mAV.addObject("person", empleadoService.ListarId(id));
		return mAV;
	}

}