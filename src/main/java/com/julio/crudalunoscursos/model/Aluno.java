/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.model;

import java.util.ArrayList;

/**
 * <b>Classe que representa a entidade de domínio Aluno</b>
 * @version 1.0
 * @author julio
 */
public class Aluno {

    /**
     * <b>Código do aluno.</b>
     */
    private int codigo;

    /**
     * <b>Nome do aluno.</b>
     */
    private String nome;

    /**
     * <b>Lista de cursos que o aluno faz.</b>
     */
    private ArrayList<Curso> listaDeCursosDoAluno;

    /**
     * <b>Lista de cursos que o aluno não faz.</b>
     */
    private ArrayList<Curso> listaDeCursosQueAlunoNaoFaz;

    /**
     * <b>Construtor padrão.</b>
     */
    public Aluno() {
    }

    /**
     * <b>Construtor com apenas código do aluno.</b>
     *
     * @param codigo
     */
    public Aluno(int codigo) {
        this.codigo = codigo;
    }

    /**
     * <b>Construtor com apenas nome do aluno.</b>
     *
     * @param nome
     */
    public Aluno(String nome) {
        this.nome = nome;
    }

    /**
     * <b>Construtor com código e nome do aluno</b>
     * @param codigo
     * @param nome 
     */
    public Aluno(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    /**
     * <b>Construtor com codigo, lista de cursos que o aluno faz e lista de cursos
     * que o aluno não faz.</b>
     *
     * @param codigo int - Código do aluno.
     * @param listaDeCursosDoAluno ArrayList - Lista de cursos que o aluno faz.
     * @param listaDeCursosQueAlunoNaoFaz ArrayList - Lista de cursos que o
     * aluno não faz.
     */
    public Aluno(int codigo, ArrayList<Curso> listaDeCursosDoAluno, ArrayList<Curso> listaDeCursosQueAlunoNaoFaz) {
        this.codigo = codigo;
        this.listaDeCursosDoAluno = listaDeCursosDoAluno;
        this.listaDeCursosQueAlunoNaoFaz = listaDeCursosQueAlunoNaoFaz;
    }

    /**
     * @return codigo int - Código do aluno.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo int - Código do aluno.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * 
     * @return nome String - Nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @param nome String - Nome do aluno.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @return listaDeCursosDoAluno ArrayList - Lista de cursos que o aluno faz.
     */
    public ArrayList<Curso> getListaDeCursosDoAluno() {
        return listaDeCursosDoAluno;
    }

    /**
     * 
     * @param listaDeCursosDoAluno ArrayList - Lista de cursos que o aluno faz.
     */
    public void setListaDeCursosDoAluno(ArrayList<Curso> listaDeCursosDoAluno) {
        this.listaDeCursosDoAluno = listaDeCursosDoAluno;
    }

    /**
     * 
     * @return listaDeCursosQueAlunoNaoFaz ArrayList - Lista de cursos que o aluno não faz.
     */
    public ArrayList<Curso> getListaDeCursosQueAlunoNaoFaz() {
        return listaDeCursosQueAlunoNaoFaz;
    }

    /**
     * 
     * @param listaDeCursosQueAlunoNaoFaz ArrayList - Lista de cursos que o aluno não faz.
     */
    public void setListaDeCursosQueAlunoNaoFaz(ArrayList<Curso> listaDeCursosQueAlunoNaoFaz) {
        this.listaDeCursosQueAlunoNaoFaz = listaDeCursosQueAlunoNaoFaz;
    }

}
