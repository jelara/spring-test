package com.thincrs.springtest;

import java.sql.SQLException;
import java.util.List;

public interface PersonaDAOInterface {
	public List<Persona> cargarTodas();
	
	public int insertarPersona(Persona persona);
	
	public void eliminarPersona(int id) throws SQLException;
}
