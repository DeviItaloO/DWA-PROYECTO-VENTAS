package com.venta.cibertec.proyecto.presentation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class OrdenCreateDTO {

    private Integer id;
    private String numero;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaRecivida;
    private double total;
    private List<DetalleOrdenDTO> detalle;
}
