/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.validation;

/**
 * <b>Classe que contém um método de validação de campo.</b>
 * @version 1.0
 * @author julio
 */
public class Validacao {

    /**
     * <b>Valida se o campo de texto está vazio ou nulo.</b>
     * <p>Usado na validação de nome de aluno e descrição de curso.</p>
     * 
     * @param txt String - Texto a ser validado
     * @return eValido boolean - Contém V/F, se é valido ou não.
     */
    public static boolean validaSeEstaVazio(String txt) {
        
        boolean eValido = !(txt == null || txt.equals(""));
        
        return eValido;
    }
}
