package com.EmpleadosNomina.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleados")
public class ENEntidad {

	


	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "roll", nullable = false, length = 50)
	private String roll;
	
	
	public ENEntidad() {
	
	}

	public ENEntidad(Long id, String nombre, String roll) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.roll = roll;
	}
	
	public ENEntidad(String nombre, String roll) {
		super();
		this.nombre = nombre;
		this.roll = roll;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the roll
	 */
	public String getRoll() {
		return roll;
	}

	/**
	 * @param roll the roll to set
	 */
	public void setRoll(String roll) {
		this.roll = roll;
	}
	
	
	@Override
	public String toString() {
		return "ENEntidad [id=" + id + ", nombre=" + nombre + ", roll=" + roll + "]";
	}
	
	
	
	
}
