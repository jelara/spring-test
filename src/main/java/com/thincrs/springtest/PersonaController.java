package com.thincrs.springtest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PersonaController {

	private PersonaDAOInterface personaDAO;

	public PersonaController() {
		personaDAO = new PersonaDAO();
	}

	public PersonaDAOInterface getPersonaDAO() {
		return personaDAO;
	}

	@GetMapping(path = "/personas", produces = "application/json")
	public List<Persona> listAll() {
		return getPersonaDAO().cargarTodas();
	}

	@GetMapping(path = "/personas/{id}")
	public String findById(@PathVariable(name = "id", required = true) int id) {
		return "Your ID is: " + id;
	}

	@PostMapping(path = "/personas")
	public String create() {
		return "";
	}

	@PutMapping(path = "/personas/{id}")
	public String update() {
		return "";
	}

	@DeleteMapping(path = "/personas/{id}")
	public String delete(@PathVariable(name = "id", required = true) int id) {
		return "";
	}
}
