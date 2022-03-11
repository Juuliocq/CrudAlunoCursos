/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.dao;

import com.julio.crudalunoscursos.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author julio
 */
public class AlunoDAO {

    private final Connection conn;

    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean adicionaAluno(String nome) {
        
        boolean sucesso = false;
        Aluno aluno = new Aluno(nome);
        
        try ( PreparedStatement queryAddAluno = this.conn
                .prepareStatement("INSERT INTO Aluno(nome) VALUE (?)");) {

            queryAddAluno.setString(1, aluno.getNome());

            queryAddAluno.execute();
            queryAddAluno.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sucesso;
    }
}
