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
public class Aluno {

    private int codigo;
    private String nome;

    private ArrayList<Curso> listaDeCursosDoAluno;
    private ArrayList<Curso> listaDeCursosQueAlunoNaoFaz;

    public Aluno() {
    }

    public Aluno(int codigo) {
        this.codigo = codigo;
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Aluno(int codigo, ArrayList<Curso> listaDeCursosDoAluno, ArrayList<Curso> listaDeCursosQueAlunoNaoFaz) {
        this.codigo = codigo;
        this.listaDeCursosDoAluno = listaDeCursosDoAluno;
        this.listaDeCursosQueAlunoNaoFaz = listaDeCursosQueAlunoNaoFaz;
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

    public ArrayList<Curso> getListaDeCursosDoAluno() {
        return listaDeCursosDoAluno;
    }

    public void setListaDeCursosDoAluno(ArrayList<Curso> listaDeCursosDoAluno) {
        this.listaDeCursosDoAluno = listaDeCursosDoAluno;
    }

    public ArrayList<Curso> getListaDeCursosQueAlunoNaoFaz() {
        return listaDeCursosQueAlunoNaoFaz;
    }

    public void setListaDeCursosQueAlunoNaoFaz(ArrayList<Curso> listaDeCursosQueAlunoNaoFaz) {
        this.listaDeCursosQueAlunoNaoFaz = listaDeCursosQueAlunoNaoFaz;
    }

    
}
