package com.citizentech.service;

import java.sql.ResultSet;

import com.citizentech.model.Cita;

public interface InterfazCitaDAO {
    
    public String obtenerUltimaCita(int idUsuario);
    public Cita procesarCita(ResultSet resultSet);
}
