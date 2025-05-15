package com.citizentech.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Respuesta {
    
    @JsonProperty("estado")
    private String estado;
    @JsonProperty("registros_insertados")
    private Integer registrosInsertados;
    @JsonProperty("registros_actualizados")
    private Integer registrosActualizados;
    @JsonProperty("registros_eliminados")
    private Integer registrosEliminados;
    @JsonProperty("id_usuario")
    private Integer idUsuario;

    @JsonProperty("estado")
    public String getEstado() {
        return estado;
    }

    @JsonProperty("estado")
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JsonProperty("registros_insertados")
    public Integer getRegistrosInsertados() {
        return registrosInsertados;
    }

    @JsonProperty("registros_insertados")
    public void setRegistrosInsertados(Integer filasInsertadas) {
        this.registrosInsertados = filasInsertadas;
    }

    @JsonProperty("registros_actualizados")
    public Integer getRegistrosActualizados() {
        return registrosActualizados;
    }

    @JsonProperty("registros_actualizados")
    public void setRegistrosActualizados(Integer filasActualizadas) {
        this.registrosActualizados = filasActualizadas;
    }

    @JsonProperty("registros_eliminados")
    public Integer getRegistrosEliminados() {
        return registrosEliminados;
    }

    @JsonProperty("registros_eliminados")
    public void setRegistrosEliminados(Integer filasEliminadas) {
        this.registrosEliminados = filasEliminadas;
    }

    @JsonProperty("id_usuario")
    public Integer getIdUsuario() {
        return idUsuario;
    }

    @JsonProperty("id_usuario")
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
