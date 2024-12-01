package com.venta.cibertec.proyecto.presentation.dto;

import lombok.Data;

@Data
public class ProductoDTO {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int idCategoria;
}
