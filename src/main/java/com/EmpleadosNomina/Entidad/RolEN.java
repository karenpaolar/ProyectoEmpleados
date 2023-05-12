package com.EmpleadosNomina.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rol")
public class RolEN {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idrol;
	private String nombrerol;
	private Integer sueldorol;
	
	public RolEN(Integer idrol, String nombrerol, Integer sueldorol) {
		this.idrol = idrol;
		this.nombrerol = nombrerol;
		this.sueldorol = sueldorol;
	}
	

	public RolEN() {
		super();
	}


	public Integer getIdRol() {
		return idrol;
	}

	public void setIdRol(Integer idRol) {
		this.idrol = idRol;
	}

	public String getNombreRol() {
		return nombrerol;
	}
	
	public void setNombreRol(String nombrerol) {
		this.nombrerol = nombrerol;
	}
	
	public Integer getSueldoRol() {
		return sueldorol;
	}
	
	public void setSueldoRol(Integer sueldorol) {
		this.sueldorol = sueldorol;
	}

}
