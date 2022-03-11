/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author julio
 */
public class CriaBanco {

    private Connection conn;

    public CriaBanco(Connection conexao) {
        conn = conexao;
    }

    public void criaBanco() {
        try {
            PreparedStatement queryAluno = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Aluno ("
                    + "codigo INT NOT NULL AUTO_INCREMENT,"
                    + "nome VARCHAR(50),"
                    + "PRIMARY KEY (codigo));");

            PreparedStatement queryCurso = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Curso ("
                    + "codigo INT NOT NULL AUTO_INCREMENT, "
                    + "descricao VARCHAR(50), "
                    + "ementa TEXT, "
                    + "PRIMARY KEY (codigo))");

            PreparedStatement queryCursoAluno = conn.prepareStatement("CREATE TABLE IF NOT EXISTS CursoAluno ("
                    + "codigo INT NOT NULL AUTO_INCREMENT,"
                    + "codigo_aluno INT,"
                    + "codigo_curso INT,"
                    + "PRIMARY KEY (codigo),"
                    + "FOREIGN KEY (codigo_aluno) REFERENCES Aluno(codigo),"
                    + "FOREIGN KEY (codigo_curso) REFERENCES Curso(codigo));");

            queryAluno.execute();
            queryCurso.execute();
            queryCursoAluno.execute();

            System.out.println(queryAluno);
            System.out.println(queryCurso);
            System.out.println(queryCursoAluno);

            queryAluno.close();
            queryCurso.close();
            queryCursoAluno.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
