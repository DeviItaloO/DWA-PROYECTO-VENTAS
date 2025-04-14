package com.venta.cibertec.proyecto.presentation.dto;

import lombok.Data;

@Data
public class DetalleOrdenDTO {
    private int id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;
    private int idProducto;
    private int idOrden;
}
