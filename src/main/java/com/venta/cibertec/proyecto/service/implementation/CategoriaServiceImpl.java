package com.venta.cibertec.proyecto.service.implementation;

import com.venta.cibertec.proyecto.presentation.dto.CategoriaDTO;
import com.venta.cibertec.proyecto.service.interfaces.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return List.of();
    }

    @Override
    public CategoriaDTO obtenerCategoriaPorId(int id) {
        return null;
    }

    @Override
    public boolean crearCategoria(CategoriaDTO categoriaDTO) {
        return false;
    }

    @Override
    public boolean actualizarCategoria(int id, CategoriaDTO categoriaDTO) {
        return false;
    }

    @Override
    public boolean eliminarCategoria(int id) {
        return false;
    }
}
