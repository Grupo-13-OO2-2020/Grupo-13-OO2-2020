package Grupo13OO2.services.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Local;
import Grupo13OO2.Entities.Lote;
import Grupo13OO2.Entities.SolicitudStock;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.Models.SolicitudStockModel;
import Grupo13OO2.converters.LocalConverter;
import Grupo13OO2.converters.LoteConverter;
import Grupo13OO2.converters.SolicitudStockConverter;
import Grupo13OO2.repositories.ILocalRepository;
import Grupo13OO2.repositories.ILoteRepository;
import Grupo13OO2.services.ILocalService;

@Service("localService")
public class LocalService implements ILocalService{
	
	 @Autowired
	    private ILocalRepository localRepository;

	 @Autowired
	    @Qualifier("localConverter")
	    private LocalConverter localConverter;

	 	@Autowired
		@Qualifier("loteConverter")
		private LoteConverter loteConverter;
		@Autowired
		private ILoteRepository loteRepository;

		@Autowired
		@Qualifier("solicitudStockService")
		private SolicitudStockService solicitudStockService; 

		@Autowired
		@Qualifier("solicitudStockConverter")
		private SolicitudStockConverter solicitudStockConverter;

	 
	    @Override
	    public List<Local> getAll(){
	        return localRepository.findAll();
	    }

		@Override
	    public LocalModel insertOrUpdate(LocalModel localModel){
	    	
	        Local local = localRepository.save(localConverter.modelToEntity(localModel));
	        return localConverter.entityToModel(local);
	    }

	    @Override
		public LocalModel findById(int id) {

			return localConverter.entityToModel(localRepository.findById(id));
		}
	    
	    @Override
	    public String delete(int id){
	        localRepository.deleteById(id);
	        return "Local borrada" + id;
	    }
	
		@Override
		public List<SolicitudStockModel> getSolicitudesStock(LocalModel localModel) {
			List<SolicitudStockModel> solicitudesM = new ArrayList<SolicitudStockModel>();

			for (SolicitudStock solicitudStock : solicitudStockService.getAll()) {
				if(solicitudStock.getLocalDestinatario().getId() == localModel.getId()){
					solicitudesM.add(solicitudStockConverter.entityToModel(solicitudStock));
				}
			}
			
			return solicitudesM;
		}
}
