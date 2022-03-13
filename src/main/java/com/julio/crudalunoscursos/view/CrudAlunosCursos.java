/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.julio.crudalunoscursos.view;

import com.julio.crudalunoscursos.dao.CriaBanco;
import com.julio.crudalunoscursos.dao.GerenciadorConexao;

/**
 * <b>Frame inicial, com todos os botões iniciais.</b>
 * @version 1.0
 * @author julio
 */
public class CrudAlunosCursos extends javax.swing.JFrame {

    /**
     * <b>Inicia os componentes da tela.</b>
     */
    public CrudAlunosCursos() {
        initComponents();
    }

    /**
     * <b>Método que instancia todos os componentes da tela.</b>
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JButton addAlunoBtn = new javax.swing.JButton();
        javax.swing.JButton addCursoBtn = new javax.swing.JButton();
        javax.swing.JButton verAlunoBtn = new javax.swing.JButton();
        javax.swing.JButton verCursoBtn = new javax.swing.JButton();
        javax.swing.JButton verCursosAluno = new javax.swing.JButton();
        javax.swing.JButton verAlunosCurso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alunos e Cursos");
        setLocationByPlatform(true);

        addAlunoBtn.setText("Adicionar Aluno");
        addAlunoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlunoBtnActionPerformed(evt);
            }
        });

        addCursoBtn.setText("Adicionar Curso");
        addCursoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCursoBtnActionPerformed(evt);
            }
        });

        verAlunoBtn.setText("Ver Alunos");
        verAlunoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAlunoBtnActionPerformed(evt);
            }
        });

        verCursoBtn.setText("Ver Cursos");
        verCursoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCursoBtnActionPerformed(evt);
            }
        });

        verCursosAluno.setText("Ver Cursos do Aluno");
        verCursosAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCursosAlunoActionPerformed(evt);
            }
        });

        verAlunosCurso.setText("Ver Alunos do Curso");
        verAlunosCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAlunosCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(verCursosAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verAlunoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addAlunoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verAlunosCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verCursoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addCursoBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAlunoBtn)
                    .addComponent(addCursoBtn))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verAlunoBtn)
                    .addComponent(verCursoBtn))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verCursosAluno)
                    .addComponent(verAlunosCurso))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <b>Listener do botão para ver a tela Adicionar Aluno.</b>
     * @param evt 
     */
    private void addAlunoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlunoBtnActionPerformed

        AdicionarAluno addAluno = new AdicionarAluno();
        
        addAluno.setVisible(true);
        
    }//GEN-LAST:event_addAlunoBtnActionPerformed

     /**
     * <b>Listener do botão para ver a tela Adicionar Curso.</b>
     * @param evt 
     */
    private void addCursoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCursoBtnActionPerformed

        AdicionarCurso adicionarCurso = new AdicionarCurso();
        
        adicionarCurso.setVisible(true);
    }//GEN-LAST:event_addCursoBtnActionPerformed

     /**
     * <b>Listener do botão para ver a tela Ver Aluno.</b>
     * @param evt 
     */
    private void verAlunoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAlunoBtnActionPerformed

        VerAlunos verAlunos = new VerAlunos();
        
        verAlunos.setVisible(true);
    }//GEN-LAST:event_verAlunoBtnActionPerformed

     /**
     * <b>Listener do botão para ver a tela Ver Curso.</b>
     * @param evt 
     */
    private void verCursoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCursoBtnActionPerformed

        VerCursos verCursos = new VerCursos();
        
        verCursos.setVisible(true);
    }//GEN-LAST:event_verCursoBtnActionPerformed

     /**
     * <b>Listener do botão para ver a tela Cursos do Aluno.</b>
     * @param evt 
     */
    private void verCursosAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCursosAlunoActionPerformed

        CursosDoAluno cursosDoAluno = new CursosDoAluno();
        
        cursosDoAluno.setVisible(true);
    }//GEN-LAST:event_verCursosAlunoActionPerformed

     /**
     * <b>Listener do botão para ver a tela Alunos do Curso.</b>
     * @param evt 
     */
    private void verAlunosCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAlunosCursoActionPerformed

        AlunosDoCurso alunosDoCurso = new AlunosDoCurso();
        
        alunosDoCurso.setVisible(true);
    }//GEN-LAST:event_verAlunosCursoActionPerformed

    /**
     * <b>Método main.</b>
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /*Cria a estrutura do banco de dados*/
        CriaBanco.criaBanco(GerenciadorConexao.connect());

        /* Cria e mostra o frame. */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrudAlunosCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
