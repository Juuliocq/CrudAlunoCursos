package com.julio.crudalunoscursos.controller;

import com.julio.crudalunoscursos.dao.CursoDAO;
import com.julio.crudalunoscursos.dao.GerenciadorConexao;
import com.julio.crudalunoscursos.model.Curso;
import java.util.ArrayList;

/**
 * <b>Classe controladora da entidade Curso</b>
 * @version 1.0
 * @author julio
 */
public class CursoController {
    
     /**
     * <b>Atributo que salva um objeto de acesso a dados de Curso.</b>
     */
    private static final CursoDAO cursoDao = new CursoDAO(GerenciadorConexao.connect());
    
        /**
     * <b>Método que envia requisição de curso ao objeto de acesso a dados de curso.</b>
     * @param descricao String - Descrição do curso a ser adicionado.
     * @param ementa String - Ementa do curso a ser adicionado.
     * @return sucesso boolean - Estado da requisição (V/F)
     */
    public static boolean adicionaCursoController(String descricao, String ementa){

        boolean sucesso = cursoDao.adicionaCurso(descricao, ementa);
            
        return sucesso;
    }
    
    /**
     * <b>Método que envia a requisição de alterar curso ao objeto de acesso a dados de curso.</b>
     * @param codigo int - Código do curso a ser alterado.
     * @param descricao String - Descrição do curso a ser alterado.
     * @param ementa String - Ementa do curso a ser alterado.
     * @return sucesso boolean - Estado da requisição (V/F)
     */
    public static boolean alteraCursoController(int codigo, String descricao, String ementa){
        
        boolean sucesso = cursoDao.alteraCurso(codigo, descricao, ementa);
        
        return sucesso;
    }
    
    /**
     * <b>Método que envia a requisição de excluir um curso
     * ao objeto de acesso a dados de curso.</b>
     * @param codigo int - Código do curso a ser excluido.
     * @return sucesso boolean - Estado da requisição (V/F)
     */
    public static boolean excluiCursoController(int codigo){
        
        boolean sucesso = cursoDao.excluiCurso(codigo);
        
        return sucesso;
    }
    
     /**
     * <b>Método que envia a requisição de recuperar todos os alunos
     * ao objeto de acesso a dados de aluno.</b>
     * @return listaAluno ArrayList  - Lista de todos os alunos.
     */
    public static ArrayList<Curso> retornaTodosOsCursosController(){
        
        ArrayList<Curso> listaCurso = cursoDao.buscaTodosCursos();
        
        return listaCurso;
    }
    
    /**
     * <b>Método que busca todos os alunos que fazem o curso buscado.</b>
     * @param codigo - Codigo do curso a ser consultado.
     * @return curso Curso - Objeto Curso construido com a lista de alunos dentro do curso.
     */
    public static Curso buscaAlunosDentroDoCursoController(int codigo){
        Curso curso;
        
        curso = cursoDao.buscaAlunosDentroDoCurso(codigo);
        
        return curso;
    }
    
     /**
     * <b>Método que busca todos os alunos que fazem o curso buscado.</b>
     * @param codigo - Codigo do curso a ser consultado.
     * @return curso Curso - Objeto Curso construido com a lista de alunos fora do curso.
     */
    public static Curso buscaAlunosForaDoCursoController(int codigo){
        Curso curso;
        
        curso = cursoDao.buscaAlunosForaDoCurso(codigo);
        
        return curso;
    }
}
