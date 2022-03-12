/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.dao;

import com.julio.crudalunoscursos.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author julio
 */
public class AlunoDAO {

    private Connection conn;

    public AlunoDAO() {
    }

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

    public ArrayList<Aluno> buscaTodosOsAlunos() {

        ResultSet resultSet;
        ArrayList<Aluno> listaAluno = new ArrayList<>();

        try ( PreparedStatement queryBuscaTodosOsAlunos = this.conn
                .prepareStatement("SELECT * FROM Aluno");) {

            resultSet = queryBuscaTodosOsAlunos.executeQuery();

            while (resultSet.next()) {
                Aluno aluno = new Aluno();

                aluno.setCodigo(resultSet.getInt("codigo"));
                aluno.setNome(resultSet.getString("nome"));

                listaAluno.add(aluno);
            }

            queryBuscaTodosOsAlunos.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAluno;
    }

    public boolean alteraAluno(int codigo, String nome) {
        
        boolean sucesso = false;
        Aluno aluno = new Aluno(codigo, nome);

        try ( PreparedStatement queryAlteraAluno = this.conn
                .prepareStatement("UPDATE Aluno SET nome = ? WHERE codigo = ?");) {

            queryAlteraAluno.setString(1, aluno.getNome());
            queryAlteraAluno.setInt(2, aluno.getCodigo());

            queryAlteraAluno.execute();
            queryAlteraAluno.close();
            
            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sucesso;
    }
    
    public boolean excluiAluno(int codigo) {
        
        boolean sucesso = false;
        Aluno aluno = new Aluno(codigo);

        try ( PreparedStatement queryAlteraAluno = this.conn
                .prepareStatement("DELETE FROM Aluno WHERE codigo = ?");) {

            queryAlteraAluno.setInt(1, aluno.getCodigo());

            queryAlteraAluno.execute();
            queryAlteraAluno.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sucesso;
    }
}
