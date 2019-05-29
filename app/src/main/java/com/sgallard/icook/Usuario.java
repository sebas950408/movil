package com.sgallard.icook;

public class Usuario {

    private String correo;
    private String password;

    public Usuario(String correo, String password) {

        this.correo = correo;
        this.password = password;

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
