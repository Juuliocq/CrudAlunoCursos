package com.julio.crudalunoscursos.controller;

import com.julio.crudalunoscursos.dao.CursoAlunoDAO;
import com.julio.crudalunoscursos.dao.GerenciadorConexao;

/**
 * <b>Classe controladora da entidade associativa curso/aluno.</b>
 * @version 1.0
 * @author julio
 */
public class CursoAlunoController {
    
     /**
     * <b>Atributo que salva um objeto de acesso a dados de Curso/Aluno.</b>
     */
    private static final CursoAlunoDAO cursoAlunoDao = new CursoAlunoDAO(GerenciadorConexao.connect());
    
     /**
     * <b>Método que envia requisição de adicionar curso/aluno ao objeto de acesso a dados de curso/aluno.</b>
     * @param codigoAluno int - Código do aluno a ser adicionado.
     * @param codigoCurso int - Código do curso a ser adicionado.
     */
    public static void adicionaCursoAlunoController(int codigoAluno, int codigoCurso){

        cursoAlunoDao.adicionarCursoAluno(codigoAluno, codigoCurso);
    }
    
        
     /**
     * <b>Método que envia requisição de excluir curso/aluno ao objeto de acesso a dados de aluno.</b>
     * @param codigoAluno int - Código do aluno a ser excluido.
     * @param codigoCurso int - Código do curso a ser excluido.
     */
    public static void excluiCursoAlunoController(int codigoAluno, int codigoCurso){

        cursoAlunoDao.excluirCursoAluno(codigoAluno, codigoCurso);
    }
}
