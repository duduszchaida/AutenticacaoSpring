package com.vedoble.web.Dto;

import com.vedoble.web.entity.UsuaPerfil;

public record RegisterDTO(String usualogin, String usuasenha, UsuaPerfil perfil) {
}
