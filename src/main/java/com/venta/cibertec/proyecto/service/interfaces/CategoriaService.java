package com.venta.cibertec.proyecto.service.interfaces;

import com.venta.cibertec.proyecto.presentation.dto.CategoriaDTO;
import java.util.List;

public interface CategoriaService {

    List<CategoriaDTO> listarCategorias();
    CategoriaDTO obtenerCategoriaPorId(int id);
    void crearCategoria(CategoriaDTO categoriaDTO);
    void actualizarCategoria(int id, CategoriaDTO categoriaDTO);
    void eliminarCategoria(int id);
}
