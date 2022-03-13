/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.julio.crudalunoscursos.view;

import com.julio.crudalunoscursos.dao.CursoDAO;
import com.julio.crudalunoscursos.dao.GerenciadorConexao;
import com.julio.crudalunoscursos.validation.Alertas;
import com.julio.crudalunoscursos.validation.Validacao;
import javax.swing.JOptionPane;

/**
 * <b>Tela de adicionar curso.</b>
 * @version 1.0
 * @author julio
 */
public class AdicionarCurso extends javax.swing.JFrame {

    /**
     * <b>Construtor, inicia os componentes da tela.</b>
     */
    public AdicionarCurso() {
        initComponents();
    }

    /**
     * <b>Método que instancia todos os componentes da tela.</b>
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JButton addCursoConfirmaBtn = new javax.swing.JButton();
        javax.swing.JButton addCursoCancelaBtn = new javax.swing.JButton();
        javax.swing.JLabel addDescricaoCursolbl = new javax.swing.JLabel();
        addDescricaoCursoTxt = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        addDescricaoCursoTxtArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Curso");

        addCursoConfirmaBtn.setText("Adicionar");
        addCursoConfirmaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCursoConfirmaBtnActionPerformed(evt);
            }
        });

        addCursoCancelaBtn.setText("Cancelar");
        addCursoCancelaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCursoCancelaBtnActionPerformed(evt);
            }
        });

        addDescricaoCursolbl.setText("Descrição:");

        jLabel2.setText("Ementa:");

        addDescricaoCursoTxtArea.setColumns(20);
        addDescricaoCursoTxtArea.setRows(5);
        jScrollPane1.setViewportView(addDescricaoCursoTxtArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(addDescricaoCursolbl)
                        .addGap(18, 18, 18)
                        .addComponent(addDescricaoCursoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addCursoConfirmaBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addCursoCancelaBtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDescricaoCursolbl)
                    .addComponent(addDescricaoCursoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCursoConfirmaBtn)
                    .addComponent(addCursoCancelaBtn))
                .addGap(27, 27, 27))
        );

        setSize(new java.awt.Dimension(495, 327));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     /**
     * <b>Listener do botão de cancelar.</b>
     * <p>Fecha a janela.</p>
     * @param evt 
     */
    private void addCursoCancelaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCursoCancelaBtnActionPerformed

        dispose();
    }//GEN-LAST:event_addCursoCancelaBtnActionPerformed

     /**
     * <b>Listener botão de adicionar curso.</b>
     * <p>Recupera a descrição da caixa de texto de descrição do curso
     * e ementa do curso, valida a descrição,
     * faz conexão com o banco de dados,
     * chama o método de adicionar curso,
     * fecha a janela ou retorna alerta de descrição vazia.</p>
     * @param evt 
     */
    private void addCursoConfirmaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCursoConfirmaBtnActionPerformed

        String descricao = addDescricaoCursoTxt.getText();
        String ementa = addDescricaoCursoTxtArea.getText();

        boolean eValido = Validacao.validaSeEstaVazio(descricao);

        if (eValido == true) {

            CursoDAO cursoDAO = new CursoDAO(GerenciadorConexao.connect());
            boolean sucesso = cursoDAO.adicionaCurso(descricao, ementa);

            Alertas.alertaAdicionarCurso(sucesso, descricao);
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "A descrição está vazia! Insira uma descrição válida.");
        }
    }//GEN-LAST:event_addCursoConfirmaBtnActionPerformed

    /**
     * <b>Método main.</b>
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Cria e mostra o frame. */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdicionarCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JTextField addDescricaoCursoTxt;
    javax.swing.JTextArea addDescricaoCursoTxtArea;
    // End of variables declaration//GEN-END:variables

}
