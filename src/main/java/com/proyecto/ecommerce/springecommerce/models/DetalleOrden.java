package com.proyecto.ecommerce.springecommerce.models;
import lombok.Data;
import jakarta.persistence.*;
@Data
@Entity
@Table(name= "detallesOrden") //Anotacion para no usar el nombre de la clase "DetalleOrden"

public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idDetalleOrden;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;
    @ManyToOne
	private Orden orden;
	@ManyToOne
	private Producto producto;
}
