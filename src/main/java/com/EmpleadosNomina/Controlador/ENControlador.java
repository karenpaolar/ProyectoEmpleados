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
<<<<<<< HEAD
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.EmpleadosNomina.Entidad.ENEntidad;
import com.EmpleadosNomina.Entidad.ENRol;
import com.EmpleadosNomina.Repositorio.ENRepositorio;
import com.EmpleadosNomina.Repositorio.RolRepositorio;

=======


import com.EmpleadosNomina.Entidad.EmpleadosEN;
import com.EmpleadosNomina.Servicio.ENServicio;
>>>>>>> 644e9e94eab1a32de58211debe1ff3ab1ef990b8

@Controller
public class ENControlador {


	@Autowired
<<<<<<< HEAD
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
=======
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
>>>>>>> 644e9e94eab1a32de58211debe1ff3ab1ef990b8
		
		return "crear_empleado";

	}

	
<<<<<<< HEAD
	@PostMapping("/empleados/crear_empleado")
	public String guardarEmpleado(ENEntidad empleado, RedirectAttributes redirect ) {
		enRepositorio.save(empleado);
=======

	@PostMapping("/empleados")
	public String guardarEmpleados(@ModelAttribute("empleado") EmpleadosEN empleado) {
		servicio.guardarEmpleado(empleado);
>>>>>>> 644e9e94eab1a32de58211debe1ff3ab1ef990b8
		return "redirect:/empleados";
		
	}
	

<<<<<<< HEAD
	@GetMapping("empleados/movimientos/{id}")
	public String mostrarFormularioDeEditarEmpleado(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("empleado", enRepositorio.findById(id).get());
		
=======
	@GetMapping("/empleados/movimientos/{idempleados}")
	public String mostrarFormularioDeEditar(@PathVariable Integer idempleado, Model modelo) {
		modelo.addAttribute("empleado", servicio.obtenerEmpleadoPorId(idempleado));
>>>>>>> 644e9e94eab1a32de58211debe1ff3ab1ef990b8
		return "movimientos_empleado";

	}
	
	

<<<<<<< HEAD
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
=======
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
>>>>>>> 644e9e94eab1a32de58211debe1ff3ab1ef990b8
		return "redirect:/empleados";

	}

<<<<<<< HEAD
	@GetMapping("/empleados/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable Long id) {
		enRepositorio.deleteById(id);
=======
	@GetMapping("/empleados/{idempleados}")
	public String eliminarEmpleado(@PathVariable Integer idempleado) {
		servicio.eliminarEmpleado(idempleado);
>>>>>>> 644e9e94eab1a32de58211debe1ff3ab1ef990b8
		return "redirect:/empleados";

	}
	
	
	
	
}

