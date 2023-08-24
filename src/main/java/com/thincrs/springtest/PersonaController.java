package com.thincrs.springtest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {

	private PersonaDAOInterface personaDAO;

	public PersonaController(PersonaDAOInterface personaDAO) {
		this.personaDAO = personaDAO;
	}

	@GetMapping(path = "/personas", produces = "application/json")
	public List<Persona> listAll() {
		return personaDAO.cargarTodas();
	}

	@GetMapping(path = "/personas/{id}")
	public String findById(@PathVariable(name = "id", required = true) int id) {
		return "Your ID is: " + id;
	}

	@PostMapping(path = "/personas")
	public String crear(@RequestBody Persona miPersona) {
		
		personaDAO.insertarPersona(miPersona);

		return "{\"status\": \"success\"}";
	}

	@PutMapping(path = "/personas/{id}")
	public String update() {
		return "";
	}

	@DeleteMapping(path = "/personas/{id}")
	public String delete(@PathVariable(name = "id", required = true) int id) {
		return "";
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleException(Exception e) {
		e.printStackTrace();
		return null;
	}
}
