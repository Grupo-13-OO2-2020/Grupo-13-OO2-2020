package Grupo13OO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import Grupo13OO2.Models.ClienteModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IClienteService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
	}
	
	@GetMapping("")
	public ModelAndView index(@RequestParam Map<String, Object> params, Model model){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_INDEX);
		int page =params.get("page") !=null ? (Integer.valueOf(params.get("page").toString()) -1) : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 1);
		
		Page<ClienteModel> pageCliente = clienteService.getAllPages(pageRequest);
		
		int totalPage= pageCliente.getTotalPages();
		if(totalPage>0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			mAV.addObject("pages",pages);
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		mAV.addObject("clientes", pageCliente.getContent());
		mAV.addObject("current", page+1);
		mAV.addObject("next" ,page+2);
		mAV.addObject("prev" ,page);
		mAV.addObject("last", totalPage);
		
		return mAV;
		}
	


	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_FORM);
		mAV.addObject("cliente", new ClienteModel());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		return mAV;
	}

	@PostMapping("/save")
	public String create(@Valid @ModelAttribute("cliente") ClienteModel clienteModel, BindingResult result) {
		if (result.hasErrors()) {
			return ViewRouteHelper.CLIENTE_FORM;

		}
		clienteService.insertOrUpdate(clienteModel);
		return "redirect:/clientes/0";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView get(@PathVariable("id") int id) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_FORM);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mAV.addObject("usuario", auth.getName());
		mAV.addObject("cliente", clienteService.ListarId(id));
		return mAV;
	}

	@GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable int id) {
		clienteService.delete(id);
		return new RedirectView("/clientes/0");
	}

}