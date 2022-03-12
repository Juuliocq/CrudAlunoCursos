/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author julio
 */
public class GerenciadorConexao {

    private final static String NOME_BD = "crud_alunos_cursos";
    private final static String PROPRIEDADES = "?createDatabaseIfNotExist=true&characterEncoding=UTF-8";
    private final static String HOST = "jdbc:mysql://localhost:3306/";
    private final static String URL_CONEXAO = HOST + NOME_BD + PROPRIEDADES;

    private final static String USUARIO = "root";
    private final static String SENHA = "";

    public static Connection connect() {
        Connection conn = null;
        
        try {

            conn = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            System.out.println("A conexão com o MySQL foi estabalecida.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
