package com.venta.cibertec.proyecto.presentation.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private int idUsuario;
    private String username;
    private String email;
    private String rol;
}
