package com.citizentech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cita {

    @JsonProperty("id_tramite")
    private int idTramite;
    @JsonProperty("nombre_tramite")
    private String nombreTramite;
    @JsonProperty("id_usuario")
    private int idUsuario;
    @JsonProperty("numero_identificacion_usuario")
    private String numeroIdentificacionUsuario;
    @JsonProperty("nombres_usuario")
    private String nombresUsuario;
    @JsonProperty("apellidos_usuario")
    private String apellidosUsuario;
    @JsonProperty("id_entidad")
    private int idEntidad;
    @JsonProperty("nombre_entidad")
    private String nombreEntidad;
    @JsonProperty("direccion_entidad")
    private String direccionEntidad;
    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("hora")
    private String hora;

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
    public void setNombreTramite(String nombre) {
        this.nombreTramite = nombre;
    }

    @JsonProperty("id_usuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    @JsonProperty("id_usuario")
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @JsonProperty("numero_identificacion_usuario")
    public String getNumeroIdentificacionUsuario() {
        return numeroIdentificacionUsuario;
    }

    @JsonProperty("numero_identificacion_usuario")
    public void setNumeroIdentificacionUsuario(String numeroIdentificacionUsuario) {
        this.numeroIdentificacionUsuario = numeroIdentificacionUsuario;
    }

    @JsonProperty("nombres_usuario")
    public String getNombresUsuario() {
        return nombresUsuario;
    }

    @JsonProperty("nombres_usuario")
    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    @JsonProperty("apellidos_usuario")
    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    @JsonProperty("apellidos_usuario")
    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
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

    @JsonProperty("direccion_entidad")
    public String getDireccionEntidad() {
        return direccionEntidad;
    }

    @JsonProperty("direccion_entidad")
    public void setDireccionEntidad(String direccionEntidad) {
        this.direccionEntidad = direccionEntidad;
    }

    @JsonProperty("fecha")
    public String getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @JsonProperty("hora")
    public String getHora() {
        return hora;
    }

    @JsonProperty("hora")
    public void setHora(String hora) {
        this.hora = hora;
    }
}
