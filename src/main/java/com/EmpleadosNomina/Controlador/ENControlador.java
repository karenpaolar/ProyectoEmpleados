package com.EmpleadosNomina.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.EmpleadosNomina.Servicio.ENServicio;

@Controller
public class ENControlador {
	
	
	@Autowired
	private ENServicio servicio;
	
	@GetMapping({"/empleados", "/"})
	public String listarEmpleados( Model modelo) {
		modelo.addAttribute("empleados", servicio.listaEmpleados());
		return "empleados";
		
	}
	

}
