package com.venta.cibertec.proyecto.service.interfaces;


import com.venta.cibertec.proyecto.data.entity.Usuario;
import com.venta.cibertec.proyecto.presentation.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO obtenerUsuarioPorId(int id);
    boolean  crearUsuario(UsuarioDTO usuarioDTO);
    boolean  actualizarUsuario(int id, UsuarioDTO usuarioDTO);
    boolean  eliminarUsuario(int id);

    Usuario obtenerUsuarioPorUsername(String username);
}
