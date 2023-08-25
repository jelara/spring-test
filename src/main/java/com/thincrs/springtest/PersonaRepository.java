package com.thincrs.springtest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {
	public List<Persona> findByCurp(String curp);
}
