package Grupo13OO2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.SolicitudStockModel;
import Grupo13OO2.converters.SolicitudStockConverter;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IClienteService;
import Grupo13OO2.services.IEmpleadoService;
import Grupo13OO2.services.ILocalService;
import Grupo13OO2.services.IProductoService;
import Grupo13OO2.services.ISolicitudStockService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/solicitudesStock")
public class SolicitudStockController {
	@Autowired
	@Qualifier("solicitudStockConverter")
	private SolicitudStockConverter solicitudStockConverter;

	@Autowired
	@Qualifier("solicitudStockService")
	private ISolicitudStockService solicitudStockService;

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
	@Qualifier("localService")
	private ILocalService localService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SOLICITUDSTOCK_INDEX);
		mAV.addObject("solicitudesStock", solicitudStockService.getAll());
		return mAV;
	}

	@GetMapping("{id}")
	public ModelAndView local(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SOLICITUDSTOCK_INDEX_LOCAL);
		mAV.addObject("solicitudes", localService.getSolicitudesStock(localService.findById(id)));
		mAV.addObject("local", localService.findById(id));
		return mAV;
	}

	@GetMapping("/new/{id}")
	public ModelAndView create(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SOLICITUDSTOCK_FORM);
		mAV.addObject("local", localService.findById(id));
		mAV.addObject("solicitudStock", new SolicitudStockModel());
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("clientes", clienteService.getAll());
		mAV.addObject("locales", localService.getAll());
		return mAV;
	}

	@PostMapping("/save")
	public RedirectView create(@ModelAttribute("solicitudStock") SolicitudStockModel solicitudStockModel) {

		solicitudStockService.insertOrUpdate(solicitudStockModel);
		if (solicitudStockModel.isAceptado()) {
			localService.consumirLoteSolicitud(solicitudStockModel);
		}
		return new RedirectView("/solicitudesStock");
	}

	@GetMapping("/editar/{id}")
	public ModelAndView get(@PathVariable("id") int id) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SOLICITUDSTOCK_FORM_LOCAL);
		SolicitudStockModel solicitudStockModel = solicitudStockService.ListarId(id);
		mAV.addObject("solicitudStock", solicitudStockModel);
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("clientes", clienteService.getAll());
		mAV.addObject("locales", localService.getAll());
		mAV.addObject("local", localService.findById(solicitudStockModel.getVendedor().getLocal().getId()));
		return mAV;
	}

	@GetMapping("/eliminar/{id}")
	public RedirectView delete(Model model, @PathVariable int id) {
		solicitudStockService.delete(id);
		return new RedirectView("/solicitudesStock");
	}

	@GetMapping("/localesDestinatarios")
	public @ResponseBody List<LocalModel> localesDestinatarios(int idProducto, int idVendedor, int cantidad) {
		List<LocalModel> locales = solicitudStockService.getLocalesCercanos(idProducto, idVendedor, cantidad);
		return locales;
	}
}
