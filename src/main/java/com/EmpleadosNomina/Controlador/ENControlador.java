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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.EmpleadosNomina.Entidad.ENEntidad;
import com.EmpleadosNomina.Entidad.ENRol;
import com.EmpleadosNomina.Repositorio.ENRepositorio;
import com.EmpleadosNomina.Repositorio.RolRepositorio;


@Controller
public class ENControlador {


	@Autowired
	private ENRepositorio enRepositorio;
	
	@Autowired
	private RolRepositorio rolRepositorio;
	
	@GetMapping("/empleados")
	public String listarEmpleado(Model modelo) {
		List<ENEntidad> empleado = enRepositorio.findAll();
		modelo.addAttribute("empleado", empleado);
		return "empleados";	
		}
	
	@GetMapping("/empleados/crear_empleado")
	public String mostrarEmpleadoFormulario(Model modelo) {
		modelo.addAttribute("empleado", new ENEntidad());
		
		return "crear_empleado";

	}

	
	@PostMapping("/empleados/crear_empleado")
	public String guardarEmpleado(ENEntidad empleado, RedirectAttributes redirect ) {
		enRepositorio.save(empleado);
		return "redirect:/empleados";
		
	}
	

	@GetMapping("empleados/movimientos/{id}")
	public String mostrarFormularioDeEditarEmpleado(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("empleado", enRepositorio.findById(id).get());
		
		return "movimientos_empleado";

	}
	
	

	@PostMapping("/empleados/{id}")
	public String actualizarRol(@PathVariable Long id, @ModelAttribute("empleado") ENEntidad empleado,
			Model modelo) {
		
		ENEntidad empleadoExistente = enRepositorio.findById(id).get();
		empleadoExistente.setId(id);
		empleadoExistente.setNombre(empleado.getNombre());
		empleadoExistente.setRolfk(empleado.getRolfk());
		empleadoExistente.setSueldobase(empleado.getSueldobase());
		empleadoExistente.setEntrega(empleado.getEntrega());
		empleadoExistente.setEntregasaldo(empleado.getEntregasaldo());
		empleadoExistente.setImpuesto(empleado.getImpuesto());
		empleadoExistente.setImpuestoextra(empleado.getImpuestoextra());
		empleadoExistente.setSueldototal(empleado.getSueldototal());
		empleadoExistente.setValesdespensa(empleado.getValesdespensa());
	
		
		enRepositorio.save(empleadoExistente);
		return "redirect:/empleados";

	}

	@GetMapping("/empleados/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable Long id) {
		enRepositorio.deleteById(id);
		return "redirect:/empleados";

	}
	
	
	
	
}

