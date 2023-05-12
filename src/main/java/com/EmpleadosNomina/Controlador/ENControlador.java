package com.EmpleadosNomina.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Registration.Signing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.EmpleadosNomina.Entidad.EmpleadosEN;
import com.EmpleadosNomina.Servicio.ENServicio;

@Controller
public class ENControlador {

	@Autowired
	private ENServicio servicio;

	@GetMapping({ "/empleados", "/" })
	public String listarEmpleados(Model modelo) {
		modelo.addAttribute("empleados", servicio.listaEmpleados());
		return "empleados";

	}

	@GetMapping("/empleados/nuevo")
	public String crearEmpleadoFormulario(Model modelo) {
		EmpleadosEN empleado = new EmpleadosEN();
		modelo.addAttribute("empleado", empleado);
		
		return "crear_empleado";

	}

	

	@PostMapping("/empleados")
	public String guardarEmpleados(@ModelAttribute("empleado") EmpleadosEN empleado) {
		servicio.guardarEmpleado(empleado);
		return "redirect:/empleados";

	}

	

	@GetMapping("/empleados/movimientos/{idempleados}")
	public String mostrarFormularioDeEditar(@PathVariable Integer idempleado, Model modelo) {
		modelo.addAttribute("empleado", servicio.obtenerEmpleadoPorId(idempleado));
		return "movimientos_empleado";

	}
	
	

	@PostMapping("/empleados/{idempleados}")
	public String actualizarEmpleado(@PathVariable Integer idempleado, @ModelAttribute("empleado") EmpleadosEN empleado,
			Model modelo) {
		EmpleadosEN empleadoExistente = servicio.obtenerEmpleadoPorId(idempleado);
		empleadoExistente.setIdEmpleado(idempleado);
		empleadoExistente.setNombreEmpleado(empleado.getNombreEmpleado());
		//empleadoExistente.setSueldoBase(empleado.getSueldoBase());
		//empleadoExistente.setRolEmpleado(empleado.getRolEmpleado());
		//empleadoExistente.setEntrega(empleado.getEntrega());
		//empleadoExistente.setEntregaSaldo(empleado.getEntregaSaldo());
		//empleadoExistente.setBonoPuesto(empleado.getBonoPuesto());
		//empleadoExistente.setImpuesto(empleado.getImpuesto());
		//empleadoExistente.setSueldoTotal(empleado.getSueldoTotal());
		//empleadoExistente.setValesDespensa(empleado.getValesDespensa());

		servicio.actualizarEmpleado(empleadoExistente);
		return "redirect:/empleados";

	}

	@GetMapping("/empleados/{idempleados}")
	public String eliminarEmpleado(@PathVariable Integer idempleado) {
		servicio.eliminarEmpleado(idempleado);
		return "redirect:/empleados";

	}
	
	
	
	
}
