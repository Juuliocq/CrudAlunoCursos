package com.julio.crudalunoscursos.dao;

import com.julio.crudalunoscursos.model.Aluno;
import com.julio.crudalunoscursos.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <b>Classe que instancia um objeto de acesso a dados referente a tabela
 * curso_aluno.</b>
 *
 * @author julio
 */
public class CursoAlunoDAO {

    /**
     * <b>Objeto de conexão com o banco de dados.</b>
     */
    private final Connection conn;

    /**
     * Construtor injetando um objeto de conexão com o banco de dados.
     * @param conn 
     */
    public CursoAlunoDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * <b>Adiciona um registro curso_aluno.</b>
     * <p>Instancia um objeto do tipo Aluno,
     * Curso e executa a query.</p>
     *
     * @param codigoAluno int - Código do aluno a ser adicionado.
     * @param codigoCurso int - Código do curso a ser adicionado.
     */
    public void adicionarCursoAluno(int codigoAluno, int codigoCurso) {

        Aluno aluno = new Aluno(codigoAluno);
        Curso curso = new Curso(codigoCurso);

        try ( PreparedStatement queryAdicionaCurso = this.conn
                .prepareStatement("INSERT INTO curso_aluno(codigo_aluno, codigo_curso) values(?, ?)");) {

            queryAdicionaCurso.setInt(1, aluno.getCodigo());
            queryAdicionaCurso.setInt(2, curso.getCodigo());

            queryAdicionaCurso.execute();
            queryAdicionaCurso.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <b>Exclui um registro curso_aluno.</b>
     * <p>Instancia um objeto do tipo Aluno, Curso
     * e executa a query.</p>
     *
     * @param codigoAluno int - Código do aluno a ser excluido.
     * @param codigoCurso int - Código do curso a ser excluido.
     */
    public void excluirCursoAluno(int codigoAluno, int codigoCurso) {

        Aluno aluno = new Aluno(codigoAluno);
        Curso curso = new Curso(codigoCurso);

        try ( PreparedStatement queryExcluiCursoAluno = this.conn
                .prepareStatement("DELETE FROM curso_aluno WHERE codigo_aluno = ? AND codigo_curso = ?;");) {

            queryExcluiCursoAluno.setInt(1, aluno.getCodigo());
            queryExcluiCursoAluno.setInt(2, curso.getCodigo());

            queryExcluiCursoAluno.execute();
            queryExcluiCursoAluno.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
