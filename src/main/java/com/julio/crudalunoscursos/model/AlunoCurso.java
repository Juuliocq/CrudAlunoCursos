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
public class AlunoCurso {

    private int codigo;
    private ArrayList<Aluno> alunos;
    private ArrayList<Curso> cursos;

    public AlunoCurso(int codigo, ArrayList<Aluno> alunos, ArrayList<Curso> cursos) {
        this.codigo = codigo;
        this.alunos = alunos;
        this.cursos = cursos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    

}
