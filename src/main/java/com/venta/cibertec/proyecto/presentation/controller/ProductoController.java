package com.venta.cibertec.proyecto.presentation.controller;

import com.venta.cibertec.proyecto.presentation.dto.ProductoDTO;
import com.venta.cibertec.proyecto.service.interfaces.ProductoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        try {
            List<ProductoDTO> productos = productoService.listarProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(List.of(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable Integer id) {
        try {
            ProductoDTO producto = productoService.obtenerProductoPorId(id);
            if(producto != null) {
                return new ResponseEntity<>(producto, HttpStatus.OK);
            }else{
                Map<String, String> response = new HashMap<>();
                response.put("message", "Producto no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Server: Error: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> crearProducto(@RequestBody ProductoDTO productoDTO) {
        try {
            boolean respuesta = productoService.crearProducto(productoDTO);
            Map<String, String> response = new HashMap<>();
            if(respuesta) {
                response.put("message", "Producto creado correctamente");
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }else{
                response.put("message", "Producto no creado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Server: Error: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        try {
            boolean respuesta = productoService.actualizarProducto(id, productoDTO);
            Map<String, String> response = new HashMap<>();
            if(respuesta) {
                response.put("message", "Producto actualizado correctamente");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                response.put("message", "Producto no encontrado");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Server: Error: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        try {
            boolean respuesta = productoService.eliminarProducto(id);
            Map<String, String> response = new HashMap<>();
            if (respuesta) {
                response.put("message", "Producto eliminado correctamente");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                response.put("message", "Producto no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Server: Error: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
