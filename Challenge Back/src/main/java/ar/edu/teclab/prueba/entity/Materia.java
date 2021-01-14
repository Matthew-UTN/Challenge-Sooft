package ar.edu.teclab.prueba.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="api_materia")
public class Materia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="materia_id")
	private int id;
	
	@Column(name="carrera_nombre")
	private String nombre;
	
	@Column(name="carrera_descripcion")
	private String descripcion;
	
	@ManyToMany(mappedBy = "materias")
    private List<Carrera> carreras = new ArrayList();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}

	public Materia(int id, String nombre, String descripcion, List<Carrera> carreras) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.carreras = carreras;
	}

	public Materia() {
		super();
	}
	
	
	
	
	
}
