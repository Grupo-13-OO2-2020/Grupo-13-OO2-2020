package Grupo13OO2.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import Grupo13OO2.Models.ProductoMasVendidoModel;
import Grupo13OO2.Models.RemitoModel;
import Grupo13OO2.Models.SolicitudStockModel;
import Grupo13OO2.helpers.ViewRouteHelper;
import Grupo13OO2.services.IPedidoService;
import Grupo13OO2.services.IRemitoService;
import Grupo13OO2.services.ISolicitudStockService;

@Controller
@RequestMapping("/Productomasvendido")
public class ProductoMasVendidoController {

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@Autowired
	@Qualifier("remitoService")
	private IRemitoService remitoService;

	@Autowired
	@Qualifier("solicitudStockService")
	private ISolicitudStockService solicitudStockService;

	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.MASVENDIDO_INDEX);
		List<ProductoMasVendidoModel> PMasVendido = ProdMasVend(remitoService.getAll(),solicitudStockService.getAll());
		mAV.addObject("prodmasVendido", PMasVendido);
		return mAV;
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.MASVENDIDO_INDEX);
		List<ProductoMasVendidoModel> PdtMVendido = ProdMasVend(remitoService.getAll(),solicitudStockService.getAll());
		mAV.addObject("prodmasVendido", PdtMVendido);
		return mAV;
	}

	@PostMapping("")
	public RedirectView redirect(
			@ModelAttribute("Productomasvendido") ProductoMasVendidoModel ProductoMasVendidoModel) {
		return new RedirectView(ViewRouteHelper.MASVENDIDO_INDEX);
	}

	public List<ProductoMasVendidoModel> ProdMasVend(List<RemitoModel> remitos, List<SolicitudStockModel> solicitudes) {

		List<ProductoMasVendidoModel> PdtV = new ArrayList<ProductoMasVendidoModel>();

		Map<String, Integer> PMasVendido = new HashMap<String, Integer>();

		for (RemitoModel pedido : remitos) {
			if (!PMasVendido.containsKey(pedido.getProducto().getDescripcion())) {
				PMasVendido.put(pedido.getProducto().getDescripcion(), pedido.getCantidad());
			} else {
				PMasVendido.replace(pedido.getProducto().getDescripcion(),
						PMasVendido.get(pedido.getProducto().getDescripcion()) + pedido.getCantidad());
			}
		}

		for (SolicitudStockModel pedido : solicitudes) {
			if (pedido.isAceptado()) {
				if (!PMasVendido.containsKey(pedido.getProducto().getDescripcion())) {
					PMasVendido.put(pedido.getProducto().getDescripcion(), pedido.getCantidad());
				} else {
					PMasVendido.replace(pedido.getProducto().getDescripcion(),
							PMasVendido.get(pedido.getProducto().getDescripcion()) + pedido.getCantidad());
				}
			}
		}

		for (String clave : PMasVendido.keySet()) {
			PdtV.add(new ProductoMasVendidoModel(clave, PMasVendido.get(clave)));
		}

		Collections.sort(PdtV,
				Collections.reverseOrder(Comparator.comparing(ProductoMasVendidoModel::getCantidadProductosVendidos)));

		return PdtV;

	}

}
