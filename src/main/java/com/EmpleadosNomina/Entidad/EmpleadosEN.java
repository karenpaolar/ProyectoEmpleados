package com.EmpleadosNomina.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class EmpleadosEN {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idempleado;
	private String nombreempleado;
	//private Integer rolEmpleado;
	
	
	public EmpleadosEN(Integer idempleado, String nombreempleado) {
		this.idempleado = idempleado;
		this.nombreempleado = nombreempleado;
	}
	
	public EmpleadosEN() {
		super();
	}

	public Integer getIdEmpleados() {
		return idempleado;
	}
	
	public String getNombreEmpleado() {
		return nombreempleado;
	}
	
	public void setNombreEmpleado(String nombreempleado) {
		this.nombreempleado = nombreempleado;
	}

	public void setIdEmpleado(Integer idempleado) {
		this.idempleado = idempleado;
		
	}
	
	/*public Integer getRolEmpleado() {
		return rolEmpleado;
	}
	
	public void setRolEmpleado(Integer rolEmpleado) {
		this.rolEmpleado = rolEmpleado;
	}*/
}
