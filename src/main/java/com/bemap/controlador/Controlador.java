package com.bemap.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bemap.interfaceServicio.IAdministradorServicio;
import com.bemap.interfaceServicio.IDatosServicio;
import com.bemap.interfaceServicio.ISensoresServicio;
import com.bemap.modelos.Administradores;
import com.bemap.modelos.Datos;
import com.bemap.modelos.Sensores;

@Controller
@RequestMapping
public class Controlador {

	@GetMapping("/")
	public String index(Model model) {
		List<Sensores> sensor = sensorServicio.listar();
		model.addAttribute("sensores", sensor);
		return "index";
	}

	// SENSORES

	@Autowired
	private ISensoresServicio sensorServicio;

	@GetMapping("/Sensores")
	public String listarSensores(Model model) {
		List<Sensores> sensores = sensorServicio.listar();
		model.addAttribute("sensores", sensores);
		return "indexSensores";
	}

	@GetMapping("/agregarSensores")
	public String agregarSensores(Model model) {
		model.addAttribute("sensor", new Sensores());
		return "nuevoSensor";
	}

	@PostMapping("/guardarSensores")
	public String guardarSensor(Sensores p) {
		sensorServicio.guardar(p);
		return "redirect:/listarSensores";
	}

	@GetMapping("/editarSensor/{id}")
	public String editarSensor(@PathVariable int id, RedirectAttributes atributos) {
		Optional<Sensores> sensor = sensorServicio.listarID(id);
		atributos.addFlashAttribute("sensor", sensor);
		return "redirect:/mostrarDatosSensor";
	}

	@GetMapping("/mostrarDatosSensor")
	public String mostrarDatosSensor(@ModelAttribute("sensor") Sensores p, Model model) {
		model.addAttribute("sensor", p);
		return "agregarSensor";
	}

	@GetMapping("/eliminarSensor/{id}")
	public String eliminarSensor(@PathVariable int id) {
		sensorServicio.borrar(id);
		return "redirect:/listarSensores";
	}

	// ADMINISTRADOR

	@Autowired
	private IAdministradorServicio adminServicio;

	@GetMapping("/listarAdministradores")
	public String listarAdministradores(Model model) {
		List<Administradores> administrador = adminServicio.listar();
		model.addAttribute("administrador", administrador);
		return "listaAdministradores";
	}

	@GetMapping("/agregarAdministradores")
	public String agregarAdministradores(Model model) {
		model.addAttribute("Administrador", new Administradores());
		return "nuevoAdministrador";
	}

	@PostMapping("/guardarAdministradores")
	public String guardarAdministradores(Administradores p) {
		adminServicio.guardar(p);
		return "redirec:/listarAdministradores";
	}

	@GetMapping("/editarAdmin/{id}")
	public String editarAdministrador(@PathVariable int id, RedirectAttributes atributos) {
		Optional<Administradores> administrador = adminServicio.listarID(id);
		atributos.addFlashAttribute("administrador", administrador);
		return "redirect:/mostrarDatosAdmin";
	}

	@GetMapping("/mostrarDatosAdmin")
	public String mostrarDatosAdmin(@ModelAttribute("administrador") Administradores p, Model model) {
		model.addAttribute("administrador", p);
		return "agregarAdmin";
	}

	@GetMapping("/eliminarAdmin/{id}")
	public String eliminarAdmin(@PathVariable int id) {
		adminServicio.borrar(id);
		return "redirect:/listarAdministradores";
	}

	// DATOS

	@Autowired
	private IDatosServicio datosServicio;

	@GetMapping("/listarDatos")
	public String listarDatos(Model model) {
		List<Datos> dato = datosServicio.listar();
		model.addAttribute("dato", dato);
		return "listaDatos";
	}

	@GetMapping("/agregarDatos")
	public String agregarDatos(Model model) {
		model.addAttribute("dato", new Datos());
		return "nuevoDato";
	}

	@PostMapping("/guardarDato")
	public String guardarDatos(Datos p) {
		datosServicio.guardar(p);
		return "redirec:/listarDatos";
	}

	@GetMapping("/editarDatos/{id}")
	public String editarDatos(@PathVariable int id, RedirectAttributes atributos) {
		Optional<Datos> dato = datosServicio.listarId(id);
		atributos.addFlashAttribute("dato", dato);
		return "redirect:/mostrarDatos";
	}

	@GetMapping("/mostrarDatos")
	public String mostrarDatos(@ModelAttribute("dato") Datos p, Model model) {
		model.addAttribute("dato", p);
		return "agregarDato";
	}

	@GetMapping("/eliminarDato/{id}")
	public String eliminarDato(@PathVariable int id) {
		datosServicio.borrar(id);
		return "redirect:/listarDatos";
	}

}