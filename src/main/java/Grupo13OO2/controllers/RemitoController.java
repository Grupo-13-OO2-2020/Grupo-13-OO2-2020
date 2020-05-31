package Grupo13OO2.controllers;

import javax.validation.Valid;

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

import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Models.RemitoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IClienteService;
import Grupo13OO2.services.IEmpleadoService;
import Grupo13OO2.services.IProductoService;
import Grupo13OO2.services.IRemitoService;
import org.springframework.web.bind.annotation.PostMapping;
import Grupo13OO2.services.ILoteService;
@Controller
@RequestMapping("remitos")
public class RemitoController {
	
	@Autowired
    @Qualifier("remitoService")
    private IRemitoService remitoService;

    @Autowired
    @Qualifier("productoService")
    private IProductoService productoService;

    @Autowired
    @Qualifier("empleadoService")
    private IEmpleadoService empleadoService;

    @Autowired
    @Qualifier("clienteService")
    private IClienteService clienteService;
    
    @Autowired
    @Qualifier("loteService")
    private ILoteService loteService;

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.REMITO_INDEX); 
        mAV.addObject("remitos", remitoService.getAll());
        return mAV;
    }

    @GetMapping("/new")
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.REMITO_FORM); 
        mAV.addObject("remito", new RemitoModel());
        mAV.addObject("productos", productoService.getAll());
        mAV.addObject("empleados", empleadoService.getAll());
        mAV.addObject("clientes", clienteService.getAll());
        return mAV;
    }

    @PostMapping("/save")
    public RedirectView create(@ModelAttribute("remito") RemitoModel remitoModel) {
    	 if(loteService.validarStockInterno(remitoModel.getProducto().getCodigoProducto(),remitoModel.getCantidad())) {
    		 remitoService.insertOrUpdate(remitoModel);
    		 loteService.consumirLote(remitoModel);
    		 return new RedirectView("/remitos");
    		 
    	 }else
    		 
    	 {
    		 
    		 return ViewRouteHelper.REMITO_FORM;
    	 }
        
    }

    @GetMapping("/editar/{id}")
	public ModelAndView get(@PathVariable("id") int id)  {
		
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.REMITO_FORM); 
        mAV.addObject("remito", remitoService.ListarId(id));
        mAV.addObject("productos", productoService.getAll());
        mAV.addObject("empleados", empleadoService.getAll());
        mAV.addObject("clientes", clienteService.getAll());
		return mAV;
	}

	@GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable int id) {
		remitoService.delete(id);
		return new RedirectView("/remitos");
	}
	
	    
        
           

        
    

}
