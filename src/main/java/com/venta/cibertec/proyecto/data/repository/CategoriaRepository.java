package com.venta.cibertec.proyecto.data.repository;

import com.venta.cibertec.proyecto.data.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
