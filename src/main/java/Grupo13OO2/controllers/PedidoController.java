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

import Grupo13OO2.Models.PedidoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IPedidoService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping
public class PedidoController {
	
	@Autowired
    @Qualifier("pedidoService")
    private IPedidoService pedidoService;

    @GetMapping("/pedido")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_INDEX); 
        mAV.addObject("pedido", pedidoService.getAll());
        mAV.addObject("pedido", new PedidoModel());
        return mAV;
    }
    
    @GetMapping("/pedido/new")
    public ModelAndView create(@ModelAttribute("pedido") PedidoModel pedidoModel) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_FORM); 
        return mAV;
    }

    @PostMapping("/pedido/save")
    public String save(@ModelAttribute("pedido") PedidoModel pedidoModel) {
        pedidoService.insertOrUpdate(pedidoModel);
        return "redirect:/pedido";
    }



    @GetMapping("/pedido/editar/{id}")
	public ModelAndView ModelAndView( @ModelAttribute("pedido") PedidoModel pedidoModel, @PathVariable int id) {
		
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_FORM); 
        PedidoModel pedido = pedidoService.ListarId(id);
        mAV.addObject("pedido", pedido);
		return mAV;
	}
	
	@GetMapping("/pedido/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		pedidoService.delete(id);
		return "redirect:/pedido";
		
		
	}


}
