package com.venta.cibertec.proyecto.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Categoria")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    private double precio;

    @Column(nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "IdCategoria", nullable = true)
    private Categoria categoria;

    @Column(name = "FechaCreacion", updatable = false)
    private String fechaCreacion;

    @Column(name = "FechaActualizacion")
    private String fechaActualizacion;
}
