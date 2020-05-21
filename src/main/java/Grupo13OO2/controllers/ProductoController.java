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

import Grupo13OO2.Models.ProductoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IProductoService;

@Controller
@RequestMapping
public class ProductoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public ModelAndView index(){
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("producto", new ProductoModel());
		return mAV;
		}

	@GetMapping("/productos/new")
	public ModelAndView	create(@ModelAttribute("producto") ProductoModel productomodel) {
		ModelAndView mAV= new ModelAndView(ViewRouteHelper.PRODUCTO_FORM);
		return mAV;
	}
	@PostMapping("/productos/save")
	public String save(@ModelAttribute("producto") ProductoModel productoModel) {
		productoService.insertOrUpdate(productoModel);
		return "redirect:/productos";
		
	}
	
	@GetMapping("productos/editar/{id}")
	public ModelAndView edit(@ModelAttribute("producto") ProductoModel productomodel, @PathVariable int id) {
		ModelAndView mAV =new ModelAndView(ViewRouteHelper.PRODUCTO_FORM);
		ProductoModel producto= productoService.ListarId(id);
		mAV.addObject("producto",producto);
		return mAV;
	}
	@GetMapping("productos/eliminar/{id}")
	public String  delete(Model model, @PathVariable int id) {
		productoService.delete(id);
		return "redirect:/productos";
	}
	
	
}
