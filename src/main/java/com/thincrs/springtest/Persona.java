package com.thincrs.springtest;

import java.sql.Date;

public class Persona {
	private Integer id;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private String genero;
	private String entidadNacimiento;
	private String curp;

	public Persona(Integer id, String nombre, String apellidos, Date fechaNacimiento, String genero,
			String entidadNacimiento, String curp) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.entidadNacimiento = entidadNacimiento;
		this.curp = curp;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getCurp() {
		return curp;
	}

	public String getEntidadNacimiento() {
		return entidadNacimiento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public void setEntidadNacimiento(String entidadNacimiento) {
		this.entidadNacimiento = entidadNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
