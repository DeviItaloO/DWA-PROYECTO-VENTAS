package com.venta.cibertec.proyecto.service.interfaces;

import com.venta.cibertec.proyecto.presentation.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {

    List<ProductoDTO> listarProductos();
    ProductoDTO obtenerProductoPorId(int id);
    void crearProducto(ProductoDTO productoDTO);
    void actualizarProducto(int id, ProductoDTO productoDTO);
    void eliminarProducto(int id);
}
