/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.model;

import java.util.ArrayList;

/**
 *
 * @author julio
 */
public class Curso {

    private int codigo;
    private String descricao;
    private String ementa;

    private ArrayList<Aluno> listaDeAlunosDentroDoCurso;
    private ArrayList<Aluno> listaDeAlunosForaDoCurso;

    public Curso() {
    }

    public Curso(int codigo) {
        this.codigo = codigo;
    }

    public Curso(String descricao, String ementa) {
        this.descricao = descricao;
        this.ementa = ementa;
    }

    public Curso(int codigo, String descricao, String ementa) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.ementa = ementa;
    }

    public Curso(int codigo, ArrayList<Aluno> listaDeAlunosDentroDoCurso, ArrayList<Aluno> listaDeAlunosForaDoCurso) {
        this.codigo = codigo;
        this.listaDeAlunosDentroDoCurso = listaDeAlunosDentroDoCurso;
        this.listaDeAlunosForaDoCurso = listaDeAlunosForaDoCurso;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public ArrayList<Aluno> getListaDeAlunosDentroDoCurso() {
        return listaDeAlunosDentroDoCurso;
    }

    public void setListaDeAlunosDentroDoCurso(ArrayList<Aluno> listaDeAlunosDentroDoCurso) {
        this.listaDeAlunosDentroDoCurso = listaDeAlunosDentroDoCurso;
    }

    public ArrayList<Aluno> getListaDeAlunosForaDoCurso() {
        return listaDeAlunosForaDoCurso;
    }

    public void setListaDeAlunosForaDoCurso(ArrayList<Aluno> listaDeAlunosForaDoCurso) {
        this.listaDeAlunosForaDoCurso = listaDeAlunosForaDoCurso;
    }
    
    
}
