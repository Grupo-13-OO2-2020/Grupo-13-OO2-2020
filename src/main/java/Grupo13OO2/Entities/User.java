package Grupo13OO2.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

    
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;

	@Column(name = "password", unique = true, nullable = false, length = 60)
	private String password;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "createdat")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "updatedat")
	@UpdateTimestamp
	private Date updatedAt;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	

	@OneToOne(cascade = CascadeType.MERGE)
	private Empleado empleado;


	public User() {

	}

	public User(int id, String username, String password, boolean enabled, Date createdAt, Date updatedAt,
			Set<UserRole> userRoles, Empleado empleado) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userRoles = userRoles;
		this.empleado = empleado;
	}
	
	public User(int id, String username, String password, boolean enabled, Date createdAt, Date updatedAt, Empleado empleado) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.empleado = empleado;
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
	

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}

	
}
