/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.rest;

import com.usuarios.beans.Clases_usuarios;
import com.usuarios.beans.Cuenta;
import com.usuarios.beans.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author clavi
 */
@Path("Usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of com.usuarios.rest.UsuarioResource
     * @return an instance of java.lang.String
     */
    @GET
     @Path("getjson")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hello World";
    }
    //Usuarios
    static final List<Usuarios> lista =new ArrayList<>();
    
    @GET
    @Path("listar")
    @Produces("application/json")
    public List<Usuarios> listar_usuarios() {
        Usuarios u = new Usuarios();
        u.setId_usuario(1);
        u.setCedula(1718015521);
        u.setNombre("Andres");
        u.setApellido("Lopez");
        u.setDescripcion("Natural");
        lista.add(u);      
        return lista;
    }
    
    @POST
    @Path("guardar")
    @Produces("application/json")
    @Consumes("application/json")
    public List<Usuarios> guardar(Usuarios u) throws Exception {
       
        try {
            lista.add(u); 
        } catch (Exception e) {
          throw new Exception("Error ");
        }
             
        return lista;
    }
    
    @POST
    @Produces("application/json")
    @Path("buscar/{cedula}")
    public Usuarios buscar(@PathParam("cedula") String id) throws Exception {
        Usuarios resp = new Usuarios();
        int id_obtenido = 0;
        
        try {

            id_obtenido =Integer.parseInt(id);//Forzar error
        }

        catch (Exception e) {

            throw new Exception("Error de convercion a entero");

        }
       
        
        
        if (id.length() < 10) {
            throw new ArithmeticException("Debe tener al menos 10 caracteres");
        }
        else {
          for(Usuarios u:lista){
                if (u.getCedula() == id_obtenido) {
                     resp.setCedula(u.getCedula());
                    resp.setId_usuario(u.getId_usuario());
                    resp.setNombre(u.getNombre());
                    resp.setApellido(u.getApellido());
                    resp.setDescripcion(u.getDescripcion());
                }
            }

            return resp;
        }
        
    }
    
     @POST
    @Produces("application/json")
    @Path("borrar/{cedula}")
    public List<Usuarios> borrar(@PathParam("cedula") String id) {
        Usuarios resp = new Usuarios();
        for(Usuarios u:lista){
            if (u.getCedula() == Integer.parseInt(id)) {
                 
                lista.remove(u); 
            }
        }
           
             
        return lista;
    }
    
    //Cuenta
    static final List<Cuenta> lista_c =new ArrayList<>();
    
    @GET
    @Path("listar_c")
    @Produces("application/json")
    public List<Cuenta> listar_cuentas() {
        Cuenta u = new Cuenta();
        u.setId_cuenta(1);
        u.setNumero(25412543);
        u.setSaldo(15.20);
        u.setTipo("Ahorros");
        u.setCedula(1718018870);
        u.NombreTarjeta("Daniel Armijos");
        lista_c.add(u);      
        return lista_c;
    }
    
    @POST
    @Path("guardar_c")
    @Produces("application/json")
    @Consumes("application/json")
    public List<Cuenta> guardar(Cuenta u) {
        lista_c.add(u);      
        return lista_c;
    }
    
    @POST
    @Produces("application/json")
    @Path("buscar_c/{cuenta}")
    public Cuenta buscar_c(@PathParam("cuenta") String cuenta) {
        Cuenta resp = new Cuenta();
        if (cuenta.length() <= 1) {
            throw new ArithmeticException("Debe tener al menos 10 caracteres");
        }
        else {
            for(Cuenta u:lista_c){
                if (u.getNumero()== Integer.parseInt(cuenta)) {
                     resp.setId_cuenta(u.getId_cuenta());
                    resp.setNumero(u.getNumero());
                    resp.setSaldo(u.getSaldo());
                    resp.setTipo(u.getTipo());
                    resp.setCedula(u.getCedula());

                }
            }
        }
        
           
        return resp;
    }
    
     @POST
    @Produces("application/json")
    @Path("borrar_c/{cuenta}")
    public List<Cuenta> borrar_c(@PathParam("cuenta") String cuenta) {
        Cuenta resp = new Cuenta();
        for(Cuenta u:lista_c){
            if (u.getNumero()== Integer.parseInt(cuenta)) {
                 
                lista_c.remove(u); 
            }
        }
                   
        return lista_c;
    }

    //Clase usuario
    static final List<Clases_usuarios> lista_clu =new ArrayList<>();
    
    @GET
    @Path("listar_clu")
    @Produces("application/json")
    public List<Clases_usuarios> listar_clu() {
        Clases_usuarios u = new Clases_usuarios();
        u.setId_clase_u(1);
        u.setDescripcion("Natural");
        lista_clu.add(u);      
        return lista_clu;
    }
    
    @POST
    @Path("guardar_clu")
    @Produces("application/json")
    @Consumes("application/json")
    public List<Clases_usuarios> guardar_clu(Clases_usuarios u) {
        lista_clu.add(u);      
        return lista_clu;
    }
    
    @POST
    @Produces("application/json")
    @Path("buscar_clu/{id}")
    public Clases_usuarios buscar_clu(@PathParam("id") String id) {
        Clases_usuarios resp = new Clases_usuarios();
        for(Clases_usuarios u:lista_clu){
            if (u.getId_clase_u() == id) {
                 resp.setId_clase_u(u.getId_clase_u());
                resp.setDescripcion(u.getDescripcion());
            }
        }
           
        return resp;
    }
    
     @POST
    @Produces("application/json")
    @Path("borrar_clu/{id}")
    public List<Clases_usuarios> borrar_clu(@PathParam("id") String id) {
        Clases_usuarios<String> resp = new Clases_usuarios<>();
        for(Clases_usuarios u:lista_clu){
            if (u.getId_clase_u()== id) {
                 
                lista_clu.remove(u); 
            }
        }
           
             
        return lista_clu;
    }
    
    /**
     * PUT method for updating or creating an instance of UsuarioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
