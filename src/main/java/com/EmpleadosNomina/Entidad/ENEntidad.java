package com.EmpleadosNomina.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleados")
public class ENEntidad {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="rolempleado")
	private ENRol rolfk;

	@Column(name = "sueldobase")
	private Integer sueldobase;

	@Column(name = "entrega")
	private Integer entrega;

	@Column(name = "entregasaldo")
	private Integer entregasaldo;


	@Column(name = "impuesto")
	private Integer impuesto;

	@Column(name = "impuestoextra")
	private Integer impuestoextra;

	@Column(name = "sueldototal")
	private Integer sueldototal;

	@Column(name = "valesdespensa")
	private Integer valesdespensa;
	
	
	
	public ENEntidad() {
		super();
	}


	public ENEntidad(Long id, String nombre, ENRol rolfk, Integer sueldobase, Integer entrega, Integer entregasaldo,
			Integer impuesto, Integer impuestoextra, Integer sueldototal, Integer valesdespensa) {
		this.id = id;
		this.nombre = nombre;
		this.rolfk = rolfk;
		this.sueldobase = sueldobase;
		this.entrega = entrega;
		this.entregasaldo = entregasaldo;
		this.impuesto = impuesto;
		this.impuestoextra = impuestoextra;
		this.sueldototal = sueldototal;
		this.valesdespensa = valesdespensa;
	}



	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getSueldobase() {
		sueldobase = 1440 * 4;
		return sueldobase;
	}


	public void setSueldobase(Integer sueldobase) {
		this.sueldobase = sueldobase;
	}


	public Integer getEntrega() {
		return entrega;
	}


	public void setEntrega(Integer entrega) {
		this.entrega = entrega;
	}


	public Integer getEntregasaldo() {
		entregasaldo = entrega * 5;
		return entregasaldo;
	}


	public void setEntregasaldo(Integer entregasaldo) {
		this.entregasaldo = entregasaldo;
	}


	public Integer getImpuesto() {//falta el sueldo por rol
		impuesto = ((sueldobase + entregasaldo) * 9) / 100;
		return impuesto;
	}


	public void setImpuesto(Integer impuesto) {  
		
		this.impuesto = impuesto;
	}


	public Integer getImpuestoextra() {
		if((sueldobase + entregasaldo) >= 10000){//falta el sueldo por rol
			impuestoextra = ((sueldobase + entregasaldo ) * 3) / 100;
			
		}else {
			impuestoextra = 0;
		}
		
		return impuestoextra;
	}
		

	public void setImpuestoextra(Integer impuestoextra) {
		this.impuestoextra = impuestoextra;
	}


	public Integer getSueldototal() {
		sueldototal = sueldobase + entregasaldo - impuesto;
		
		return sueldototal;
	}


	public void setSueldototal(Integer sueldototal) {
		this.sueldototal = sueldototal;
	}


	public Integer getValesdespensa() {
		valesdespensa = ((sueldobase ) * 4)/100;
		return valesdespensa;
	}


	public void setValesdespensa(Integer valesdespensa) {
		this.valesdespensa = valesdespensa;
	}

	public ENRol getRolfk() {
		return rolfk;
	}

	public void setRolfk(ENRol rolfk) {
		this.rolfk = rolfk;
	}


	

	@Override
	public String toString() {
		return "ENEntidad [id=" + id + ", nombre=" + nombre + ", roles=" + rolfk + ", sueldobase=" + sueldobase
				+ ", entrega=" + entrega + ", entregasaldo=" + entregasaldo + ", impuesto=" + impuesto
				+ ", impuestoextra=" + impuestoextra + ", sueldototal=" + sueldototal + ", valesdespensa="
				+ valesdespensa + "]";
	}

}
