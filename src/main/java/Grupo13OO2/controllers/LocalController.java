package Grupo13OO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import Grupo13OO2.Models.EmpleadoModel;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.LocalesModels;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.ILocalService;
import Grupo13OO2.services.ILoteService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/locales")
public class LocalController {

	@Autowired
	@Qualifier("localService")
	private ILocalService localService;

	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;

	@GetMapping("")
	public ModelAndView index(@RequestParam Map<String, Object> params, Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_INDEX);
		int page =params.get("page") !=null ? (Integer.valueOf(params.get("page").toString()) -1) : 0;
		
		PageRequest pageRequest = PageRequest.of(page, 5);
		
		Page<LocalModel> pageLocal = localService.getAllPages(pageRequest);
		
		int totalPage= pageLocal.getTotalPages();
		if(totalPage>0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			mAV.addObject("pages",pages);
		}
		mAV.addObject("locales", pageLocal.getContent());
		mAV.addObject("current", page+1);
		mAV.addObject("next" ,page+2);
		mAV.addObject("prev" ,page);
		mAV.addObject("last", totalPage);
		
		return mAV;
	}

	@GetMapping("/main/{id}")
	public ModelAndView main(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_MAIN);
		mAV.addObject("local", localService.findById(id));
		mAV.addObject("locales", localService.getAll());
		
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_FORM);
		mAV.addObject("local", new LocalModel());
		return mAV;
	}

	@PostMapping("/save")
	public String create(@Valid @ModelAttribute("local") LocalModel localModel, BindingResult result) {
		if (result.hasErrors()) {
			return ViewRouteHelper.LOCAL_FORM;

		}
		localService.insertOrUpdate(localModel);

		return ViewRouteHelper.LOCAL_INDEX;
	}

	@GetMapping("/editar/{id}")
	public ModelAndView get(@PathVariable("id") int id) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_FORM);
		mAV.addObject("local", localService.findById(id));
		return mAV;
	}

	@GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable("id") int id) {
		localService.delete(id);
		return new RedirectView("/locales");
	}

	@GetMapping("/calculacoordenadas")
	public ModelAndView calculacoordenadas() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOCAL_CALC_COORD);
		mAV.addObject("locales", localService.getAll());

		return mAV;
	}

	public double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
		double radioTierra = 6371; // en kilómetros
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		return radioTierra * va2;
	}

	@RequestMapping(value = "/obtenerdistancia", method = RequestMethod.POST)
	public ModelAndView sacardistancia(LocalesModels locales, Model model) {

		model.addAttribute("lat1", localService.findById(locales.getPrimerLocal().getId()).getLatitud());
		model.addAttribute("lng1", localService.findById(locales.getPrimerLocal().getId()).getLongitud());
		model.addAttribute("dir1", localService.findById(locales.getPrimerLocal().getId()).getDireccion());

		model.addAttribute("lat2", localService.findById(locales.getSegundoLocal().getId()).getLatitud());
		model.addAttribute("lng2", localService.findById(locales.getSegundoLocal().getId()).getLongitud());
		model.addAttribute("dir2", localService.findById(locales.getSegundoLocal().getId()).getDireccion());

		ModelAndView mAV = new ModelAndView("local/dameDistancia");
		double distancia = distanciaCoord(localService.findById(locales.getPrimerLocal().getId()).getLatitud(),
				localService.findById(locales.getPrimerLocal().getId()).getLongitud(),
				localService.findById(locales.getSegundoLocal().getId()).getLatitud(),
				localService.findById(locales.getSegundoLocal().getId()).getLongitud());
		model.addAttribute("distancia", Math.round(distancia * 100) / 100.00);
		return mAV;
	}

}
