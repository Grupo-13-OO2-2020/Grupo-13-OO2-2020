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

import Grupo13OO2.Models.ClienteModel;
import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IEmpleadoService;
import Grupo13OO2.services.ILocalService;
import Grupo13OO2.services.ILoteService;
import Grupo13OO2.services.IProductoService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/locales")
public class LocalController {
	
	  	@Autowired
	    @Qualifier("localService")
	    private ILocalService localService;
	  	
	  	@Autowired
	    @Qualifier("empleadoService")
	    private IEmpleadoService empleadoService;
	  	
	  	@Autowired
		@Qualifier("loteService")
		private ILoteService loteService;

	  
	  @GetMapping("")
	    public ModelAndView index(){
	        ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_INDEX); 
	        mAV.addObject("locales", localService.getAll());
	        return mAV;
	    }
	  
	  @GetMapping("/main/{id}")
	    public ModelAndView main(@PathVariable("id") int id){
	        ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_MAIN); 
	        mAV.addObject("local", localService.ListarId(id));
	        mAV.addObject("lotes", loteService.getAll());
	        return mAV;
	    }
	
	    
	    @GetMapping("/new")
	    public ModelAndView create() {
	        ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_FORM); 
	        mAV.addObject("local", new LocalModel());
	        return mAV;
	    }

	    @PostMapping("/save")
	    public RedirectView create(@ModelAttribute("local") LocalModel localModel) {
	    	localService.insertOrUpdate(localModel);
	        return new RedirectView("/locales");
	    }
	    @GetMapping("/editar/{id}")
		public ModelAndView get(@PathVariable("id") int id) {
			
	        ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_FORM); 
	        mAV.addObject("local", localService.ListarId(id));
			return mAV;
		}
		
	    @GetMapping("/eliminar/{id}")
		public RedirectView delete (Model model,@PathVariable("id") int id) {
			localService.delete(id);
			return new RedirectView("/locales");
		}
		
	  public static double distanciaCoord( double lat1 , double lng1 , double lat2 , double lng2 ) {
		  double radioTierra = 6371; // en kilómetros
		  double dLat = Math. toRadians ( lat2 - lat1 );
		  double dLng = Math. toRadians ( lng2 - lng1 );
		  double sindLat = Math. sin ( dLat / 2);
		  double sindLng = Math. sin ( dLng / 2);
		  double va1 = Math. pow ( sindLat , 2)
		  + Math. pow ( sindLng , 2) * Math. cos (Math. toRadians ( lat1 )) * Math. cos (Math. toRadians ( lat2 ));
		  double va2 = 2 * Math. atan2 (Math. sqrt ( va1 ), Math. sqrt (1 - va1 ));
		  return radioTierra * va2 ;
		  }
	 

}
