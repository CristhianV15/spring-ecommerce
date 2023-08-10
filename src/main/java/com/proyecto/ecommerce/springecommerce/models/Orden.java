package com.proyecto.ecommerce.springecommerce.models;
import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name= "ordenes") //Anotacion para no usar el nombre de la clase "Orden"

public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrden;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;
    
    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "orden")
	private List<DetalleOrden> detalle;
}
