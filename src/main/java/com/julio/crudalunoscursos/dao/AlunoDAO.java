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
 * <b>Classe que instancia um objeto de acesso a dados do tipo Aluno.</b>
 * <p>Contém todas as funções relacionadas a banco de dados para o tipo Aluno.</p>
 *
 * @author julio
 * @version 1.0
 */
public class AlunoDAO {

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
    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * <b>Método que adiciona um novo aluno ao banco de dados.</b>
     * <p>Cria um objeto Aluno, faz a query no banco de dados e retorna um booleano.</p>
     *
     * @param nome String - Nome do Aluno
     * @return boolean Sucesso - booleano que retorna o status da query(V/F).
     */
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

    /**
     * <b>Busca todos os alunos no banco de dados.</b> 
     * <p>Instancia um objeto ResultSet, faz a query no banco de dados e salva o resultado no ResultSet. Com um
     * laço while salva o ResultSet dentro de um ArrayList do tipo Aluno.</p>
     *
     * @return ArrayList listaAluno - Lista de alunos no banco de dados.
     */
    public ArrayList<Aluno> buscaTodosAlunos() {

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

    /**
     * <b>Método que atualiza um aluno no banco de dados.</b> 
     * <p>Inicializa um objeto do tipo Aluno e executa a query.</p>
     *
     * @param codigo int - Código do aluno a ser atualizado.
     * @param nome String - Nome atualizado do aluno.
     * @return Boolean sucesso - Status da query(V/F).
     */
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

    /**
     * <b>Método que exclui um aluno do banco de dados.</b> 
     * <p>Instancia um objeto do tipo Aluno, executa o método excluirTodosCursosDoAluno()
     * para limpar a tabela curso_aluno onde codigo_aluno == código do aluno
     * a ser excluido para evitar exceção de SQL por chave estrangeira e executa a query.</p>
     *
     * @param codigo int - Código do Aluno a ser excluido.
     * @return boolean sucesso - Retorna status da query(V/F).
     */
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

    /**
     * <b>Busca todos os cursos que não tem correspondência com o aluno recebido
     * por parâmetro na tabela curso_aluno.</b> 
     * <p>Instancia um objeto do tipo Aluno,
     * instancia um objeto ResultSet, faz a query no banco de dados e salva o
     * resultado no ResultSet, com um laço while salva o ResultSet dentro de um
     * ArrayList do tipo Curso e 
     * adiciona o ArrayList de cursos ao objeto Aluno.</p>
     *
     * @param codigo int - Código do aluno a ser consultado.
     * @return aluno Aluno - Objeto Aluno contendo um ArrayList de cursos que
     * ele não faz.
     */
    public Aluno buscaCursosAlunoNaoFaz(int codigo) {

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

    /**
     * <b>Busca todos os cursos que tem correspondência com o aluno recebido por
     * parâmetro na tabela curso_aluno.</b> 
     * <p>Instancia um objeto do tipo Aluno,
     * instancia um objeto ResultSet, faz a query no banco de dados e salva o
     * resultado no ResultSet. Com um laço while salva o ResultSet dentro de um
     * ArrayList do tipo Curso. Adiciona o ArrayList de cursos ao objeto Aluno.</p>
     *
     * @param codigo int - Código do aluno a ser consultado.
     * @return aluno Aluno - Objeto Aluno contendo um ArrayList de cursos que
     * ele faz.
     */
    public Aluno buscaCursosAluno(int codigo) {

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

    /**
     * <b>Exclui todos os cursos do aluno.</b> 
     * <p>Instancia um aluno e executa a query.</p>
     * <p>Usado apenas no método excluiAluno() dessa mesma classe.</p>
     *
     * @param codigoAluno int - Código do aluno a ser excluido.
     */
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
