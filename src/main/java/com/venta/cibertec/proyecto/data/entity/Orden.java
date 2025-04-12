package com.venta.cibertec.proyecto.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaRecivida;
    private double total;
    //usuario
    @ManyToOne
    private Usuario usuario;
    //detalleOrden
    @OneToMany(mappedBy = "orden")
    private List<DetalleOrden> detalle;
}
