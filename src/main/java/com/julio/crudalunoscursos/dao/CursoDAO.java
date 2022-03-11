/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.dao;

import com.julio.crudalunoscursos.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author julio
 */
public class CursoDAO {

    private final Connection conn;

    public CursoDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean adicionaCurso(String descricao, String ementa) {

        boolean sucesso = false;
        Curso curso = new Curso(descricao, ementa);

        try ( PreparedStatement queryAddCurso = this.conn
                .prepareStatement("INSERT INTO Curso(descricao, ementa) VALUE (?, ?)");) {

            queryAddCurso.setString(1, curso.getDescricao());
            queryAddCurso.setString(2, curso.getEmenta());

            queryAddCurso.execute();
            queryAddCurso.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sucesso;
    }
}
