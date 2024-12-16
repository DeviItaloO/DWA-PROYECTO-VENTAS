package com.venta.cibertec.proyecto.service.implementation;

import com.venta.cibertec.proyecto.data.entity.Usuario;
import com.venta.cibertec.proyecto.data.repository.UsuarioRepository;
import com.venta.cibertec.proyecto.presentation.dto.UsuarioDTO;
import com.venta.cibertec.proyecto.service.interfaces.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository _usuarioRepository, ModelMapper _modelMapper) {
        this.usuarioRepository = _usuarioRepository;
        this.modelMapper = _modelMapper;
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @Override
    public boolean crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioRepository.save(usuario);
        return true;
    }

    @Override
    public boolean actualizarUsuario(int id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        modelMapper.map(usuarioDTO, usuario);
        usuarioRepository.save(usuario);
        return true;
    }

    @Override
    public boolean eliminarUsuario(int id) {
        if(!usuarioRepository.existsById(id))
            throw new RuntimeException("Usuario no encontrado");
        usuarioRepository.deleteById(id);
        return true;
    }

    @Override
    public Usuario obtenerUsuarioPorUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
