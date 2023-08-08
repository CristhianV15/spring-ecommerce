package com.proyecto.ecommerce.springecommerce.models;

import java.util.Date;
import lombok.Data;

@Data
public class Orden {
    private Integer id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;
    
}
