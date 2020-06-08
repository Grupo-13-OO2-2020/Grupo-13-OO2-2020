package Grupo13OO2.Models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Grupo13OO2.Entities.UserRole;

public class UserModel {

		private int id;
		private String username;
		private String password;
		private boolean enabled;
		private Date createdAt;
		private Date updatedAt;
		private Set<UserRole> userRoles = new HashSet<UserRole>();
		private EmpleadoModel empleadoModel;

		public UserModel() {}
		
		public UserModel(int id, String username, String password, boolean enabled, Date createdAt, Date updatedAt,
			Set<UserRole> userRoles, EmpleadoModel empleadoModel) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userRoles = userRoles;
		this.empleadoModel = empleadoModel;
	}

		public UserModel(int id, String username, String password, boolean enabled, Date createdAt, Date updatedAt,
			 EmpleadoModel empleadoModel) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.enabled = enabled;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.empleadoModel = empleadoModel;
		}
	

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Set<UserRole> getUserRoles() {
			return userRoles;
		}

		public void setUserRoles(Set<UserRole> userRoles) {
			this.userRoles = userRoles;
		}

		public EmpleadoModel getEmpleado() {
			return empleadoModel;
		}

		public void setEmpleado(EmpleadoModel empleadoModel) {
			this.empleadoModel = empleadoModel;
		}


}
