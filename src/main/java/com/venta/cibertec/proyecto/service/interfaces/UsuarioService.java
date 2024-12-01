package com.venta.cibertec.proyecto.service.interfaces;


import com.venta.cibertec.proyecto.presentation.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO obtenerUsuarioPorId(int id);
    void crearUsuario(UsuarioDTO usuarioDTO);
    void actualizarUsuario(int id, UsuarioDTO usuarioDTO);
    void eliminarUsuario(int id);
}
