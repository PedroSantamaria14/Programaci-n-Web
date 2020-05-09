package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Abogado")
public class Abogado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name ="nombre",nullable=false,length=30)
	private String nombre;

	private String apellido;	
	private String correo;
	private int anios_experiencia;
	private String telefono;
	@ManyToOne
	@JoinColumn(name ="idEspecialidad",nullable=false)
	private Especialidad especialidad;
	public Abogado() {
		super();
		
}
	public Abogado(int codigo, String nombre, String apellido, String correo, int anios_experiencia, String telefono,
			Especialidad especialidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.anios_experiencia = anios_experiencia;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getAnios_experiencia() {
		return anios_experiencia;
	}
	public void setAnios_experiencia(int anios_experiencia) {
		this.anios_experiencia = anios_experiencia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	
}