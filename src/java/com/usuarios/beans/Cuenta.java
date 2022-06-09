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
public class Cuenta extends Usuarios implements Tarjeta{
    private int id_cuenta;
    private double saldo;
    private String tipo;
    private int numero;

    public Cuenta() {
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void NombreTarjeta(String Nombre) {
        System.out.println("Nombre tarjeta"+Nombre);
    }
    
    
}
