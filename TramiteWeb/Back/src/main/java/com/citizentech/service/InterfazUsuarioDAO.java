package com.citizentech.service;

import java.sql.ResultSet;

import com.citizentech.model.Respuesta;
import com.citizentech.model.Usuario;

public interface InterfazUsuarioDAO {
    
    public String obtenerDatosUsuario(int idUsuario);
    public String iniciarSesion(String usuarioJson);
    public String registrarUsuario(String usuarioJson);
    public Usuario procesarUsuario(ResultSet resultSet);
    public Respuesta procesarRespuesta(boolean exito, int registrosInsertados, int registrosActualizados, 
        int registrosEliminados);
    public Respuesta procesarRespuestaId(boolean exito, int registrosInsertados, int registrosActualizados, 
        int registrosEliminados, ResultSet resultSet);
}
