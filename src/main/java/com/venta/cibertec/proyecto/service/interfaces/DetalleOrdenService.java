package com.venta.cibertec.proyecto.service.interfaces;

import com.venta.cibertec.proyecto.presentation.dto.DetalleOrdenDTO;

import java.util.List;

public interface DetalleOrdenService {

    List<DetalleOrdenDTO> getAllByOrden(int idOrden);
}
