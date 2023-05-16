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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
		
		//System.out.println(empleado);
		
		return "empleados";	
		}
	

	
	
	@GetMapping("/empleados/crear_empleado")
	public String mostrarEmpleadoFormulario(Model modelo) {
		modelo.addAttribute("empleado", new ENEntidad());
		
		List<ENRol> listaRole = rolRepositorio.findAll();
		modelo.addAttribute("listaRole",listaRole);
	
		return "crear_empleado";

	}

	
	@PostMapping("/empleados/crear_empleado")
	public String guardarEmpleado(ENEntidad empleado, ENRol rolfk,  RedirectAttributes redirect ) {
		empleado.setNombre(empleado.getNombre());
		empleado.setSueldobase(empleado.getSueldobase());
		rolfk.setSueldorol(rolfk.getSueldorol());
		empleado.setEntrega(0);
		empleado.setEntregasaldo(0);
		empleado.setImpuesto(empleado.getEntrega());
		empleado.setImpuestoextra(1);
		empleado.setSueldototal(empleado.getSueldototal());
		empleado.setValesdespensa(empleado.getValesdespensa());
		//System.out.println(empleado);
		System.out.println("Aqui " + rolfk.getSueldorol());
		enRepositorio.save(empleado);
		
		return "redirect:/empleados";	
	}
	

	

	@GetMapping("empleados/movimientos_empleado/{id}")
	public String mostrarFormularioDeEditarEmpleado(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("empleado", enRepositorio.findById(id).get());
		
		List<ENRol> listaRole = rolRepositorio.findAll();
		modelo.addAttribute("listaRole",listaRole);
		
		return "movimientos_empleado";
	}
	

	
	@PostMapping("/empleados/{id}")
    public String actualizarEmpleado(@PathVariable Long id,  ENEntidad empleado, ENRol rolfk, RedirectAttributes redirect) {
    	ENEntidad empleadoexistent = enRepositorio.findById(id).get();
    	
    	System.out.println("Aqui " + rolfk);
    	System.out.println("Aqui1 " + empleado);
    	empleadoexistent.setId(id);
    	empleadoexistent.setNombre(empleado.getNombre());
    	//empleadoexistent.setSueldobase(empleado.getSueldobase());
    	rolfk.setSueldorol(rolfk.getSueldorol());
    	empleadoexistent.setRolfk(empleado.getRolfk());
    	empleadoexistent.setEntrega(empleado.getEntrega());
    	//empleadoexistent.setEntregasaldo(empleado.getEntregasaldo());
    	//empleadoexistent.setImpuesto(empleado.getImpuesto());
    	//empleadoexistent.setImpuestoextra(empleado.getImpuestoextra());
    	//empleadoexistent.setSueldototal(empleado.getSueldototal());
		//empleadoexistent.setValesdespensa(empleado.getValesdespensa());
    	
    	System.out.println("Aqui2 " + rolfk);
    	System.out.println("Aqui3 " + empleado); 
    	
    	enRepositorio.save(empleadoexistent);
    	//rolRepositorio.save(rolfk);
    	//System.out.println(empleado.getNombre());
    	
        return "redirect:/empleados";
    }



	@GetMapping("/empleados/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable Long id) {
		enRepositorio.deleteById(id);
		return "redirect:/empleados";

	}
	@GetMapping("/movimientos")
	public String listaRol(Model modelo) {
		List<ENRol> listaRol = rolRepositorio.findAll();
		modelo.addAttribute("listarRol", listaRol);
	
		return "movimientos";
	}
	
	
	
	
}

