package com.venta.cibertec.proyecto.service.interfaces;

import com.venta.cibertec.proyecto.presentation.dto.DetalleOrdenDTO;

import java.util.List;

public interface DetalleOrdenService {

    List<DetalleOrdenDTO> listarPorOrden(int idOrden);
    DetalleOrdenDTO obtenerDetallePorId(int id);
    boolean crearDetalleOrden(DetalleOrdenDTO detalleDTO);
    boolean actualizarDetalleOrden(int id, DetalleOrdenDTO detalleDTO);
    boolean eliminarDetalleOrden(int id);
}
