/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <b>Classe responsável por criar todas as tabelas no banco de dados.</b>
 *
 * @version 1.0
 * @author julio
 */
public class CriaBanco {

    /**
     * <b>Cria todas as tabelas necessárias no banco de dados e retorna sucesso ou
     * falha no console.</b>
     * @param conn Connection - Objeto de conexão com banco de dados.
     */
    public static void criaBanco(Connection conn) {
        try ( PreparedStatement queryAluno = conn.prepareStatement("CREATE TABLE IF NOT EXISTS aluno ("
                        + "codigo INT NOT NULL AUTO_INCREMENT,"
                        + "nome VARCHAR(50),"
                        + "PRIMARY KEY (codigo));");
                
                PreparedStatement queryCurso = conn.prepareStatement("CREATE TABLE IF NOT EXISTS curso ("
                        + "codigo INT NOT NULL AUTO_INCREMENT, "
                        + "descricao VARCHAR(50), "
                        + "ementa TEXT, "
                        + "PRIMARY KEY (codigo))");
                
                PreparedStatement queryCursoAluno = conn.prepareStatement("CREATE TABLE IF NOT EXISTS curso_aluno ("
                        + "codigo INT NOT NULL AUTO_INCREMENT,"
                        + "codigo_aluno INT,"
                        + "codigo_curso INT,"
                        + "PRIMARY KEY (codigo),"
                        + "FOREIGN KEY (codigo_aluno) REFERENCES aluno(codigo),"
                        + "FOREIGN KEY (codigo_curso) REFERENCES curso(codigo));");) {

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
}
