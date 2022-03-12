/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.julio.crudalunoscursos.validation;

import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class Alertas {

    public static void alertaAdicionarAluno(boolean sucesso, String nome) {

        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi cadastrado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "houve um erro ao cadastrar o aluno " + nome +".");
        }
    }

    public static void alertaAlterarAluno(boolean sucesso, String nome) {

        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi alterado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "Houve um erro ao alterar o aluno " + nome +".");
        }
    }

    public static void alertaDeletarAluno(boolean sucesso, String nome) {
        
        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi excluido com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "houve um erro ao excluir o aluno " + nome + ".");
        }
    }
    
    public static void alertaAdicionarCurso(boolean sucesso, String descricao) {

        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O curso " + descricao + " foi cadastrado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "houve um erro ao cadastrar o curso " + descricao +".");
        }
    }

    public static void alertaAlterarCurso(boolean sucesso, String descricao) {

        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O curso " + descricao + " foi alterado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "Houve um erro ao alterar o curso " + descricao +".");
        }
    }

    public static void alertaDeletarCurso(boolean sucesso, String descricao) {
        
        if (sucesso == true) {
            JOptionPane.showMessageDialog(null, "O curso " + descricao + " foi excluido com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "houve um erro ao excluir o curso " + descricao + ".");
        }
    }
}
