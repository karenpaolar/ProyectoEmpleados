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



	@Override
	public String toString() {
		return "ENEntidad [id=" + id + ", nombre=" + nombre + ", rol=" + rol + ", sueldoBase=" + sueldoBase
				+ ", entrega=" + entrega + ", entregaSaldo=" + entregaSaldo + ", bonoPuesto=" + bonoPuesto
				+ ", impuesto=" + impuesto + ", impuestoExtra=" + impuestoExtra + ", sueldoTotal=" + sueldoTotal
				+ ", valesDespensa=" + valesDespensa + "]";
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
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the sueldoBase
	 */
	public double getSueldoBase() {
		return sueldoBase;
	}

	/**
	 * @param sueldoBase the sueldoBase to set
	 */
	public void setSueldoBase(double sueldoBase) {
		sueldoBase = 1440 * 4;
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
	 * @return the entregaSaldo
	 */
	public double getEntregaSaldo() {
		return entregaSaldo;
	}

	/**
	 * @param entregaSaldo the entregaSaldo to set
	 */
	public void setEntregaSaldo(double entregaSaldo) {
		entregaSaldo = entrega * 5;
		this.entregaSaldo = entregaSaldo;
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
		impuesto = ((sueldoBase + entregaSaldo + bonoPuesto) * 9) / 100;
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
		if((sueldoBase + entregaSaldo + bonoPuesto) >= 10000){
			impuestoExtra = ((sueldoBase + entregaSaldo + bonoPuesto) * 3) / 100;
			
		}else {
			impuestoExtra = 0;
		}
		
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
		sueldoTotal = sueldoBase + bonoPuesto + entregaSaldo - impuesto;
		return sueldoTotal;
	}

	/**
	 * @param sueldoTotal the sueldoTotal to set
	 */
	public void setSueldoTotal(double sueldoTotal) {
		this.sueldoTotal = sueldoTotal;
	}
	
	/**
	 * @return the valesDespensa
	 */
	public double getValesDespensa() {
		valesDespensa = ((sueldoBase + bonoPuesto) * 4)/100;
		return valesDespensa;
	}

	/**
	 * @param valesDespensa the valesDespensa to set
	 */
	public void setValesDespensa(double valesDespensa) {
		this.valesDespensa = valesDespensa;
	}

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
	
	@Column(name = "valesDespensa")
	private double valesDespensa;



	public ENEntidad(Long id, String nombre, String rol, double sueldoBase, Long entrega, double entregaSaldo,
			double bonoPuesto, double impuesto, double impuestoExtra, double sueldoTotal, double valesDespensa) {
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
		this.valesDespensa = valesDespensa;
	}

	public ENEntidad() {
		super();
	}

	



}
