/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.validation;

import javax.swing.JOptionPane;

/**
 * <b>Classe responsável por exibir alertas.</b>
 *
 * @version 1.0
 * @author julio
 */
public class Alertas {

    /**
     * <b>Método que exibe um JOptionPane de sucesso ao adicionar aluno.</b>
     *
     * @param sucesso boolean - Contém V/F dependendo se a query obteve sucesso.
     * @param nome nome - Nome do aluno a ser adicionado.
     */
    public static void alertaAdicionarAluno(boolean sucesso, String nome) {

        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi cadastrado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "houve um erro ao cadastrar o aluno " + nome + ".");
        }
    }

    /**
     * <b>Método que exibe um JOptionPane de sucesso ao alterar aluno.</b>
     *
     * @param sucesso boolean - Contém V/F dependendo se a query obteve sucesso.
     * @param nome nome - Nome do aluno a ser alterado.
     */
    public static void alertaAlterarAluno(boolean sucesso, String nome) {

        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi alterado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "Houve um erro ao alterar o aluno " + nome + ".");
        }
    }

    /**
     * <b>Método que exibe um JOptionPane para confirmar de realmente deseja
     * excluir um aluno.</b>
     *
     * @param nome nome - Nome do aluno a ser excluido.
     * @return confirma int - 0 = Confirma exclusão. 1 = Cancela a exclusão.
     */
    public static int alertaDesejaDeletarAluno(String nome) {
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o aluno "
                + nome + "?", "Deseja excluir?",
                JOptionPane.YES_NO_OPTION);

        return confirma;
    }

    /**
     * <b>Método que exibe um JOptionPane de sucesso ao excluir aluno.</b>
     *
     * @param sucesso boolean - Contém V/F dependendo se a query obteve sucesso.
     * @param nome nome - Nome do aluno a ser excluido.
     */
    public static void alertaDeletarAluno(boolean sucesso, String nome) {

        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi excluido com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "houve um erro ao excluir o aluno " + nome + ".");
        }
    }

    /**
     * <b>Método que exibe um JOptionPane de sucesso ao adicionar curso.</b>
     *
     * @param sucesso boolean - Contém V/F dependendo se a query obteve sucesso.
     * @param descricao String - Descrição do curso a ser adicionado..
     */
    public static void alertaAdicionarCurso(boolean sucesso, String descricao) {

        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O curso " + descricao + " foi cadastrado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "houve um erro ao cadastrar o curso " + descricao + ".");
        }
    }

    /**
     * <b>Método que exibe um JOptionPane de sucesso ao alterar curso.</b>
     *
     * @param sucesso boolean - Contém V/F dependendo se a query obteve sucesso.
     * @param descricao String - Descrição do curso a ser alterado.
     */
    public static void alertaAlterarCurso(boolean sucesso, String descricao) {

        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O curso " + descricao + " foi alterado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "Houve um erro ao alterar o curso " + descricao + ".");
        }
    }

    /**
     * <b>Método que exibe um JOptionPane para confirmar de realmente deseja
     * excluir um curso.</b>
     *
     * @param descricao String - Descrição do curso a ser excluido.
     * @return confirma int - 0 = Confirma exclusão. 1 = Cancela a exclusão.
     */
    public static int alertaDesejaDeletarCurso(String descricao) {
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o curso "
                + descricao + "?",
                "Deseja excluir?",
                JOptionPane.YES_NO_OPTION);

        return confirma;
    }

     /**
     * <b>Método que exibe um JOptionPane de sucesso ao excluir aluno.</b>
     *
     * @param sucesso boolean - Contém V/F dependendo se a query obteve sucesso.
     * @param descricao String - Descrição do curso a ser excluido.
     */
    public static void alertaDeletarCurso(boolean sucesso, String descricao) {

        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O curso " + descricao + " foi excluido com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "houve um erro ao excluir o curso " + descricao + ".");
        }
    }
}
