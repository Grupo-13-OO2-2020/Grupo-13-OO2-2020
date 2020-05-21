package Grupo13OO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Grupo13OO2.Models.LoteModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.ILoteService;

@Controller
@RequestMapping
public class LoteController {

	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@GetMapping("/lotes")
	public ModelAndView index() {
		ModelAndView mAV=new ModelAndView(ViewRouteHelper.LOTE_INDEX);
		mAV.addObject("lotes", loteService.getAll());
		mAV.addObject("lote", new LoteModel());
		return mAV;
	}
}
