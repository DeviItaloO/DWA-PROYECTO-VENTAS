package com.venta.cibertec.proyecto.presentation.controller;

import com.venta.cibertec.proyecto.presentation.dto.ProductoDTO;
import com.venta.cibertec.proyecto.service.interfaces.ProductoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        try {
            List<ProductoDTO> productos = productoService.listarProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(List.of(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable Integer id) {
        try {
            ProductoDTO producto = productoService.obtenerProductoPorId(id);
            if(producto != null) {
                return new ResponseEntity<>(producto, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<String> crearProducto(@RequestBody ProductoDTO productoDTO) {
        try {
            boolean respuesta = productoService.crearProducto(productoDTO);
            if(respuesta) {
                return new ResponseEntity<>("Producto creado correctamente", HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>("Producto no existe", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto" + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        try {
            boolean respuesta = productoService.actualizarProducto(id, productoDTO);
            if(respuesta) {
                return new ResponseEntity<>("Producto actualizado correctamente", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Producto no existe", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer id) {
        try {
            boolean respuesta = productoService.eliminarProducto(id);
            if(respuesta) {
                return new ResponseEntity<>("Producto eliminado correctamente", HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
