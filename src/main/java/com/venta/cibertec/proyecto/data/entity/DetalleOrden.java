package com.venta.cibertec.proyecto.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalleOrden")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleOrden;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private double cantidad;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private double total;
    //orden
    @ManyToOne
    private Orden orden;
    //producto
    @ManyToOne
    private Producto producto;
}
