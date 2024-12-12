package com.venta.cibertec.proyecto.service.implementation;

import com.venta.cibertec.proyecto.data.entity.Producto;
import com.venta.cibertec.proyecto.data.repository.ProductoRepository;
import com.venta.cibertec.proyecto.presentation.dto.ProductoDTO;
import com.venta.cibertec.proyecto.service.interfaces.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductoDTO> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO obtenerProductoPorId(int id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
        return modelMapper.map(producto, ProductoDTO.class);
    }

    @Override
    public boolean crearProducto(ProductoDTO productoDTO) {
        Producto producto = modelMapper.map(productoDTO, Producto.class);
        productoRepository.save(producto);
        return true;
    }

    @Override
    public boolean actualizarProducto(int id, ProductoDTO productoDTO) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
        modelMapper.map(productoDTO, producto);
        productoRepository.save(producto);
        return true;
    }

    @Override
    public boolean eliminarProducto(int id) {
        if(!productoRepository.existsById(id))
            throw new RuntimeException("Producto no encontrado");
        productoRepository.deleteById(id);
        return true;
    }
}
