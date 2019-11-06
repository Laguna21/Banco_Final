package paquete;

import java.util.LinkedList;

public class Cliente {
	private String dni = "";
	private String nombre = "";
	private String apellido = "";
	//private LinkedList<Cuenta> cuentasDeCliente;
	public Cliente(String dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		
	}
	/*
	public void agregarCuenta(Cuenta c) {
		cuentasDeCliente.add(c);
	}
	*/
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	/*
	public void mostrarCuentas() {
		for (Cuenta cuenta : cuentasDeCliente) {
			System.out.println(cuenta);
		}
	}
	*/
	
}
