package com.EmpleadosNomina.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmpleadosNomina.Entidad.ENEntidad;
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
		ENEntidad empleado = new ENEntidad();
		modelo.addAttribute("empleado", empleado);
		return "crear_empleado";

	}

	

	@PostMapping("/empleados")
	public String guardarEmpleados(@ModelAttribute("empleado") ENEntidad empleado) {
		servicio.guardarEmpleado(empleado);
		return "redirect:/empleados";

	}
	

	@GetMapping("/empleados/movimientos/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("empleado", servicio.obtenerEmpleadoPorId(id));
		return "movimientos_empleado";

	}

	@PostMapping("/empleados/{id}")
	public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute("empleado") ENEntidad empleado,
			Model modelo) {
		ENEntidad empleadoExistente = servicio.obtenerEmpleadoPorId(id);
		empleadoExistente.setId(id);
		empleadoExistente.setNombre(empleado.getNombre());
		empleadoExistente.setRoll(empleado.getRoll());
		empleadoExistente.setEntrega(empleado.getEntrega());
		

		servicio.actualizarEmpleado(empleadoExistente);
		return "redirect:/empleados";

	}

	@GetMapping("/empleados/{id}")
	public String eliminarEmpleado(@PathVariable Long id) {
		servicio.eliminarEStudiante(id);
		return "redirect:/empleados";

	}
	
	
	
	
}
