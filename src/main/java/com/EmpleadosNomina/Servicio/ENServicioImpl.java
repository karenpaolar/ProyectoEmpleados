package com.EmpleadosNomina.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmpleadosNomina.Entidad.ENEntidad;
import com.EmpleadosNomina.Repositorio.ENRepositorio;

@Service
public class ENServicioImpl implements ENServicio {

	@Autowired
	private ENRepositorio repositorio;

	@Override
	public List<ENEntidad> listaEmpleados() {
		return repositorio.findAll();
	}

	@Override
	public ENEntidad guardarEmpleado(ENEntidad empleado) {
		return repositorio.save(empleado);
	}

	@Override
	public ENEntidad obtenerEmpleadoPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public ENEntidad actualizarEmpleado(ENEntidad empleado) {
		return repositorio.save(empleado);
	}

	@Override
	public void eliminarEStudiante(Long id) {
		repositorio.deleteById(id);

	}

	

	

}
