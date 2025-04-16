package com.venta.cibertec.proyecto.data.repository;

import com.venta.cibertec.proyecto.data.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {

    //@Query("select f from Orden f where f.usuario_id_usuario=:userName order by f.id desc")
    //List<Orden> getFacturaByUserName(@Param("userName") String userName);

}
