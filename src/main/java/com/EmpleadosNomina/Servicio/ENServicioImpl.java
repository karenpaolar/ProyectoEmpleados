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

}
