package com.venta.cibertec.proyecto.service.implementation;

import com.venta.cibertec.proyecto.data.entity.Categoria;
import com.venta.cibertec.proyecto.data.repository.CategoriaRepository;
import com.venta.cibertec.proyecto.presentation.dto.CategoriaDTO;
import com.venta.cibertec.proyecto.service.interfaces.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoriaDTO> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map( categoria -> modelMapper.map(categoria, CategoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO obtenerCategoriaPorId(int id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        return modelMapper.map(categoria, CategoriaDTO.class);
    }

    @Override
    public boolean crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        categoriaRepository.save(categoria);
        return true;
    }

    @Override
    public boolean actualizarCategoria(int id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        modelMapper.map(categoriaDTO, categoria);
        categoriaRepository.save(categoria);
        return true;
    }

    @Override
    public boolean eliminarCategoria(int id) {
        if (!categoriaRepository.existsById(id))
            throw new RuntimeException("Categoria no encontrada");
        categoriaRepository.deleteById(id);
        return true;
    }
}
