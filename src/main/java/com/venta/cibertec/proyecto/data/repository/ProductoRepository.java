package com.venta.cibertec.proyecto.data.repository;

import com.venta.cibertec.proyecto.data.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
