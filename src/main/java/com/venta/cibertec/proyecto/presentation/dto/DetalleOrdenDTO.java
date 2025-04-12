package com.venta.cibertec.proyecto.presentation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetalleOrdenDTO {
    private Integer id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;
    private int idProducto;
    private int idOrden;
}
