package Grupo13OO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.helpers.ViewRouteHelper;
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
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV=new ModelAndView(ViewRouteHelper.LOTE_INDEX);
		mAV.addObject("lotes", loteService.getAll());
		mAV.addObject("lote", new LoteModel());
		return mAV;
	}
	
	 @GetMapping("/new")
	    public ModelAndView create() {
	        ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_FORM); 
        //mAV.addObject("local", localService.ListarId(id));
	        mAV.addObject("lote", new LoteModel());
	        mAV.addObject("productos", productoService.getAll());
	        return mAV;
	    }
	

	    @PostMapping("/save")
	    public RedirectView create(@ModelAttribute("lote") LoteModel loteModel) {
	    	loteService.insertOrUpdate(loteModel);
	        return new RedirectView("/lotes");
	    }
	    
	    
	    
	    @GetMapping("/editar/{id}")
		public ModelAndView get(@PathVariable("id") int id) {
			ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_FORM); 
			mAV.addObject("lote", loteService.ListarId(id));
			mAV.addObject("productos", productoService.getAll());
			return mAV;
		}
		
	    @GetMapping("/eliminar/{id}")
		public RedirectView delete (Model model,@PathVariable("id") int id) {
			loteService.delete(id);
			return new RedirectView("/lotes");
		}
	
	
	
	
	
}
