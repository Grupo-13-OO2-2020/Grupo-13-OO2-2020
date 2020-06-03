package Grupo13OO2.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import Grupo13OO2.Models.PersonaModel;
import Grupo13OO2.Models.ProductoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IPersonaService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping
public class PersonaController {
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;

	@GetMapping("/personas")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSONA_INDEX);
		mAV.addObject("personas", personaService.getAll());
		mAV.addObject("persona", new PersonaModel());
		return mAV;
	}

<<<<<<< HEAD
	@GetMapping("/personas/new")
	public ModelAndView create(@ModelAttribute("persona") PersonaModel personaModel) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSONA_FORM);
		return mAV;
	}

	@PostMapping("/personas/save")
	public String save(@Valid @ModelAttribute("persona") PersonaModel personaModel, BindingResult result) {
		if (result.hasErrors()) {
			return ViewRouteHelper.PERSONA_FORM;

		}
		personaService.insertOrUpdate(personaModel);
		return "redirect:/personas";
	}

	@GetMapping("/personas/editar/{id}")
	public ModelAndView ModelAndView(@ModelAttribute("persona") PersonaModel personaModel, @PathVariable int id) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSONA_FORM);
		PersonaModel persona = personaService.ListarId(id);
		mAV.addObject("persona", persona);
=======
//    @PostMapping("/personas/save")
//    public String save( @Valid @ModelAttribute("persona") PersonaModel personaModel, BindingResult result) {
//    	if (result.hasErrors()) {
//			return ViewRouteHelper.PERSONA_FORM;
//
//		}
//    	
//        personaService.insertOrUpdate(personaModel);
//        return "redirect:/personas";

    @PostMapping("/personas/save")
    public String save(@ModelAttribute("persona") PersonaModel personaModel) {
        personaService.insertOrUpdate(personaModel);
        return "redirect:/personas";
    }

    @GetMapping("/personas/editar/{id}")
	public ModelAndView ModelAndView( @ModelAttribute("persona") PersonaModel personaModel, @PathVariable int id) {
		
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSONA_FORM); 
        PersonaModel persona = personaService.ListarId(id);
        mAV.addObject("persona", persona);
>>>>>>> 25e12ba... pequeños cambios de vistas distancias y otros
		return mAV;
	}

	@GetMapping("/personas/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		personaService.delete(id);
		return "redirect:/personas";

	}

}