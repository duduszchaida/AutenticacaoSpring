package com.vedoble.web.entity;

public enum UsuaPerfil {
    ADMIN("admin"),
    USUA("user");
    private String perfil;
    UsuaPerfil(String perfil){
        this.perfil = perfil;
    }
    public String getPerfil(){
        return perfil;
    }
}
