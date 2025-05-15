package com.citizentech.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.citizentech.model.Cita;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CitaDAO implements InterfazCitaDAO{

    static final Logger logger = Logger.getLogger(UsuarioDAO.class);
    private static final String ERROR = "Error";

    private final String QRY_CITA = ""
        + " SELECT t.id_tramite, t.nombre as nombre_tramite, u.id_usuario, "
        + " u.numero_identificacion as numero_identificacion_usuario, u.nombres as nombres_usuario, "
        + " u.apellidos as apellidos_usuario, e.id_entidad, e.nombre as nombre_entidad, "
        + " e.direccion as direccion_entidad, to_char(now()::date + 7 , 'DD-MM-YYYY') as fecha, "
        + " '13:00' as hora "
        + " FROM tramite t, usuario u, entidad e, entidad_tramite et, usuario_tramite ut "
        + " WHERE e.id_entidad = et.id_entidad "
        + "     AND t.id_tramite = et.id_tramite "
        + "     AND u.id_usuario = ut.id_usuario "
        + "     AND t.id_tramite = ut.id_tramite ";

    @Override
    public String obtenerUltimaCita(int idUsuario) {
        String sql = QRY_CITA;
        sql += " AND u.id_usuario = ? ";
        sql += " ORDER BY ut.fecha_registro DESC ";
        sql += " LIMIT 1 ";

        Cita respuestaCita;
        String respuestaJson = "{\"estado\": \"fallido\"}";

        try (Connection c = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);){
            ObjectMapper mapper = new ObjectMapper();

            preparedStatement.setInt(1, idUsuario);

            try (ResultSet resultSet = preparedStatement.executeQuery();){
                if (resultSet.next()){
                    respuestaCita = procesarCita(resultSet);
                    respuestaJson = mapper.writeValueAsString(respuestaCita);
                }
            } catch (Exception e){
                logger.error(ERROR, e);
            }
        } catch (Exception e){
            logger.error(ERROR, e);
        }

        return respuestaJson;
    }

    public Cita procesarCita(ResultSet resultSet) {
        Cita cita = new Cita();

        try {
            cita.setIdTramite(resultSet.getInt("id_tramite"));
            cita.setNombreTramite(resultSet.getString("nombre_tramite"));
            cita.setIdUsuario(resultSet.getInt("id_usuario"));
            cita.setNumeroIdentificacionUsuario(resultSet.getString("numero_identificacion_usuario"));
            cita.setNombresUsuario(resultSet.getString("nombres_usuario"));
            cita.setApellidosUsuario(resultSet.getString("apellidos_usuario"));
            cita.setIdEntidad(resultSet.getInt("id_entidad"));
            cita.setNombreEntidad(resultSet.getString("nombre_entidad"));
            cita.setDireccionEntidad(resultSet.getString("direccion_entidad"));
            cita.setFecha(resultSet.getString("fecha"));
            cita.setHora(resultSet.getString("hora"));
        } catch (Exception e) {
            logger.error(ERROR, e);
        }

        return cita;
    }
}
