package Grupo13OO2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Entities.User;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.repositories.IUserRepository;
import Grupo13OO2.services.IEmpleadoService;
import Grupo13OO2.services.ILocalService;
import Grupo13OO2.services.ILoteService;
import Grupo13OO2.services.IProductoService;

@Controller
@RequestMapping("/lotes")
public class LoteController {

	@Autowired
	@Qualifier("localService")
	private ILocalService localService;

	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	

	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	

	@Autowired
	private IUserRepository userRepository;


	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_INDEX);
		mAV.addObject("lotes", loteService.getAll());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
		EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
		mAV.addObject("empleado", e);
		return mAV;
	}

	@GetMapping("{id}")
	public ModelAndView local(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_INDEX_LOCAL);
		mAV.addObject("lotes", localService.findById(id).getLotes());
		mAV.addObject("local", localService.findById(id));
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
		EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
		mAV.addObject("empleado", e);
		return mAV;
	}

	@GetMapping("/new/{id}")
	public ModelAndView create(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_FORM_MAIN);
		mAV.addObject("local", localService.findById(id));
		mAV.addObject("lote", new LoteModel());
		mAV.addObject("productos", productoService.getAll());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
		EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
		mAV.addObject("empleado", e);
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_FORM);
		mAV.addObject("lote", new LoteModel());
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("locales", localService.getAll());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
		EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
		mAV.addObject("empleado", e);
		return mAV;
	}

	@PostMapping("/save")
	public RedirectView create(@ModelAttribute("lote") LoteModel loteModel) {
		//loteModel.setCantidadExistente(loteModel.getCantidadRecibida());
		loteService.insertOrUpdate(loteModel);
		
		return new RedirectView("/lotes");
	}

	@GetMapping("/editar/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_FORM);
		mAV.addObject("lote", loteService.ListarId(id));
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("locales", localService.getAll());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		User u = userRepository.findByUsernameAndFetchUserRolesEagerly(auth.getName());
		EmpleadoModel e = empleadoService.ListarId(u.getEmpleado().getId());
		mAV.addObject("empleado", e);
		return mAV;
	}

	@GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable("id") int id) {
		loteService.delete(id);
		return new RedirectView("/lotes");
	}
	
	@RequestMapping("/search")
	public String search(Model model, @Param("keyword") String keyword){
		List<Lote> list = loteService.listAll(keyword);
		model.addAttribute("list", list);
		return "local/search";
	}

}
