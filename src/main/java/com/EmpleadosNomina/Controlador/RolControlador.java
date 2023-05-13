package com.EmpleadosNomina.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.EmpleadosNomina.Entidad.ENEntidad;
import com.EmpleadosNomina.Entidad.ENRol;
import com.EmpleadosNomina.Repositorio.RolRepositorio;



@Controller
public class RolControlador {
	
	@Autowired
	private RolRepositorio rolRepositorio;
	
	@GetMapping("/rol_formulario")
	public String listarRol(Model modelo) {
		List<ENRol> roles = rolRepositorio.findAll();
		modelo.addAttribute("roles", roles);
		return "rol_formulario";	
		}
	
	@GetMapping("/rol_formulario/crear_rol")
	public String mostrarRolFormulario(Model modelo) {
		modelo.addAttribute("roles", new ENRol());
		
		return "crear_rol";

	}

	
	@PostMapping("/rol_formulario/crear_rol")
	public String guardarRol(ENRol roles, RedirectAttributes redirect ) {
		rolRepositorio.save(roles);
		//redirect.addFlashAttribute("msgExito", "El rol se agrego");
		return "redirect:/rol_formulario";
		
	}
	
	//@PostMapping( "/movimientosrol_rol")
	//@ResponseBody
	//public String populateList(Model model) {
	  //  List<ENEntidad> options = new List<ENEntidad>();
	    //options.add("option 1");
	    //options.add("option 2");
	    //options.add("option 3");
	    //model.addAttribute("options", options);
	    //return "movimientosrol_rol";
	//}
	

	@GetMapping("rol_formulario/movimientosrol/{idrol}")
	public String mostrarFormularioDeEditarRol(@PathVariable Long idrol, Model modelo) {
		modelo.addAttribute("roles", rolRepositorio.findById(idrol).get());
		
		return "movimientosrol_rol";

	}
	
	

	@PostMapping("/rol_formulario/{idrol}")
	public String actualizarRol(@PathVariable Long idrol, @ModelAttribute("roles") ENRol roles,
			Model modelo) {
		ENRol rolExistente = rolRepositorio.findById(idrol).get();
		rolExistente.setIdrol(idrol);
		rolExistente.setNombrerol(roles.getNombrerol());
		rolExistente.setSueldorol(roles.getSueldorol());
		rolRepositorio.save(rolExistente);
		return "redirect:/rol_formulario";

	}

	@GetMapping("/rol_formulario/{idrol}")
	public String eliminarEmpleado(@PathVariable Long idrol) {
		rolRepositorio.deleteById(idrol);
		return "redirect:/rol_formulario";

	}
	
	

}
