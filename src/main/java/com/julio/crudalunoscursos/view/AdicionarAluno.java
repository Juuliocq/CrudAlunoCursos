/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.julio.crudalunoscursos.view;

import com.julio.crudalunoscursos.dao.AlunoDAO;
import com.julio.crudalunoscursos.dao.GerenciadorConexao;
import com.julio.crudalunoscursos.validation.Alertas;
import com.julio.crudalunoscursos.validation.Validacao;
import javax.swing.JOptionPane;

/**
 * <b>Tela de adicionar aluno.</b>
 * @version 1.0
 * @author julio
 */
public class AdicionarAluno extends javax.swing.JFrame {

    /**
     * <b>Construtor, inicia os componentes da tela.</b>
     */
    public AdicionarAluno() {
        initComponents();
    }

    /**
     * <b>Método que instancia todos os componentes da tela.</b>
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel addNomeAlunolbl = new javax.swing.JLabel();
        addNomeAlunoTxt = new javax.swing.JTextField();
        javax.swing.JButton addAlunoConfirmaBtn = new javax.swing.JButton();
        javax.swing.JButton addAlunoCancelaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Aluno");

        addNomeAlunolbl.setText("Nome: ");

        addAlunoConfirmaBtn.setText("Adicionar");
        addAlunoConfirmaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlunoConfirmaBtnActionPerformed(evt);
            }
        });

        addAlunoCancelaBtn.setText("Cancelar");
        addAlunoCancelaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlunoCancelaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addNomeAlunolbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addAlunoConfirmaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addAlunoCancelaBtn))
                    .addComponent(addNomeAlunoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNomeAlunolbl)
                    .addComponent(addNomeAlunoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAlunoConfirmaBtn)
                    .addComponent(addAlunoCancelaBtn))
                .addGap(96, 96, 96))
        );

        setSize(new java.awt.Dimension(386, 107));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <b>Listener botão de adicionar aluno.</b>
     * <p>Recupera o nome da caixa de texto do nome do aluno,
     * valida o nome,
     * faz conexão com o banco de dados,
     * chama o método de adicionar aluno,
     * fecha a janela ou retorna alerta de nome vazio.</p>
     * @param evt 
     */
    private void addAlunoConfirmaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlunoConfirmaBtnActionPerformed

        String nome = addNomeAlunoTxt.getText();

        boolean eValido = Validacao.validaSeEstaVazio(nome);

        if (eValido == true) {

            AlunoDAO alunoDAO = new AlunoDAO(GerenciadorConexao.connect());
            boolean sucesso = alunoDAO.adicionaAluno(nome);

            Alertas.alertaAdicionarAluno(sucesso, nome);
            
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "O nome está vazio! Insira um nome válido.");
        }
    }//GEN-LAST:event_addAlunoConfirmaBtnActionPerformed

    /**
     * <b>Listener do botão de cancelar.</b>
     * <p>Fecha a janela.</p>
     * @param evt 
     */
    private void addAlunoCancelaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlunoCancelaBtnActionPerformed
        
        dispose();
    }//GEN-LAST:event_addAlunoCancelaBtnActionPerformed

    /**
     * <b>Método main.</b>
     * @param args
     */
    public static void main(String args[]) {

        /* Cria e mostra o frame. */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JTextField addNomeAlunoTxt;
    // End of variables declaration//GEN-END:variables
}
