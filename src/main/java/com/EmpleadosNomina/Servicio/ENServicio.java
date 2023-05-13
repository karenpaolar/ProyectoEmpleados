package com.EmpleadosNomina.Servicio;

import java.util.List;


import com.EmpleadosNomina.Entidad.EmpleadosEN;

public interface ENServicio {
	
	public List<EmpleadosEN> listaEmpleados();
	
	public EmpleadosEN guardarEmpleado(EmpleadosEN empleado);
	
	public EmpleadosEN obtenerEmpleadoPorId(Integer idempleado);
	
	public EmpleadosEN actualizarEmpleado(EmpleadosEN empleado);
	
	public void eliminarEmpleado(Integer idempleado);


	

}
