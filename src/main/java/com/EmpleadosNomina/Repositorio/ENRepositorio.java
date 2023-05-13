package com.EmpleadosNomina.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmpleadosNomina.Entidad.ENEntidad;

@Repository
public interface ENRepositorio extends JpaRepository<ENEntidad, Long>{

}
