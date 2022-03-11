/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.model;

/**
 *
 * @author julio
 */
public class Curso {
    
    private int codigo;
    private String nome;
    private String ementa;

    public Curso() {}

    public Curso(int codigo, String nome, String ementa) {
        this.codigo = codigo;
        this.nome = nome;
        this.ementa = ementa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }
    
    
}
