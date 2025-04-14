package com.venta.cibertec.proyecto.service.interfaces;

import com.venta.cibertec.proyecto.data.entity.Orden;
import com.venta.cibertec.proyecto.presentation.dto.OrdenDTO;

import java.util.List;

public interface OrdenService {

    List<OrdenDTO> listarOrdenes();
    OrdenDTO obtenerOrdenPorId(int id);
    boolean crearOrden(OrdenDTO ordenDTO);
    boolean actualizarOrden(int id, OrdenDTO ordenDTO);
    boolean eliminarOrden(int id);
}
