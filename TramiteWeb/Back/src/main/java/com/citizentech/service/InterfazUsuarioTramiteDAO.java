package com.citizentech.service;

import java.sql.ResultSet;

import com.citizentech.model.Respuesta;
import com.citizentech.model.UsuarioTramite;

public interface InterfazUsuarioTramiteDAO {
    
    public String registrarUsuarioTramite(String usuarioTramiteJson);
    public String historialUsuarioTramite(int idUsuario);
    public UsuarioTramite procesarUsuarioTramite(ResultSet resultSet);
    public Respuesta procesarRespuesta(boolean exito, int registrosInsertados, int registrosActualizados, int registrosEliminados);
}
