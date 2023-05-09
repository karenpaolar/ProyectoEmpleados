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

	@Column(name = "rol", nullable = false, length = 50)
	private String rol;

	@Column(name = "sueldoBase")
	private double sueldoBase;

	@Column(name = "entrega")
	private Long entrega;

	@Column(name = "entregaSaldo")
	private double entregaSaldo;

	@Column(name = "bonoPuesto")
	private double bonoPuesto;

	@Column(name = "impuesto")
	private double impuesto;

	@Column(name = "impuestoExtra")
	private double impuestoExtra;

	@Column(name = "sueldoTotal")
	private double sueldoTotal;

	public ENEntidad(Long id, String nombre, String rol, double sueldoBase, Long entrega, double entregaSaldo,
			double bonoPuesto, double impuesto, double impuestoExtra, double sueldoTotal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rol = rol;
		this.sueldoBase = sueldoBase;
		this.entrega = entrega;
		this.entregaSaldo = entregaSaldo;
		this.bonoPuesto = bonoPuesto;
		this.impuesto = impuesto;
		this.impuestoExtra = impuestoExtra;
		this.sueldoTotal = sueldoTotal;
	}

	public ENEntidad() {

	}

	public ENEntidad(String nombre, String rol) {
		super();
		this.nombre = nombre;
		this.rol = rol;
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
	public String getRol() {
		return rol;
	}

	/**
	 * @param roll the roll to set
	 */
	public void setRol(String roll) {
		this.rol = roll;
	}

	/**
	 * @return the sueldoBase
	 */
	public double getSueldoBase() {
		sueldoBase = 1440 * 4;
		return sueldoBase;
	}

	/**
	 * @param sueldoBase the sueldoBase to set
	 */
	public void setSueldoBase(double sueldoBase) {
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
	public double getBonoPuesto() {
		if (rol.equals("Chofer")) {
			bonoPuesto = 10 * 8 * 6 * 4;

		} else if (rol.equals("Cargador")) {
			bonoPuesto = 5 * 8 * 6 * 4;

		} else {
			bonoPuesto = 0;
		}

		return bonoPuesto;
	}

	/**
	 * @param bonoPuesto the bonoPuesto to set
	 */
	public void setBonoPuesto(double bonoPuesto) {
		this.bonoPuesto = bonoPuesto;
	}

	/**
	 * @return the impuesto
	 */
	public double getImpuesto() {
		impuesto = (sueldoBase * 9) / 100;
		return impuesto;
	}

	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	/**
	 * @return the impuestoExtra
	 */
	public double getImpuestoExtra() {
		return impuestoExtra;
	}

	/**
	 * @param impuestoExtra the impuestoExtra to set
	 */
	public void setImpuestoExtra(double impuestoExtra) {
		this.impuestoExtra = impuestoExtra;
	}

	/**
	 * @return the sueldoTotal
	 */
	public double getSueldoTotal() {

		return sueldoTotal;
	}

	/**
	 * @param sueldoTotal the sueldoTotal to set
	 */
	public void setSueldoTotal(double sueldoTotal) {
		sueldoTotal = sueldoBase + bonoPuesto + entregaSaldo - impuesto;
		this.sueldoTotal = sueldoTotal;
	}

	/**
	 * @return the entregaSaldo
	 */
	public double getEntregaSaldo() {
		entregaSaldo = entrega * 5;
		return entregaSaldo;
	}

	/**
	 * @param entregaSaldo the entregaSaldo to set
	 */
	public void setEntregaSaldo(double entregaSaldo) {
		this.entregaSaldo = entregaSaldo;
	}

	@Override
	public String toString() {
		return "ENEntidad [id=" + id + ", nombre=" + nombre + ", rol=" + rol + ", sueldoBase=" + sueldoBase
				+ ", entrega=" + entrega + ", bonoPuesto=" + bonoPuesto + ", impuesto=" + impuesto + ", impuestoExtra="
				+ impuestoExtra + ", sueldoTotal=" + sueldoTotal + "]";
	}

}
