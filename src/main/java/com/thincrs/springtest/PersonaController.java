package com.thincrs.springtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	private PersonaRepository personaRepository;

	public PersonaController(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	@GetMapping(path = "/personas", produces = "application/json")
	public List<Persona> listAll(@RequestParam(required = false) String curp) {
		System.out.println("Curp: " + curp);
		if (curp == null) {
			List<Persona> resultado = new ArrayList<>();
			personaRepository.findAll().forEach(resultado::add);
			return resultado;
		} else {
			return personaRepository.findByCurp(curp);
		}
	}

	@GetMapping(path = "/personas/{id}")
	public Optional<Persona> findById(@PathVariable(name = "id", required = true) int id) {
		return personaRepository.findById(id);
	}

	@PostMapping(path = "/personas")
	public String crear(@RequestBody Persona miPersona) {
		personaRepository.save(miPersona);

		return "{\"status\": \"success\"}";
	}

	@PutMapping(path = "/personas/{id}")
	public String update() {
		personaRepository.save(null);
		return "{\"status\": \"success\"}";
	}

	@DeleteMapping(path = "/personas/{id}")
	public String delete(@PathVariable(name = "id", required = true) int id) {
		personaRepository.deleteById(id);
		return "{\"status\": \"success\"}";
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleException(Exception e) {
		e.printStackTrace();
		return null;
	}
}
