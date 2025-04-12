package com.venta.cibertec.proyecto.service.interfaces;

import com.venta.cibertec.proyecto.data.entity.Orden;
import com.venta.cibertec.proyecto.presentation.dto.OrdenDTO;

import java.util.List;

public interface OrdenService {

    List<OrdenDTO> getAll();
    OrdenDTO createOrden();
    String delete(int id);



}
