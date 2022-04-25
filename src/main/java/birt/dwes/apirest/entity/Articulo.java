package birt.dwes.apirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name="articulo")
public class Articulo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idarticulo")
	private int id;
	
	@Column(name="nombreproducto")
	private String nombre;
	
	@Column(name="descripcion")
	private String desc;
	
	@Column(name="precio")
	private float precio;
	
	//Constructores
	public Articulo() {}
	
	public Articulo(int idarticulo, String nombreproducto, String descripcion, float precio) {
		super();
		this.id = idarticulo;
		this.nombre = nombreproducto;
		this.desc = descripcion;
		this.precio = precio;
	}
	
	//Getters / Setters
	public int getIdarticulo() {
		return id;
	}
	
	public void setIdarticulo(int id) {
		this.id = id;
	}
	
	public String getNombreproducto() {
		return nombre;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombre = nombreproducto;
	}

	public String getDescripcion() {
		return desc;
	}

	public void setDescripcion(String descripcion) {
		this.desc = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


}
