package com.EmpleadosNomina.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
public class ENRol {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrol;
	
	@Column(name = "nombrerol")
	private String nombrerol;
	
	@Column(name = "sueldorol")
	private Integer sueldorol;
	
	

	public ENRol() {
		
	}

	public ENRol(Long idrol, String nombrerol, Integer sueldorol) {
		
		this.idrol = idrol;
		this.nombrerol = nombrerol;
		this.sueldorol = sueldorol;
	}
	
	public ENRol( String nombrerol, Integer sueldorol) {
		this.nombrerol = nombrerol;
		this.sueldorol = sueldorol;
	}
	
	
	
	public Long getIdrol() {
		return idrol;
	}

	
	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	
	public String getNombrerol() {
		return nombrerol;
	}

	
	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}

	
	public Integer getSueldorol() {
		if (sueldorol == null) {
			sueldorol = 0; 
		}else {
			this.sueldorol = sueldorol;
		}
		
		return sueldorol;
	}

	
	public void setSueldorol(Integer sueldorol) {
		this.sueldorol = sueldorol;
	}
	
	
}
