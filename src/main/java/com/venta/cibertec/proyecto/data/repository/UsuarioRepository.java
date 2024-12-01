package com.venta.cibertec.proyecto.data.repository;

import com.venta.cibertec.proyecto.data.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
