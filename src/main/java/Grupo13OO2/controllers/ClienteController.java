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

    
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_INDEX); 
        mAV.addObject("clientes", clienteService.getAll());
        return mAV;
    }
    
    @GetMapping("/new")
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_FORM); 
        mAV.addObject("cliente", new ClienteModel());
        return mAV;
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute("cliente") ClienteModel clienteModel,BindingResult result) {
    	if (result.hasErrors()) {
			return ViewRouteHelper.CLIENTE_FORM;

		}
    	clienteService.insertOrUpdate(clienteModel);
        return "redirect:/clientes";
    }
    @GetMapping("/editar/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_FORM); 
        mAV.addObject("cliente", clienteService.ListarId(id));
		return mAV;
	}
	
    @GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable int id) {
		clienteService.delete(id);
		return new RedirectView("/clientes");
	}

}