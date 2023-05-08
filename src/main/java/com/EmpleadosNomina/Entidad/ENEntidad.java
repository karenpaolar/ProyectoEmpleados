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
	
	@Column(name = "sueldoBase")
	private Float sueldoBase;
	
	@Column(name = "entrega")
	private Long entrega;
	
	@Column(name = "bonoPuesto")
	private Float bonoPuesto;
	
	@Column(name = "impuesto")
	private Float impuesto;
	
	@Column(name = "impuestoExtra")
	private Float impuestoExtra;
	
	@Column(name = "sueldoTotal")
	private Float sueldoTotal;
	
	
	
	
	


	public ENEntidad(Long id, String nombre, String roll, Float sueldoBase, Long entrega, Float bonoPuesto,
			Float impuesto, Float impuestoExtra, Float sueldoTotal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.roll = roll;
		this.sueldoBase = sueldoBase;
		this.entrega = entrega;
		this.bonoPuesto = bonoPuesto;
		this.impuesto = impuesto;
		this.impuestoExtra = impuestoExtra;
		this.sueldoTotal = sueldoTotal;
		
		
	}

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

	/**
	 * @return the sueldoBase
	 */
	public Float getSueldoBase() {
		return sueldoBase;
	}

	/**
	 * @param sueldoBase the sueldoBase to set
	 */
	public void setSueldoBase(Float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	/**
	 * @return the entrega
	 */
	public Long getEntrega() {
		return entrega;
	}

	/**
	 * @param entrega the entrega to set
	 */
	public void setEntrega(Long entrega) {
		this.entrega = entrega;
	}

	/**
	 * @return the bonoPuesto
	 */
	public Float getBonoPuesto() {
		return bonoPuesto;
	}

	/**
	 * @param bonoPuesto the bonoPuesto to set
	 */
	public void setBonoPuesto(Float bonoPuesto) {
		this.bonoPuesto = bonoPuesto;
	}

	/**
	 * @return the impuesto
	 */
	public Float getImpuesto() {
		return impuesto;
	}

	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	/**
	 * @return the impuestoExtra
	 */
	public Float getImpuestoExtra() {
		return impuestoExtra;
	}

	/**
	 * @param impuestoExtra the impuestoExtra to set
	 */
	public void setImpuestoExtra(Float impuestoExtra) {
		this.impuestoExtra = impuestoExtra;
	}

	/**
	 * @return the sueldoTotal
	 */
	public Float getSueldoTotal() {
		return sueldoTotal;
	}

	/**
	 * @param sueldoTotal the sueldoTotal to set
	 */
	public void setSueldoTotal(Float sueldoTotal) {
		this.sueldoTotal = sueldoTotal;
	}
	
	
	@Override
	public String toString() {
		return "ENEntidad [id=" + id + ", nombre=" + nombre + ", roll=" + roll + ", sueldoBase=" + sueldoBase
				+ ", entrega=" + entrega + ", bonoPuesto=" + bonoPuesto + ", impuesto=" + impuesto + ", impuestoExtra="
				+ impuestoExtra + ", sueldoTotal=" + sueldoTotal + "]";
	}

	
	
}
