package com.venta.cibertec.proyecto.service.interfaces;

import com.venta.cibertec.proyecto.presentation.dto.CategoriaDTO;
import java.util.List;

public interface CategoriaService {

    List<CategoriaDTO> listarCategorias();
    CategoriaDTO obtenerCategoriaPorId(int id);
    boolean crearCategoria(CategoriaDTO categoriaDTO);
    boolean actualizarCategoria(int id, CategoriaDTO categoriaDTO);
    boolean eliminarCategoria(int id);
}
