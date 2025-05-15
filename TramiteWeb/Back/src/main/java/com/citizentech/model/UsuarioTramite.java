package com.citizentech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioTramite {
    
    @JsonProperty("contador_registro")
    private int contadorRegistro;
    @JsonProperty("id_usuario")
    private int idUsuario;
    @JsonProperty("id_tramite")
    private int idTramite;
    @JsonProperty("nombre_tramite")
    private String nombreTramite;
    @JsonProperty("id_entidad")
    private int idEntidad;
    @JsonProperty("nombre_entidad")
    private String nombreEntidad;
    @JsonProperty("fecha_registro")
    private String fechaRegistro;

    @JsonProperty("contador_registro")
    public int getContadorRegistro() {
        return contadorRegistro;
    }

    @JsonProperty("contador_registro")
    public void setContadorRegistro(int contadorRegistro) {
        this.contadorRegistro = contadorRegistro;
    }

    @JsonProperty("id_usuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    @JsonProperty("id_usuario")
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @JsonProperty("id_tramite")
    public int getIdTramite() {
        return idTramite;
    }

    @JsonProperty("id_tramite")
    public void setIdTramite(int idTramite) {
        this.idTramite = idTramite;
    }

    @JsonProperty("nombre_tramite")
    public String getNombreTramite() {
        return nombreTramite;
    }

    @JsonProperty("nombre_tramite")
    public void setNombreTramite(String nombreTramite) {
        this.nombreTramite = nombreTramite;
    }

    @JsonProperty("id_entidad")
    public int getIdEntidad() {
        return idEntidad;
    }

    @JsonProperty("id_entidad")
    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    @JsonProperty("nombre_entidad")
    public String getNombreEntidad() {
        return nombreEntidad;
    }

    @JsonProperty("nombre_entidad")
    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    @JsonProperty("fecha_registro")
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    @JsonProperty("fecha_registro")
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
