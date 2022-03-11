/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author julio
 */
public class CriaBanco {
    
    private Connection conn;
    
    public CriaBanco(Connection conexao){
    conn = conexao;
            }

    public void criaBanco() {
        String queryAluno = "CREATE TABLE IF NOT EXISTS Aluno ("
                + "codigo INT NOT NULL AUTO_INCREMENT,"
                + "nome VARCHAR(50),"
                + "PRIMARY KEY (codigo));";

        String queryCurso = "CREATE TABLE IF NOT EXISTS Curso ("
                + "codigo INT NOT NULL AUTO_INCREMENT, "
                + "descricao VARCHAR(50), "
                + "ementa TEXT, "
                + "PRIMARY KEY (codigo))";

        String queryCursoAluno = "CREATE TABLE IF NOT EXISTS CursoAluno ("
                + "codigo INT NOT NULL AUTO_INCREMENT,"
                + "codigo_aluno INT,"
                + "codigo_curso INT,"
                + "PRIMARY KEY (codigo),"
                + "FOREIGN KEY (codigo_aluno) REFERENCES Aluno(codigo),"
                + "FOREIGN KEY (codigo_curso) REFERENCES Curso(codigo));";

        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(queryAluno);
            stmt.execute(queryCurso);
            stmt.execute(queryCursoAluno);

            System.out.println(queryAluno);
            System.out.println(queryCurso);
            System.out.println(queryCursoAluno);
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
