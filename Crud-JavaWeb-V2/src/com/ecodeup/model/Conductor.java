package com.ecodeup.model;



public class Conductor {
	private int idcondutor;
	private String nombre;
	private String apellido;
	private String dni;
	private String nroLicencia;
	
	public Conductor(int id, String nombre, String apellido, String dni, String nroLicencia) {
		super();
		this.idcondutor = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nroLicencia= nroLicencia;
		
		
	}
	
	public Conductor() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return idcondutor;
	}

	public void setId(int id) {
		this.idcondutor = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getapellido() {
		return apellido;
	}

	public void setapellido(String apellido) {
		this.apellido = apellido;
	}

	public String getdni() {
		return dni;
	}

	public void setdni(String dni) {
		this.dni = dni;
	}

	
	public String getnroLicencia() {
		return nroLicencia;
	}

	public void setnroLicencia(String nroLicencia) {
		this.nroLicencia = nroLicencia;
	}
	
	@Override
	public String toString() {
		return "Conductor [id=" + idcondutor + ", nombre=" + nombre + ", apellido=" + apellido+ ", dni=" + dni
				+ ", nroLicencia=" + nroLicencia +  "]";
	}	

}
