/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.beans;

/**
 *
 * @author clavi
 */
public class Clases_usuarios<T> {
    private T id_clase_u;
    private T descripcion;

    public Clases_usuarios() {
    }

    public T getId_clase_u() {
        return id_clase_u;
    }

    public void setId_clase_u(T id_clase_u) {
        this.id_clase_u = id_clase_u;
    }

    public T getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(T descripcion) {
        this.descripcion = descripcion;
    }
    
    

    
    
    
}
