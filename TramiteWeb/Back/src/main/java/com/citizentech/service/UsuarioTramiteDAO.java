package com.citizentech.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.citizentech.model.Respuesta;
import com.citizentech.model.UsuarioTramite;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsuarioTramiteDAO implements InterfazUsuarioTramiteDAO{

    static final Logger logger = Logger.getLogger(UsuarioTramiteDAO.class);
    private static final String ERROR = "Error";

    private int contadorRegistro = 0;

    private final String QRY_HISTORIAL_USUARIO_TRAMITE = ""
        + " SELECT u.id_usuario, t.id_tramite, t.nombre as nombre_tramite, e.id_entidad, e.nombre as nombre_entidad, "
        + "     to_char(ut.fecha_registro::date , 'DD-MM-YYYY') as fecha_registro"
        + "         FROM usuario u, tramite t, entidad e, entidad_tramite et, usuario_tramite ut "
        + "             WHERE ut.id_usuario = u.id_usuario "
        + "                 AND ut.id_tramite = t.id_tramite "
        + "                 AND et.id_entidad = e.id_entidad "
        + "                 AND et.id_tramite = t.id_tramite ";

    private final String QRY_REGISTRAR_USUARIO_TRAMITE = ""
        + " INSERT INTO public.usuario_tramite (id_usuario, id_tramite) ";

    @Override
    public String historialUsuarioTramite(int idUsuario) {
        String sql = QRY_HISTORIAL_USUARIO_TRAMITE;
        sql += " AND u.id_usuario = ? ";
        sql += " ORDER BY ut.fecha_registro DESC " ;
        sql += " LIMIT 5";

        List<UsuarioTramite> listaUsuarioTramite = new ArrayList<>();
        String listaUsuarioTramiteJson = "{\"estado\": \"fallido\"}";

        try (Connection c = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);){
        
            preparedStatement.setInt(1, idUsuario);

            try (ResultSet resultSet = preparedStatement.executeQuery();){
                while (resultSet.next()){
                    UsuarioTramite usuarioTramite = procesarUsuarioTramite(resultSet);

                    listaUsuarioTramite.add(usuarioTramite);
                    contadorRegistro++;
                }

                ObjectMapper mapper = new ObjectMapper();
                listaUsuarioTramiteJson = mapper.writeValueAsString(listaUsuarioTramite);
            } catch (Exception e){
                logger.error(ERROR, e);
            }
        } catch (Exception e){
            logger.error(ERROR, e);
        }

        return listaUsuarioTramiteJson;
    }

    @Override
    public String registrarUsuarioTramite(String usuarioTramiteJson) {
        String sql = QRY_REGISTRAR_USUARIO_TRAMITE;
        sql += " VALUES (?, ?) ";

        Respuesta respuesta;
        String respuestaJson = "{\"estado\": \"fallido\"}";
        int resultado;

        try (Connection c = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = c.prepareStatement(sql);){

            ObjectMapper mapper = new ObjectMapper();
            UsuarioTramite usuarioTramite = mapper.readValue(usuarioTramiteJson, UsuarioTramite.class);
        
            preparedStatement.setInt(1, usuarioTramite.getIdUsuario());
            preparedStatement.setInt(2, usuarioTramite.getIdTramite());

            resultado = preparedStatement.executeUpdate();

            respuesta = procesarRespuesta(resultado > 0, resultado, 0, 0);
            respuestaJson = mapper.writeValueAsString(respuesta);
        } catch (Exception e){
            logger.error(ERROR, e);
        }

        return respuestaJson;
    }

    @Override
    public UsuarioTramite procesarUsuarioTramite(ResultSet resultSet) {
        UsuarioTramite usuarioTramite = new UsuarioTramite();

        try {
            usuarioTramite.setContadorRegistro(contadorRegistro);
            usuarioTramite.setIdUsuario(resultSet.getInt("id_usuario"));
            usuarioTramite.setIdTramite(resultSet.getInt("id_tramite"));
            usuarioTramite.setNombreTramite(resultSet.getString("nombre_tramite"));
            usuarioTramite.setIdEntidad(resultSet.getInt("id_entidad"));
            usuarioTramite.setNombreEntidad(resultSet.getString("nombre_entidad"));
            usuarioTramite.setFechaRegistro(resultSet.getString("fecha_registro"));
        } catch (Exception e){
            logger.error(ERROR, e);
        }

        return usuarioTramite;
    }

    @Override
    public Respuesta procesarRespuesta(boolean exito, int registrosInsertados, int registrosActualizados, int registrosEliminados) {
        Respuesta respuesta = new Respuesta();

        if (exito){
            respuesta.setEstado("exito");
        } else {
            respuesta.setEstado("fallido");
        }
        
        if (registrosInsertados == 0){
            respuesta.setRegistrosInsertados(null);
        } else {
            respuesta.setRegistrosInsertados(registrosInsertados);
        }
        
        if (registrosActualizados == 0){
            respuesta.setRegistrosActualizados(null);
        } else {
            respuesta.setRegistrosActualizados(registrosActualizados);
        }
        
        if (registrosEliminados == 0) {
            respuesta.setRegistrosEliminados(null);
        } else {
            respuesta.setRegistrosEliminados(registrosEliminados);
        }

        return respuesta;
    }
}
