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

import Grupo13OO2.Models.RemitoModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IClienteService;
import Grupo13OO2.services.IEmpleadoService;
import Grupo13OO2.services.ILocalService;
import Grupo13OO2.services.IProductoService;
import Grupo13OO2.services.IRemitoService;

import org.springframework.web.bind.annotation.PostMapping;
import Grupo13OO2.services.ILoteService;

@Controller
@RequestMapping("remitos")
public class RemitoController {
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;

	@Autowired
	@Qualifier("remitoService")
	private IRemitoService remitoService;

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;

	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;

	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.REMITO_INDEX);
		mAV.addObject("remitos", remitoService.getAll());
		return mAV;
	}

	@GetMapping("{id}")
	public ModelAndView local(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.REMITO_INDEX_LOCAL);
		mAV.addObject("remitos", localService.getRemitos(localService.findById(id)));
		mAV.addObject("local", localService.findById(id));
		return mAV;
	}

	@GetMapping("/new/{id}")
	public ModelAndView create(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.REMITO_FORM);
		mAV.addObject("local", localService.findById(id));
		mAV.addObject("remito", new RemitoModel());
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("empleados", empleadoService.getAll());
		mAV.addObject("clientes", clienteService.getAll());
		return mAV;
	}

	@PostMapping("/save")
	public RedirectView create(@ModelAttribute("remito") RemitoModel remitoModel) {
		remitoModel.setVendedor(empleadoService.ListarId(remitoModel.getVendedor().getId()));
		remitoModel.setProducto(productoService.ListarId(remitoModel.getProducto().getId()));

		if (localService.validarStockLocal(remitoModel.getProducto().getCodigoProducto(), remitoModel.getCantidad(),
				remitoModel.getVendedor().getLocal().getId())) {
			remitoService.insertOrUpdate(remitoModel);
			localService.consumirLote(remitoModel);
			return new RedirectView("/remitos");

		} else

		{

			return new RedirectView("/remitos");
		}

	}

	@GetMapping("/editar/{id}")
	public ModelAndView get(@PathVariable("id") int id) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.REMITO_FORM);
		mAV.addObject("remito", remitoService.ListarId(id));
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("empleados", empleadoService.getAll());
		mAV.addObject("clientes", clienteService.getAll());
		return mAV;
	}

	@GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable int id) {
		remitoService.delete(id);
		return new RedirectView("/remitos");
	}

}
