package com.venta.cibertec.proyecto.presentation.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrdenDTO {

    private int id;
    private String numero;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaRecivida;
    private double total;
    private int idUsuario;
}
