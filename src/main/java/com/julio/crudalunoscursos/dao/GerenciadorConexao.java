/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <b>Classe responsável por prover conexão com o banco de dados.</b>
 *
 * @author julio
 * @version 1.0
 */
public class GerenciadorConexao {

    /**
     * <b>Nome da base de dados.</b>
     */
    private final static String NOME_BD = "crud_alunos_cursos";

    /**
     * <b>Configurações que podem ser adicionadas na requisição.</b>
     */
    private final static String PROPRIEDADES = "?createDatabaseIfNotExist=true&characterEncoding=UTF-8";

    /**
     * <b>Host onde está hospedado o banco de dados.</b>
     */
    private final static String HOST = "localhost:3306/";

    /**
     * <b>Driver que está sendo utilizado.</b>
     */
    private final static String DRIVER = "jdbc:mysql://";

    /**
     * <b>Url final de conexão com o banco de dados.</b>
     */
    private final static String URL_CONEXAO = DRIVER + HOST + NOME_BD + PROPRIEDADES;

    /**
     * <b>Usuario de acesso ao banco de dados.</b>
     */
    private final static String USUARIO = "root";

    /**
     * <b>Senha de acesso ao banco de dados.</b>
     */
    private final static String SENHA = "";

    /**
     * <b>Retorna um objeto de conexão com o banco de dados.</b>
     * <p>Se falhar, retorna uma SQLExcpetion no console.</p>
     *
     * @return conn Connection - objeto de conexão com o banco de dados.
     */
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
