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


import Grupo13OO2.Models.SolicitudStockModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.ISolicitudStockService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping
public class SolicitudStockController {
	
	@Autowired
    @Qualifier("solicitudStockService")
    private ISolicitudStockService solicitudStockService;

    @GetMapping("/solicitudStock")
    public ModelAndView index(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.SOLICITUDSTOCK_INDEX); 
        mAV.addObject("solicitudStock", solicitudStockService.getAll());
        mAV.addObject("solicitudStock", new SolicitudStockModel());
        return mAV;
    }
    
    @GetMapping("/solicitudStock/new")
    public ModelAndView create(@ModelAttribute("solicitudStock") SolicitudStockModel solicitudStockModel) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.SOLICITUDSTOCK_FORM); 
        return mAV;
    }

    @PostMapping("/solicitudStock/save")
    public String save(@ModelAttribute("solicitudStock") SolicitudStockModel solicitudStockModel) {
    	solicitudStockService.insertOrUpdate(solicitudStockModel);
        return "redirect:/solicitudStock";
    }



    @GetMapping("/solicitudStock/editar/{id}")
	public ModelAndView ModelAndView( @ModelAttribute("solicitudStock") SolicitudStockModel solicitudStockModel, @PathVariable int id) {
		
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.SOLICITUDSTOCK_FORM); 
        SolicitudStockModel solicitudStock = solicitudStockService.ListarId(id);
        mAV.addObject("solicitudStock", solicitudStock);
		return mAV;
	}
	
	@GetMapping("/solicitudStock/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		solicitudStockService.delete(id);
		return "redirect:/personas";
		
		
	}


}
