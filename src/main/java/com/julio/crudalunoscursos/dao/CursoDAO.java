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
 * <b>Classe que instancia um objeto de acesso a dados do tipo Curso.</b>
 * <p>Contém todas as funções relacionadas a banco de dados para o tipo Curso.</p>
 *
 * @author julio
 * @version 1.0
 */
public class CursoDAO {

    /**
     * <b>Objeto de conexão com o banco de dados.</b>
     */
    private final Connection conn;

    /**
     * <b>Booleano para salvar o status de cada query realizada no banco de dados.</b>
     */
    boolean sucesso = false;

    /**
     * <b>Construtor injetando um objeto de conexão com o banco de dados.</b>
     *
     * @param conn Connection
     */
    public CursoDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * <b>Método que adiciona um novo curso ao banco de dados.</b>
     * <p>Cria um objeto curso, faz a query no banco de dados e retorna um booleano.</p>
     *
     * @param descricao String - Descrição do curso.
     * @param ementa String - Ementa do Curso.
     * @return boolean Sucesso - booleano que retorna o status da query(V/F).
     */
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

    /**
     * <b>Busca todos os cursos no banco de dados.</b>
     * <p>Instancia um objeto ResultSet,
     * faz a query no banco de dados e salva o resultado no ResultSet. Com um
     * laço while salva o ResultSet dentro de um ArrayList do tipo Curso.</p>
     *
     * @return ArrayList listaCurso - Lista de cursos no banco de dados.
     */
    public ArrayList<Curso> buscaTodosCursos() {

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

    /**
     * <b>Método que atualiza um curso no banco de dados.</b>
     * <p>Inicializa um objeto do tipo curso e executa a query.</p>
     *
     * @param codigo int - Código do curso a ser atualizado.
     * @param descricao String - Nome atualizado do curso.
     * @param ementa String - Ementa atualizada do curso.
     * @return Boolean sucesso - Status da query(V/F).
     */
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

    /**
     * <b>Método que exclui um curso do banco de dados.</b>
     * <p>Instancia um objeto do tipo Curso,
     * executa o método excluirTodosAlunosDoCurso() para limpar a tabela
     * curso_aluno onde codigo_curso == código do curso a ser excluido para
     * evitar exceção de SQL por chave estrangeira e executa a query.</p>
     *
     * @param codigo int - Código do curso a ser excluido.
     * @return boolean sucesso - Retorna status da query(V/F).
     */
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

    /**
     * <b>Busca todos os alunos que não tem correspondência com o curso recebido
     * por parâmetro na tabela curso_aluno.</b>
     * <p>Instancia um objeto do tipo Curso,
     * instancia um objeto ResultSet, faz a query no banco de dados e salva o
     * resultado no ResultSet. Com um laço while salva o ResultSet dentro de um
     * ArrayList do tipo Aluno. Adiciona o ArrayList de alunos ao objeto Curso.</p>
     *
     * @param codigo int - Código do curso a ser consultado.
     * @return aluno Aluno - Objeto Curso contendo um ArrayList de alunos que
     * não fazem o curso
     */
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

    /**
     * <b>Busca todos os alunos que tem correspondência com o curso recebido por
     * parâmetro na tabela curso_aluno.</b>
     * <p>Instancia um objeto do tipo Curso,
     * instancia um objeto ResultSet, faz a query no banco de dados e salva o
     * resultado no ResultSet. Com um laço while salva o ResultSet dentro de um
     * ArrayList do tipo Aluno. Adiciona o ArrayList de alunos ao objeto Curso.</p>
     *
     * @param codigo int - Código do curso a ser consultado.
     * @return curso Curso - Objeto Curso contendo um ArrayList de Alunos que
     * fazem o curso.
     */
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

    /**
     * <b>Exclui todos os cursos do aluno.</b>
     * <p>Instancia um curso e executa a query.
     * Usado apenas no método excluiCurso dessa mesma classe.</p>
     *
     * @param codigoCurso int - Código do curso a ser excluido.
     */
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
