package Grupo13OO2.controllers;

import java.security.Provider.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import Grupo13OO2.Entities.Producto;
import Grupo13OO2.Models.ProductoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	// @GetMapping("")
	// public ModelAndView index() {
	// 	ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
	// 	mAV.addObject("list", productoService.getAll());
	// 	mAV.addObject("producto", new ProductoModel());
	// 	return mAV;
	// }

	@GetMapping("/new")
	public ModelAndView create(@ModelAttribute("producto") ProductoModel productomodel) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_FORM);
		return mAV;
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("producto") ProductoModel productoModel, BindingResult result) {
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

	@GetMapping(value = "/")
	public String findAll(@RequestParam Map<String, Object> params, Model model){
		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) -1) : 0;
		PageRequest pageRequest = PageRequest.of(page, 3);
		Page<ProductoModel> pageProducto = productoService.getAllPages(pageRequest);
		int totalPage = pageProducto.getTotalPages();
		if(totalPage > 0){
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		model.addAttribute("list", pageProducto.getContent());

		return ViewRouteHelper.PRODUCTO_INDEX;
	}
	
	@RequestMapping("/search")
	public String search(Model model, @Param("keyword") String keyword){
		List<ProductoModel> list = productoService.listAll(keyword);
		model.addAttribute("list", list);
		return "producto/search";
	}

}
