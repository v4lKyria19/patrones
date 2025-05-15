package com.citizentech.presentacion;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.citizentech.service.InterfazCitaDAO;

@Path("/cita")
public class ServiciosCita {
    
    static final Logger logger = Logger.getLogger(ServiciosUsuario.class);
    private static final String ERROR = "Error";
    private static final String OPTIONS = "OPTIONS";

    @Inject
    private InterfazCitaDAO dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ultimacita/{id_usuario}")
    public Response getUltimaCita(@PathParam("id_usuario") int idUsuario){
        String respuestaJson;

        try {
            respuestaJson = dao.obtenerUltimaCita(idUsuario);
        } catch (Exception e){
            logger.error(ERROR, e);
            throw new RuntimeException(e);
        }
        return Response.ok()    //200
            .entity(respuestaJson)
            .allow(OPTIONS).build();   
    }
}
