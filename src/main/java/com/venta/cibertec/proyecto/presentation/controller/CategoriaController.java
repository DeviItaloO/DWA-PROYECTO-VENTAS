package com.venta.cibertec.proyecto.presentation.controller;

import com.venta.cibertec.proyecto.presentation.dto.CategoriaDTO;
import com.venta.cibertec.proyecto.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        try {
            List<CategoriaDTO> categorias = categoriaService.listarCategorias();
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(List.of(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/id")
    public ResponseEntity<CategoriaDTO> obtenerCategoriaPorId(@PathVariable Integer id) {
        try {
            CategoriaDTO categoria = categoriaService.obtenerCategoriaPorId(id);
            if (categoria != null)
                return new ResponseEntity<>(categoria, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> crearCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        try {
            boolean respuesta = categoriaService.crearCategoria(categoriaDTO);
            if (respuesta)
                return new ResponseEntity<>("Categoria creada correctamente", HttpStatus.CREATED);
            else
                return new ResponseEntity<>("Categoria no existe", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la categoria" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizarCategoria(@PathVariable Integer id,@RequestBody CategoriaDTO categoriaDTO) {
        try {
            boolean respuesta = categoriaService.actualizarCategoria(id, categoriaDTO);
            if (respuesta)
                return new ResponseEntity<>("Categoria actualizada correctamente", HttpStatus.OK);
            else
                return new ResponseEntity<>("Categoria no existe", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarCategoria(@PathVariable Integer id) {
        try {
            boolean respuesta = categoriaService.eliminarCategoria(id);
            if (respuesta)
                return new ResponseEntity<>("Categoria eliminada correctamente", HttpStatus.OK);
            else
                return new ResponseEntity<>("Categoria no existe", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la categoria" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
