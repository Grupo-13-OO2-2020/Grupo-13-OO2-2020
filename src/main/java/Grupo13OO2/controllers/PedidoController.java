package Grupo13OO2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;


import Grupo13OO2.Entities.Pedido;
import Grupo13OO2.Models.PedidoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IClienteService;
import Grupo13OO2.services.IEmpleadoService;
import Grupo13OO2.services.IPedidoService;
import Grupo13OO2.services.IProductoService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("pedidos")
public class PedidoController {

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;

	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_INDEX);
		mAV.addObject("pedidos", pedidoService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_FORM);
		mAV.addObject("pedido", new PedidoModel());
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("empleados", empleadoService.getAll());
		mAV.addObject("clientes", clienteService.getAll());
		return mAV;
	}

	@PostMapping("/save")
	public String create(@Valid @ModelAttribute("pedido") PedidoModel pedidoModel, BindingResult result) {
		if (result.hasErrors()) {
			return ViewRouteHelper.PEDIDO_FORM;

		}
		pedidoService.insertOrUpdate(pedidoModel);
		return "/pedidos";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView get(@PathVariable("id") int id) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_FORM);
		mAV.addObject("pedido", pedidoService.ListarId(id));
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("empleados", empleadoService.getAll());
		mAV.addObject("clientes", clienteService.getAll());
		return mAV;
	}

	@GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable("id") int id) {
		pedidoService.delete(id);
		return new RedirectView("/pedidos");
	}
	
	@RequestMapping("/search")
	public String search(Model model, @Param("keyword") String keyword){
		List<Pedido> list = pedidoService.listAll(keyword);
		model.addAttribute("list", list);
		return "pedido/search";
	}


}
