package Grupo13OO2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import Grupo13OO2.Entities.User;
import Grupo13OO2.Models.UserModel;

@Component("userConverter")
public class UserConverter {

	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	public UserModel entityToModel(User user) {
		return new UserModel(user.getId(), user.getUsername(), user.getPassword(), user.isEnabled(),
				user.getCreatedAt(), user.getUpdatedAt(), empleadoConverter.entityToModel(user.getEmpleado()));
	}
	
	public User modelToEntity(UserModel userModel) {
		return new User(userModel.getId(),userModel.getUsername(),userModel.getPassword(),userModel.isEnabled(),userModel.getCreatedAt(),
				userModel.getUpdatedAt(), empleadoConverter.modelToEntity(userModel.getEmpleado()));
	}

}
