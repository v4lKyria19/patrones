package com.citizentech.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usuario {
    
    @JsonProperty("numero_identificacion")
    private String numeroIdentificacion;
    @JsonProperty("nombres")
    private String nombres;
    @JsonProperty("apellidos")
    private String apellidos;
    @JsonProperty("contraseña")
    private String contraseña;

    @JsonProperty("numero_identificacion")
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    @JsonProperty("numero_identificacion")
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    @JsonProperty("nombres")
    public String getNombres() {
        return nombres;
    }

    @JsonProperty("nombres")
    public void setNombres(String primerNombre) {
        this.nombres = primerNombre;
    }

    @JsonProperty("apellidos")
    public String getApellidos() {
        return apellidos;
    }

    @JsonProperty("apellidos")
    public void setApellidos(String primerApellido) {
        this.apellidos = primerApellido;
    }


    @JsonProperty("contraseña")
    public String getContraseña() {
        return contraseña;
    }

    @JsonProperty("contraseña")
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}