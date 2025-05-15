package com.citizentech.presentacion;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.citizentech.service.InterfazUsuarioDAO;

import javax.ws.rs.PathParam;

@Path("/usuario")
public class ServiciosUsuario {
    
    static final Logger logger = Logger.getLogger(ServiciosUsuario.class);
    private static final String ERROR = "Error";
    private static final String OPTIONS = "OPTIONS";

    @Inject
    private InterfazUsuarioDAO dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_usuario}")
    public Response getDatosUsuario(@PathParam("id_usuario") int idUsuario){
        String respuestaJson;

        try {
            respuestaJson = dao.obtenerDatosUsuario(idUsuario);
        } catch (Exception e){
            logger.error(ERROR, e);
            throw new RuntimeException(e);
        }
        return Response.ok()    //200
            .entity(respuestaJson)
            .allow(OPTIONS).build();   
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response postIniciarSesion(String usuarioJson) {
        String respuestaJson;

        try {
            respuestaJson = dao.iniciarSesion(usuarioJson);
        } catch (Exception e){
            logger.error(ERROR, e);
            throw new RuntimeException(e);
        }
        return Response.ok()    //200
            .entity(respuestaJson)
            .allow(OPTIONS).build();   
    } 

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public Response postRegistrarUsuario(String usuarioJson) {
        String respuestaJson;

        try {
            respuestaJson = dao.registrarUsuario(usuarioJson);
        } catch (Exception e){
            logger.error(ERROR, e);
            throw new RuntimeException(e);
        }
        return Response.ok()    //200
            .entity(respuestaJson)
            .allow(OPTIONS).build();
    }
}