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

/**
 *
 * @author julio
 */
public class AlunoDAO {

    private Connection conn;
    boolean sucesso = false;

    public AlunoDAO() {
    }

    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean adicionaAluno(String nome) {

        Aluno aluno = new Aluno(nome);

        try ( PreparedStatement queryAddAluno = this.conn
                .prepareStatement("INSERT INTO aluno(nome) VALUE (?)");) {

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
                .prepareStatement("SELECT * FROM aluno");) {

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

        Aluno aluno = new Aluno(codigo, nome);

        try ( PreparedStatement queryAlteraAluno = this.conn
                .prepareStatement("UPDATE aluno SET nome = ? WHERE codigo = ?");) {

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

        Aluno aluno = new Aluno(codigo);

        try ( PreparedStatement queryDeletaAluno = this.conn
                .prepareStatement("DELETE FROM aluno WHERE codigo = ?;");) {

            queryDeletaAluno.setInt(1, aluno.getCodigo());

            excluirTodosCursosDoAluno(aluno.getCodigo());
            
            queryDeletaAluno.execute();
            queryDeletaAluno.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return sucesso;
    }

    public Aluno buscaCursosQueAlunoNaoFaz(int codigo) {

        Aluno aluno = new Aluno(codigo);

        ResultSet resultSet;

        ArrayList<Curso> listaCurso = new ArrayList<>();

        try ( PreparedStatement queryBuscaCursos = this.conn
                .prepareStatement("SELECT * FROM curso c WHERE NOT EXISTS "
                        + "(SELECT codigo_curso FROM curso_aluno "
                        + "a WHERE a.codigo_aluno = ? AND "
                        + "a.codigo_curso = c.codigo)");) {

            queryBuscaCursos.setInt(1, aluno.getCodigo());

            resultSet = queryBuscaCursos.executeQuery();

            while (resultSet.next()) {
                Curso curso = new Curso();

                curso.setCodigo(resultSet.getInt("codigo"));
                curso.setDescricao(resultSet.getString("descricao"));

                listaCurso.add(curso);
            }

            queryBuscaCursos.close();

            aluno.setListaDeCursosQueAlunoNaoFaz(listaCurso);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return aluno;
    }
    
     public Aluno buscaCursosDoAluno(int codigo) {

        Aluno aluno = new Aluno(codigo);

        ResultSet resultSet;

        ArrayList<Curso> listaCurso = new ArrayList<>();

        try ( PreparedStatement queryBuscaCursos = this.conn
                .prepareStatement("SELECT * FROM curso c WHERE EXISTS "
                        + "(SELECT codigo_curso FROM curso_aluno "
                        + "a WHERE a.codigo_aluno = ? AND "
                        + "a.codigo_curso = c.codigo)");) {

            queryBuscaCursos.setInt(1, aluno.getCodigo());

            resultSet = queryBuscaCursos.executeQuery();

            while (resultSet.next()) {
                Curso curso = new Curso();

                curso.setCodigo(resultSet.getInt("codigo"));
                curso.setDescricao(resultSet.getString("descricao"));

                listaCurso.add(curso);
            }

            queryBuscaCursos.close();

            aluno.setListaDeCursosDoAluno(listaCurso);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return aluno;
    }

    public void adicionarCursoAoAluno(int codigoAluno, int codigoCurso) {

        Aluno aluno = new Aluno(codigoAluno);

        try ( PreparedStatement queryAdicionaCurso = this.conn
                .prepareStatement("INSERT INTO curso_aluno(codigo_aluno, codigo_curso) values(?, ?)");) {

            queryAdicionaCurso.setInt(1, aluno.getCodigo());
            queryAdicionaCurso.setInt(2, codigoCurso);

            queryAdicionaCurso.execute();
            queryAdicionaCurso.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void excluirCursoDoAluno(int codigoAluno, int codigoCurso) {

        Aluno aluno = new Aluno(codigoAluno);

        try ( PreparedStatement queryExcluiCursoAluno = this.conn
                .prepareStatement("DELETE FROM curso_aluno WHERE codigo_aluno = ? AND codigo_curso = ?;");) {

            queryExcluiCursoAluno.setInt(1, aluno.getCodigo());
            queryExcluiCursoAluno.setInt(2, codigoCurso);

            queryExcluiCursoAluno.execute();
            queryExcluiCursoAluno.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        public void excluirTodosCursosDoAluno(int codigoAluno) {

        Aluno aluno = new Aluno(codigoAluno);

        try ( PreparedStatement queryExcluiTodosCursos = this.conn
                .prepareStatement("DELETE FROM curso_aluno WHERE codigo_aluno = ?");) {

            queryExcluiTodosCursos.setInt(1, aluno.getCodigo());

            queryExcluiTodosCursos.execute();
            queryExcluiTodosCursos.close();

            sucesso = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
