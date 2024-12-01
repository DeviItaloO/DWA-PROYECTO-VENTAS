package com.venta.cibertec.proyecto.service.implementation;

import com.venta.cibertec.proyecto.presentation.dto.UsuarioDTO;
import com.venta.cibertec.proyecto.service.interfaces.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return List.of();
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(int id) {
        return null;
    }

    @Override
    public void crearUsuario(UsuarioDTO usuarioDTO) {

    }

    @Override
    public void actualizarUsuario(int id, UsuarioDTO usuarioDTO) {

    }

    @Override
    public void eliminarUsuario(int id) {

    }
}
