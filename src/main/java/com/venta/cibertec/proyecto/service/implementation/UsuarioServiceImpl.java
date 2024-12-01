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
        try {
            Usuario usuario = usuarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            return modelMapper.map(usuario, UsuarioDTO.class);
        } catch (RuntimeException e) {
            return null;
        }
    }

    @Override
    public void crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(int id, UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioRepository.findById(id)
                    .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
            modelMapper.map(usuarioDTO, usuario);
            usuarioRepository.save(usuario);
        }catch (RuntimeException e) {

        }
    }

    @Override
    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}
