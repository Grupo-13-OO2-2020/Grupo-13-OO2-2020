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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import Grupo13OO2.Models.ProductoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("producto", new ProductoModel());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create(@ModelAttribute("producto") ProductoModel productomodel) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_FORM);
		return mAV;
	}

	@PostMapping("/save")
	public String save( @Valid @ModelAttribute("producto")ProductoModel productoModel, BindingResult result) {
		if (result.hasErrors()) {
			return ViewRouteHelper.PRODUCTO_FORM;

		}
		productoService.insertOrUpdate(productoModel);
		return "redirect:/productos";

	}

	@GetMapping("/editar/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_FORM);
		mAV.addObject("producto", productoService.ListarId(id));
		return mAV;
	}

	@GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable("id") int id) {
		productoService.delete(id);
		return new RedirectView("/productos");

	}

}
