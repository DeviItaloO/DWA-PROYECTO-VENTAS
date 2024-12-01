package com.venta.cibertec.proyecto.service.implementation;

import com.venta.cibertec.proyecto.presentation.dto.ProductoDTO;
import com.venta.cibertec.proyecto.service.interfaces.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Override
    public List<ProductoDTO> listarProductos() {
        return List.of();
    }

    @Override
    public ProductoDTO obtenerProductoPorId(int id) {
        return null;
    }

    @Override
    public boolean crearProducto(ProductoDTO productoDTO) {
        return false;
    }

    @Override
    public boolean actualizarProducto(int id, ProductoDTO productoDTO) {
        return false;
    }

    @Override
    public boolean eliminarProducto(int id) {
        return false;
    }
}
