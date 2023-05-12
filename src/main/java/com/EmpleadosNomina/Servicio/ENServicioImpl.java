package com.EmpleadosNomina.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.EmpleadosNomina.Entidad.EmpleadosEN;
import com.EmpleadosNomina.Repositorio.ENRepositorio;

@Service
public class ENServicioImpl implements ENServicio {

	@Autowired
	private ENRepositorio repositorio;

	@Override
	public List<EmpleadosEN> listaEmpleados() {
		return repositorio.findAll();
	}


	@Override
	public EmpleadosEN guardarEmpleado(EmpleadosEN empleado) {
		return repositorio.save(empleado);
	}

	@Override
	public EmpleadosEN obtenerEmpleadoPorId(Integer idempleado) {
		return repositorio.findById(idempleado).get();
	}

	@Override
	public EmpleadosEN actualizarEmpleado(EmpleadosEN empleado) {
		return repositorio.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Integer idempleado) {
		repositorio.deleteById(idempleado);
		
	}


	

	

}
