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


import Grupo13OO2.Models.RemitoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IRemitoService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping
public class RemitoController {
	
	@Autowired
    @Qualifier("remitoService")
    private IRemitoService remitoService;

    @GetMapping("/remito")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.REMITO_INDEX); 
        mAV.addObject("remito", remitoService.getAll());
        mAV.addObject("remito", new RemitoModel());
        return mAV;
    }
    
    @GetMapping("/remito/new")
    public ModelAndView create(@ModelAttribute("remito") RemitoModel remitoModel) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.REMITO_FORM); 
        return mAV;
    }

    @PostMapping("/remito/save")
    public String save(@ModelAttribute("remito") RemitoModel remitoModel) {
        remitoService.insertOrUpdate(remitoModel);
        return "redirect:/remito";
    }



    @GetMapping("/remito/editar/{id}")
	public ModelAndView ModelAndView( @ModelAttribute("remito") RemitoModel remitoModel, @PathVariable int id) {
		
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.REMITO_FORM); 
        RemitoModel remito = remitoService.ListarId(id);
        mAV.addObject("remito", remito);
		return mAV;
	}
	
	@GetMapping("/remito/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		remitoService.delete(id);
		return "redirect:/remito";
		
		
	}


}
