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

import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.ILocalService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping
public class LocalController {
	
	  @Autowired
	    @Qualifier("localService")
	    private ILocalService localService;
	  
	  @GetMapping("/locales")
	    public ModelAndView index(){
	        ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_INDEX); 
	        mAV.addObject("locales", localService.getAll());
	        mAV.addObject("local", new LocalModel());
	        return mAV;
	    }
	  
	  @GetMapping("/locales/new")
	    public ModelAndView create(@ModelAttribute("local") LocalModel localModel) {
	        ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_FORM); 
	        return mAV;
	    }
	  
	  @PostMapping("/locales/save")
	    public String save(@ModelAttribute("local") LocalModel localModel) {
	        localService.insertOrUpdate(localModel);
	        return "redirect:/locales";
	    }
	  @GetMapping("/locales/editar/{id}")
		public ModelAndView ModelAndView( @ModelAttribute("cliente") LocalModel localModel, @PathVariable int id) {
			
	        ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_FORM); 
	        LocalModel local = localService.ListarId(id);
	        mAV.addObject("local", local);
			return mAV;
		}
		
		@GetMapping("/locales/eliminar/{id}")
		public String delete(Model model, @PathVariable int id) {
			localService.delete(id);
			return "redirect:/locales";
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
	  
	  @PostMapping("/locales/distancia")
	  public double distancia(@ModelAttribute("local")LocalModel a,@ModelAttribute("local")LocalModel b) {
		  double total;
		  total=distanciaCoord(a.getLatitud(),a.getLongitud(),b.getLatitud(),b.getLongitud());
		  return total;
	  }
	  

}
