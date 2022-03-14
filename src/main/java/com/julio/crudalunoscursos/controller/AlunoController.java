package com.julio.crudalunoscursos.controller;

import com.julio.crudalunoscursos.dao.AlunoDAO;
import com.julio.crudalunoscursos.dao.GerenciadorConexao;
import com.julio.crudalunoscursos.model.Aluno;
import java.util.ArrayList;

/**
 * <b>Classe controladora da entidade aluno.</b>
 * @version 1.0
 * @author julio
 */
public class AlunoController {
    
    /**
     * <b>Atributo que salva um objeto de acesso a dados de Aluno.</b>
     */
    private static final AlunoDAO alunoDao = new AlunoDAO(GerenciadorConexao.connect());
    
    /**
     * <b>Método que envia requisição de adicionar aluno ao objeto de acesso a dados de aluno.</b>
     * @param nome String - Nome do aluno a ser adicionado.
     * @return sucesso boolean - Estado da requisição (V/F)
     */
    public static boolean adicionaAlunoController(String nome){

        boolean sucesso = alunoDao.adicionaAluno(nome);
            
        return sucesso;
    }
    
    /**
     * <b>Método que envia a requisição de alterar aluno ao objeto de acesso a dados de aluno.</b>
     * @param codigo int - Código do aluno a ser alterado.
     * @param nome String - Nome do aluno a ser alterado.
     * @return sucesso boolean - Estado da requisição (V/F)
     */
    public static boolean alteraAlunoController(int codigo, String nome){
        
        boolean sucesso = alunoDao.alteraAluno(codigo, nome);
        
        return sucesso;
    }
    
     /**
     * <b>Método que envia a requisição de excluir um aluno
     * ao objeto de acesso a dados de aluno.</b>
     * @param codigo int - Código do aluno a ser excluido.
     * @return sucesso boolean - Estado da requisição (V/F)
     */
    public static boolean deletaAlunoController(int codigo){
        
        boolean sucesso = alunoDao.excluiAluno(codigo);
        
        return sucesso;
    }
    
     /**
     * <b>Método que envia a requisição de recuperar todos os alunos
     * ao objeto de acesso a dados de aluno.</b>
     * @return listaAluno ArrayList  - Lista de todos os alunos.
     */
    public static ArrayList<Aluno> retornaTodosOsAlunosController(){
        
        ArrayList<Aluno> listaAluno = alunoDao.buscaTodosAlunos();
        
        return listaAluno;
    }
    
    /**
     * <b>Método que envia a requisição de buscar os cursos que o aluno faz
     * ao objeto de acesso a dados de aluno</b>
     * @param codigo - Codigo do aluno a ser consultado.
     * @return aluno Aluno - Objeto Aluno construido com a lista de cursos que o aluno faz.
     */
    public static Aluno buscaCursosQueOAlunoFazController(int codigo){
        Aluno aluno;
        
        aluno = alunoDao.buscaCursosAluno(codigo);
        
        return aluno;
    }
    
     /**
     * <b>Método que envia a requisição de buscar todos os cursos que o aluno não faz
     * ao objeto de acesso a dados de aluno.</b>
     * @param codigo - Codigo do curso a ser consultado.
     * @return aluno Aluno - Objeto Aluno construido com a lista de cursos que ele faz.
     */
    public static Aluno buscaAlunosForaDoCursoController(int codigo){
        Aluno aluno;
        
        aluno = alunoDao.buscaCursosAlunoNaoFaz(codigo);
        
        return aluno;
    }
}
