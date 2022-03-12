/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.dao;

import com.julio.crudalunoscursos.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                .prepareStatement("INSERT INTO curso(descricao, ementa) VALUE (?, ?)");) {

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

    public ArrayList<Curso> buscaTodosOsCursos() {

        ResultSet resultSet;
        ArrayList<Curso> listaCurso = new ArrayList<>();

        try ( PreparedStatement queryBuscaTodosOsCursos = this.conn
                .prepareStatement("SELECT * FROM curso");) {

            resultSet = queryBuscaTodosOsCursos.executeQuery();

            while (resultSet.next()) {
                Curso curso = new Curso();

                curso.setCodigo(resultSet.getInt("codigo"));
                curso.setDescricao(resultSet.getString("descricao"));
                curso.setEmenta(resultSet.getString("ementa"));

                listaCurso.add(curso);
            }

            queryBuscaTodosOsCursos.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCurso;
    }

    public boolean alteraCurso(int codigo, String descricao, String ementa) {

        boolean sucesso = false;
        Curso curso = new Curso(codigo, descricao, ementa);

        try ( PreparedStatement queryAlteraCurso = this.conn
                .prepareStatement("UPDATE curso SET descricao = ?, ementa = ? WHERE codigo = ?");) {

            queryAlteraCurso.setString(1, curso.getDescricao());
            queryAlteraCurso.setString(2, curso.getEmenta());
            queryAlteraCurso.setInt(3, curso.getCodigo());

            queryAlteraCurso.execute();
            queryAlteraCurso.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sucesso;
    }

    public boolean excluiCurso(int codigo) {

        boolean sucesso = false;
        Curso curso = new Curso(codigo);

        try ( PreparedStatement queryDeletaCurso = this.conn
                .prepareStatement("DELETE FROM curso WHERE codigo = ?");) {

            queryDeletaCurso.setInt(1, curso.getCodigo());

            queryDeletaCurso.execute();
            queryDeletaCurso.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return sucesso;
    }
}
