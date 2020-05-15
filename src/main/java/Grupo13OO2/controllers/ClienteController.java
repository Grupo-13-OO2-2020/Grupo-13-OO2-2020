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

import Grupo13OO2.Models.ClienteModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IClienteService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping
public class ClienteController {
    @Autowired
    @Qualifier("clienteService")
    private IClienteService clienteService;

    
    @GetMapping("/clientes")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_INDEX); 
        mAV.addObject("clientes", clienteService.getAll());
        mAV.addObject("cliente", new ClienteModel());
        return mAV;
    }
    
    @GetMapping("/clientes/new")
    public ModelAndView create(@ModelAttribute("cliente") ClienteModel clienteModel) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_FORM); 
        return mAV;
    }

    @PostMapping("/clientes/save")
    public String save(@ModelAttribute("cliente") ClienteModel clienteModel) {
        clienteService.insertOrUpdate(clienteModel);
        return "redirect:/clientes";
    }
    @GetMapping("/clientes/editar/{id}")
	public ModelAndView ModelAndView( @ModelAttribute("cliente") ClienteModel clienteModel, @PathVariable int id) {
		
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENTE_FORM); 
        ClienteModel cliente = clienteService.ListarId(id);
        mAV.addObject("cliente", cliente);
		return mAV;
	}
	
	@GetMapping("/clientes/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		clienteService.delete(id);
		return "redirect:/clientes";
	}

}