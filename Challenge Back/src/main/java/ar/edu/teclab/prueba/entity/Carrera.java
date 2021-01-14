package ar.edu.teclab.prueba.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="api_carrera")
public class Carrera implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="carrera_id")
	private int id;
	
	@Column(name="carrera_nombre")
	private String nombre;
	
	@Column(name="carrera_descripcion")
	private String descripcion;
	
	@Column(name="carrera_cantidadDeAnios")
	private int cantidadDeAnios;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable (name="carrera_materia", joinColumns=@JoinColumn(name="carrera_id"),inverseJoinColumns = @JoinColumn(name = "materia_id"))
	private List<Materia> materias = new ArrayList();

	public int getId() {
		return id;
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

	public int getCantidadDeAnios() {
		return cantidadDeAnios;
	}

	public void setCantidadDeAnios(int cantidadDeAnios) {
		this.cantidadDeAnios = cantidadDeAnios;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Carrera(int id, String nombre, String descripcion, int cantidadDeAnios, List<Materia> materias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidadDeAnios = cantidadDeAnios;
		this.materias = materias;
	}

	public Carrera() {
		super();
	}
	
	
	
}
