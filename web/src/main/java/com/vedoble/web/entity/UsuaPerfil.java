package com.vedoble.web.entity;

public enum UsuaPerfil {
    ADMIN("admin"),
    USUA("user");
    public String perfil;
    UsuaPerfil(String perfil){
        this.perfil = perfil;
    }
    public String getPerfil(){
        return perfil;
    }
}
