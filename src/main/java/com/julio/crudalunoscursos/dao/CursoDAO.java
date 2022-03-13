/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.dao;

import com.julio.crudalunoscursos.model.Aluno;
import com.julio.crudalunoscursos.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class CursoDAO {

    private final Connection conn;
    boolean sucesso = false;

    public CursoDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean adicionaCurso(String descricao, String ementa) {

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

        Curso curso = new Curso(codigo);

        try ( PreparedStatement queryDeletaCurso = this.conn
                .prepareStatement("DELETE FROM curso WHERE codigo = ?");) {

            queryDeletaCurso.setInt(1, curso.getCodigo());
            
            excluirTodosAlunosDoCurso(curso.getCodigo());

            queryDeletaCurso.execute();
            queryDeletaCurso.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return sucesso;
    }

    public Curso buscaAlunosForaDoCurso(int codigo) {

        Curso curso = new Curso(codigo);

        ResultSet resultSet;

        ArrayList<Aluno> listaAluno = new ArrayList<>();

        try ( PreparedStatement queryBuscaAlunos = this.conn
                .prepareStatement("SELECT * FROM aluno c WHERE NOT EXISTS "
                        + "(SELECT codigo_aluno FROM curso_aluno "
                        + "a WHERE a.codigo_curso = ? AND "
                        + "a.codigo_aluno = c.codigo)");) {

            queryBuscaAlunos.setInt(1, curso.getCodigo());

            resultSet = queryBuscaAlunos.executeQuery();

            while (resultSet.next()) {
                Aluno aluno = new Aluno();

                aluno.setCodigo(resultSet.getInt("codigo"));
                aluno.setNome(resultSet.getString("nome"));

                listaAluno.add(aluno);
            }

            queryBuscaAlunos.close();

            curso.setListaDeAlunosForaDoCurso(listaAluno);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return curso;
    }

    public Curso buscaAlunosDentroDoCurso(int codigo) {

        Curso curso = new Curso(codigo);

        ResultSet resultSet;

        ArrayList<Aluno> listaAluno = new ArrayList<>();

        try ( PreparedStatement queryBuscaAlunos = this.conn
                .prepareStatement("SELECT * FROM aluno c WHERE EXISTS "
                        + "(SELECT codigo_aluno FROM curso_aluno "
                        + "a WHERE a.codigo_curso = ? AND "
                        + "a.codigo_aluno = c.codigo)");) {

            queryBuscaAlunos.setInt(1, curso.getCodigo());

            resultSet = queryBuscaAlunos.executeQuery();

            while (resultSet.next()) {
                Aluno aluno = new Aluno();

                aluno.setCodigo(resultSet.getInt("codigo"));
                aluno.setNome(resultSet.getString("nome"));

                listaAluno.add(aluno);
            }

            queryBuscaAlunos.close();

            curso.setListaDeAlunosDentroDoCurso(listaAluno);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return curso;
    }

    public void adicionarAlunoAoCurso(int codigoAluno, int codigoCurso) {

        Curso curso = new Curso(codigoCurso);

        try ( PreparedStatement queryAdicionaCursoAluno = this.conn
                .prepareStatement("INSERT INTO curso_aluno(codigo_aluno, codigo_curso) values(?, ?)");) {
            
            JOptionPane.showMessageDialog(null, codigoAluno);
            JOptionPane.showMessageDialog(null, curso.getCodigo());

            queryAdicionaCursoAluno.setInt(1, codigoAluno);
            queryAdicionaCursoAluno.setInt(2, curso.getCodigo());

            queryAdicionaCursoAluno.execute();
            queryAdicionaCursoAluno.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirAlunoDoCurso(int codigoAluno, int codigoCurso) {

        Curso curso = new Curso(codigoCurso);

        try ( PreparedStatement queryExcluiAlunoCurso = this.conn
                .prepareStatement("DELETE FROM curso_aluno WHERE codigo_aluno = ? AND codigo_curso = ?;");) {

            queryExcluiAlunoCurso.setInt(1, codigoAluno);
            queryExcluiAlunoCurso.setInt(2, curso.getCodigo());

            queryExcluiAlunoCurso.execute();
            queryExcluiAlunoCurso.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirTodosAlunosDoCurso(int codigoCurso) {

        Curso curso = new Curso(codigoCurso);

        try ( PreparedStatement queryExcluiCursos = this.conn
                .prepareStatement("DELETE FROM curso_aluno WHERE codigo_curso = ?");) {

            queryExcluiCursos.setInt(1, curso.getCodigo());

            queryExcluiCursos.execute();
            queryExcluiCursos.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
