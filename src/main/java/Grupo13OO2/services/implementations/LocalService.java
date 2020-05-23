package Grupo13OO2.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Grupo13OO2.Entities.Local;
import Grupo13OO2.Models.LocalModel;
import Grupo13OO2.converters.LocalConverter;
import Grupo13OO2.repositories.ILocalRepository;
import Grupo13OO2.services.ILocalService;

@Service("localService")
public class LocalService implements ILocalService{
	
	 @Autowired
	    private ILocalRepository localRepository;

	 @Autowired
	    @Qualifier("localConverter")
	    private LocalConverter localConverter;

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
		public LocalModel ListarId(int id) {
	        
	        Optional<Local> local = localRepository.findById(id);

			return localConverter.entityToModel(local.get());
		}
	    
	    @Override
	    public String delete(int id){
	        localRepository.deleteById(id);
	        return "Local borrada" + id;
	    }
	

}
