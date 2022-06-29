package es.dev.conexionHiberrnate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Clientes {
	
	public Clientes() {		
	}
	
	public Clientes( String nombre, String apellido, String direccion) {	
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}
	
	@Id
	@Column(name = "IDCLIENTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idcliente;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "DIRECCION")
	private String direccion;
	
	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Clientes [idcliente=" + idcliente + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion="
				+ direccion + "]";
	}
	
	
}
/*
 * IDCLIENTE NUMBER(10), NOMBRE VARCHAR(20), APELLIDO VARCHAR(20), DIRECCION
 * VARCHAR(20)
 */