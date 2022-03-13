/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.model;

import java.util.ArrayList;

/**
 * <b>Classe que representa a entidade de domínio Curso</b>
 * @version 1.0
 * @author julio
 */
public class Curso {

    /**
     * <b>Código do curso.</b>
     */
    private int codigo;

    /**
     * <b>Descrição do curso.</b>
     */
    private String descricao;

    /**
     * <b>Ementa do curso.</b>
     */
    private String ementa;

    /**
     * <b>Lista de alunos que fazem o curso.</b>
     */
    private ArrayList<Aluno> listaDeAlunosDentroDoCurso;

    /**
     * <b>Lista de alunos que não fazem o curso.</b>
     */
    private ArrayList<Aluno> listaDeAlunosForaDoCurso;

    /**
     * <b>Construtor paadrão.</b>
     */
    public Curso() {
    }

    /**
     * <b>Construtor com código do curso.</b>
     *
     * @param codigo int - Código do curso.
     */
    public Curso(int codigo) {
        this.codigo = codigo;
    }

    /**
     * <b>Construtor com descrição e ementa.</b>
     *
     * @param descricao String - Descrição do curso.
     * @param ementa String - Ementa do curso.
     */
    public Curso(String descricao, String ementa) {
        this.descricao = descricao;
        this.ementa = ementa;
    }

    /**
     * <b>Construtor com código, descrição e ementa.</b>
     *
     * @param codigo int - Código do curso.
     * @param descricao String - Descrição do curso.
     * @param ementa String - Ementa do curso.
     */
    public Curso(int codigo, String descricao, String ementa) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.ementa = ementa;
    }

    /**
     * <b>Construtor com código, lista de alunos que fazem o curso e lista de
     * alunos que não fazem o curso.</b>
     *
     * @param codigo int - Código do curso.
     * @param listaDeAlunosDentroDoCurso ArrayList - Lista de alunos dentro do
     * curso.
     * @param listaDeAlunosForaDoCurso ArrayList - Lista de alunos que não fazem
     * o curso.
     */
    public Curso(int codigo, ArrayList<Aluno> listaDeAlunosDentroDoCurso, ArrayList<Aluno> listaDeAlunosForaDoCurso) {
        this.codigo = codigo;
        this.listaDeAlunosDentroDoCurso = listaDeAlunosDentroDoCurso;
        this.listaDeAlunosForaDoCurso = listaDeAlunosForaDoCurso;
    }

    /**
     *
     * @return codigo int - Código do curso.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo int - Código do curso.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return descricao String - Descrição do curso.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao String - Descrição do curso.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return ementa String - Ementa do curso.
     */
    public String getEmenta() {
        return ementa;
    }

    /**
     *
     * @param ementa String - Ementa do curso.
     */
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    /**
     *
     * @return listaDeAlunosDentroDoCurso ArrayList - Lista de alunos dentro do
     * curso.
     */
    public ArrayList<Aluno> getListaDeAlunosDentroDoCurso() {
        return listaDeAlunosDentroDoCurso;
    }

    /**
     *
     * @param listaDeAlunosDentroDoCurso ArrayList - Lista de alunos dentro do
     * curso.
     */
    public void setListaDeAlunosDentroDoCurso(ArrayList<Aluno> listaDeAlunosDentroDoCurso) {
        this.listaDeAlunosDentroDoCurso = listaDeAlunosDentroDoCurso;
    }

    /**
     *
     * @return listaDeAlunosForaDoCurso ArrayList - Lista de alunos dentro do
     * curso.
     */
    public ArrayList<Aluno> getListaDeAlunosForaDoCurso() {
        return listaDeAlunosForaDoCurso;
    }

    /**
     *
     * @param listaDeAlunosForaDoCurso ArrayList - Lista de alunos dentro do
     * curso.
     */
    public void setListaDeAlunosForaDoCurso(ArrayList<Aluno> listaDeAlunosForaDoCurso) {
        this.listaDeAlunosForaDoCurso = listaDeAlunosForaDoCurso;
    }

}
