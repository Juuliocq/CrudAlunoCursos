/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.validation;

/**
 *
 * @author julio
 */
public class Validacao {

    public static boolean validaSeEstaVazio(String txt) {
        
        boolean eValido = !(txt == null || txt.equals(""));
        
        return eValido;
    }
}
