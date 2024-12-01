package com.venta.cibertec.proyecto.service.interfaces;

import com.venta.cibertec.proyecto.presentation.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {

    List<ProductoDTO> listarProductos();
    ProductoDTO obtenerProductoPorId(int id);
    boolean crearProducto(ProductoDTO productoDTO);
    boolean actualizarProducto(int id, ProductoDTO productoDTO);
    boolean eliminarProducto(int id);
}
