package com.EmpleadosNomina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.EmpleadosNomina.Repositorio.ENRepositorio;


@SpringBootApplication
public class EmpleadosNominaApplication implements CommandLineRunner {

	public static void main(String[] args) {

		
		SpringApplication.run(EmpleadosNominaApplication.class, args);
		
		
	}
	
	
	
	
	@Autowired
	private ENRepositorio repositorio;
	

	

	@Override
	public void run(String... args) throws Exception {
		
	
		
		/*
		ENEntidad empleado2 = new ENEntidad("Juan Lopez", "Chofer");
		repositorio.save(empleado2);
		*/
				
		
	}

}
