package com.EmpleadosNomina.Servicio;

import java.util.List;

import com.EmpleadosNomina.Entidad.ENEntidad;


public interface ENServicio {
	
	public List<ENEntidad> listaEmpleados();
	
	public ENEntidad guardarEmpleado(ENEntidad empleado);
	
	public ENEntidad obtenerEmpleadoPorId(Integer idempleado);
	
	public ENEntidad actualizarEmpleado(ENEntidad empleado);
	
	public void eliminarEmpleado(Integer idempleado);


	

}
