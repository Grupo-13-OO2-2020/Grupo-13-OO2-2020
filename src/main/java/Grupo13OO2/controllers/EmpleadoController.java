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

import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IEmpleadoService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping
public class EmpleadoController {
    @Autowired
    @Qualifier("empleadoService")
    private IEmpleadoService empleadoService;

    @GetMapping("/empleados")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_INDEX); 
        mAV.addObject("empleados", empleadoService.getAll());
        mAV.addObject("empleado", new EmpleadoModel());
        return mAV;
    }
    
    @GetMapping("/empleados/new")
    public ModelAndView create(@ModelAttribute("empleado") EmpleadoModel empleadoModel) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_FORM); 
        return mAV;
    }

    @PostMapping("/empleados/save")
    public String save(@ModelAttribute("empleado") EmpleadoModel empleadoModel) {
        empleadoService.insertOrUpdate(empleadoModel);
        return "redirect:/empleados";
    }
    @GetMapping("/empleados/editar/{id}")
	public ModelAndView ModelAndView( @ModelAttribute("empleado") EmpleadoModel empleadoModel, @PathVariable int id) {
		
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLEADO_FORM); 
        EmpleadoModel empleado = empleadoService.ListarId(id);
        mAV.addObject("empleado", empleado);
		return mAV;
	}
	
	@GetMapping("/empleados/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		empleadoService.delete(id);
		return "redirect:/empleados";
		
		
	}
}