package com.venta.cibertec.proyecto.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrden;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaRecibida;

    @Column(nullable = false)
    private double total;
    //usuario
    @ManyToOne
    private Usuario usuario;
    //detalleOrden
    @OneToMany(mappedBy = "orden")
    private List<DetalleOrden> detalle;

    @PrePersist
    private void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.fechaRecibida = LocalDateTime.now();
    }
}
