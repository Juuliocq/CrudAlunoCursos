package com.julio.crudalunoscursos.view;

import com.julio.crudalunoscursos.controller.CursoAlunoController;
import com.julio.crudalunoscursos.controller.CursoController;
import com.julio.crudalunoscursos.model.Curso;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * <b>Tela que mostra os alunos de determinado curso.</b>>
 * @version 1.0
 * @author julio
 */
public final class AlunosDoCurso extends javax.swing.JFrame {

    /**
     * <b>Salva o codigo do aluno que foi clicado nas duas tabelas de aluno.</b>
     */
    private int codigoAluno;
    
    /**
     * <b>Salva o código do curso clicado na tabela de cursos.</b>
     */
    private int codigoCurso;

    /**
     * <b>Construtor, inicia os componentes da tela e atualiza a tabela de cursos.</b>
     */
    public AlunosDoCurso() {
        initComponents();

        retornaTabelaCurso();
    }

    /**
     * <b>Método responsável por retornar a tabela de cursos.</b>
     * <p>Converte a tabela de cursos em um modelo de tabela padrão,
     * adiciona a ordenação na tabela,
     * reseta a quantidade de linhas da tabela para não mostrar linhas duplicadas,
     * chama o método de listar todos os cursos da classe controladora de cursos e
     * e insere na tabela usando o fluxo ForEach.<p>
     */
    public void retornaTabelaCurso() {

        DefaultTableModel modelo = (DefaultTableModel) cursoTbl.getModel();
        cursoTbl.setRowSorter(new TableRowSorter(modelo));

        modelo.setRowCount(0);

        ArrayList<Curso> listaCurso = CursoController.retornaTodosOsCursosController();

        listaCurso.forEach(a -> {
            modelo.addRow(new Object[]{
                a.getCodigo(),
                a.getDescricao(),}
            );
        });
    }

     /**
     * <b>Método responsável por retornar a tabela de alunos que fazem o curso.</b>
     * <p>Converte a tabela de alunos que fazem o curso em um modelo de tabela padrão,
     * adiciona a ordenação na tabela,
     * reseta a quantidade de linhas da tabela para não mostrar linhas duplicadas,
     * chama o método da classe controladora que retorna os alunos que fazem o curso passado como parâmetro e
     * insere na tabela usando o fluxo ForEach.</p>
     * @param codigo int - Código do curso a set consultado.
     */
    public void retornaTabelaAlunosDoCurso(int codigo) {

        DefaultTableModel modelo = (DefaultTableModel) alunosDoCursoTbl.getModel();
        alunosDoCursoTbl.setRowSorter(new TableRowSorter(modelo));

        modelo.setRowCount(0);

        Curso curso = CursoController.buscaAlunosDentroDoCursoController(codigo);

        curso.getListaDeAlunosDentroDoCurso()
              .forEach(a -> {

                    modelo.addRow(new Object[]{
                        a.getCodigo(),
                        a.getNome(),}
                    );
                });
    }

     /**
     * <b>Método responsável por retornar a tabela de alunos que não fazem o curso.</b>
     * <p>Converte a tabela de alunos que não fazem o curso em um modelo de tabela padrão,
     * adiciona a ordenação na tabela,
     * reseta a quantidade de linhas da tabela para não mostrar linhas duplicadas,
     * chama o método da classe controladora que retorna os alunos que não fazem o curso passado como parâmetro e
     * insere na tabela usando o fluxo ForEach.</p>
     * @param codigo int - Código do curso a set consultado.
     */
    public void retornaTabelaAlunosForaDoCurso(int codigo) {

        DefaultTableModel modelo = (DefaultTableModel)
                alunosForaDoCursoTbl.getModel();

        alunosForaDoCursoTbl.setRowSorter(new TableRowSorter(modelo));

        modelo.setRowCount(0);

        Curso curso = CursoController.buscaAlunosForaDoCursoController(codigo);

        curso.getListaDeAlunosForaDoCurso()
              .forEach(a -> {

                    modelo.addRow(new Object[]{
                        a.getCodigo(),
                        a.getNome(),}
                    );
                });
    }

    /**
     * <b>Método que instancia todos os componentes da tela.</b>
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        cursoTbl = new javax.swing.JTable();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        alunosDoCursoTbl = new javax.swing.JTable();
        javax.swing.JLabel alunosDoCursoLbl = new javax.swing.JLabel();
        javax.swing.JLabel AlunosForaDoCursoLbl = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane3 = new javax.swing.JScrollPane();
        alunosForaDoCursoTbl = new javax.swing.JTable();
        deletaAlunoDoCursoBtn = new javax.swing.JButton();
        addAlunoAoCursoBtn = new javax.swing.JButton();
        javax.swing.JButton voltaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alunos Cadastrados no Curso");

        cursoTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cursoTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cursoTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cursoTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cursoTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cursoTbl);
        if (cursoTbl.getColumnModel().getColumnCount() > 0) {
            cursoTbl.getColumnModel().getColumn(0).setResizable(false);
            cursoTbl.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        alunosDoCursoTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        alunosDoCursoTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        alunosDoCursoTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        alunosDoCursoTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alunosDoCursoTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(alunosDoCursoTbl);
        if (alunosDoCursoTbl.getColumnModel().getColumnCount() > 0) {
            alunosDoCursoTbl.getColumnModel().getColumn(0).setMinWidth(0);
            alunosDoCursoTbl.getColumnModel().getColumn(0).setPreferredWidth(0);
            alunosDoCursoTbl.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        alunosDoCursoLbl.setText("Alunos que fazem o curso:");

        AlunosForaDoCursoLbl.setText("Alunos que não fazem o curso:");

        alunosForaDoCursoTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        alunosForaDoCursoTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        alunosForaDoCursoTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        alunosForaDoCursoTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alunosForaDoCursoTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(alunosForaDoCursoTbl);
        if (alunosForaDoCursoTbl.getColumnModel().getColumnCount() > 0) {
            alunosForaDoCursoTbl.getColumnModel().getColumn(0).setMinWidth(0);
            alunosForaDoCursoTbl.getColumnModel().getColumn(0).setPreferredWidth(0);
            alunosForaDoCursoTbl.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        deletaAlunoDoCursoBtn.setText("Excluir");
        deletaAlunoDoCursoBtn.setEnabled(false);
        deletaAlunoDoCursoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletaAlunoDoCursoBtnActionPerformed(evt);
            }
        });

        addAlunoAoCursoBtn.setText("Adicionar");
        addAlunoAoCursoBtn.setEnabled(false);
        addAlunoAoCursoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlunoAoCursoBtnActionPerformed(evt);
            }
        });

        voltaBtn.setText("Voltar");
        voltaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(AlunosForaDoCursoLbl)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addAlunoAoCursoBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deletaAlunoDoCursoBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(voltaBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(alunosDoCursoLbl))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(alunosDoCursoLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deletaAlunoDoCursoBtn)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AlunosForaDoCursoLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addAlunoAoCursoBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(voltaBtn)))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <b>Listener da tabela de cursos, click do mouse.</b>
     * <p>Transforma a tabela de cursos em um modelo de tabela padrão,
     * salva o codigo do curso na variável codigoCurso(começo da classe),
     * chama os métodos para atualizar as tabelas de alunos.</p>
     * @param evt 
     */
    private void cursoTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursoTblMouseClicked

        DefaultTableModel modeloTbl = (DefaultTableModel)
                cursoTbl.getModel();

        codigoCurso = Integer.parseInt(modeloTbl
                     .getValueAt(cursoTbl.getSelectedRow(), 0)
                     .toString());

        retornaTabelaAlunosForaDoCurso(codigoCurso);
        retornaTabelaAlunosDoCurso(codigoCurso);
    }//GEN-LAST:event_cursoTblMouseClicked

    /**
     * <b>Listener do botão de voltar, fecha a janela.</b>
     * @param evt 
     */
    private void voltaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltaBtnActionPerformed

        dispose();
    }//GEN-LAST:event_voltaBtnActionPerformed

    /**
     * <b>Listener do botão de adicionar aluno ao curso.</b>
     * <p>chama o método da camada de controle que adiciona curso/aluno, baseado nas variáveis codigoAluno e codigoCurso(inicio da classe),
     * atualiza as tabelas de aluno,
     * desabilita o botão de adicionar aluno ao curso.</p>
     * @param evt 
     */
    private void addAlunoAoCursoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlunoAoCursoBtnActionPerformed

        CursoAlunoController.adicionaCursoAlunoController(codigoAluno, codigoCurso);

        retornaTabelaAlunosForaDoCurso(codigoCurso);
        retornaTabelaAlunosDoCurso(codigoCurso);

        addAlunoAoCursoBtn.setEnabled(false);
    }//GEN-LAST:event_addAlunoAoCursoBtnActionPerformed

    /**
     * <b>Listener da tabela de alunos que não fazem o curso, click na tabela.</b>
     * <p>Transforma a tabela em um modelo de tabela,
     * salva o código do aluno clicado na variável codigoAluno(inicio da classe),
     * habilita o botão adicionar aluno ao curso.</p>
     * @param evt 
     */
    private void alunosForaDoCursoTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alunosForaDoCursoTblMouseClicked

        DefaultTableModel modeloTbl = (DefaultTableModel)
                alunosForaDoCursoTbl.getModel();

        codigoAluno = Integer.parseInt(modeloTbl.
                      getValueAt(alunosForaDoCursoTbl
                     .getSelectedRow(), 0)
                     .toString());

        addAlunoAoCursoBtn.setEnabled(true);
    }//GEN-LAST:event_alunosForaDoCursoTblMouseClicked

    /**
     * <b>Listener da tabela de aluno que fazem o curso, mouse click.</b>
     * <p>Transforma a tabela em um modelo de tabela padrão,
     * salva o código do aluno clicado na variável codigoAluno(inicio da classe),
     * habilita o botão de deletar aluno do curso.</p>
     * @param evt 
     */
    private void alunosDoCursoTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alunosDoCursoTblMouseClicked

        DefaultTableModel modeloTbl = (DefaultTableModel)
                alunosDoCursoTbl.getModel();

        codigoAluno = Integer.parseInt(modeloTbl
                      .getValueAt(alunosDoCursoTbl
                      .getSelectedRow(), 0)
                      .toString());

        deletaAlunoDoCursoBtn.setEnabled(true);
    }//GEN-LAST:event_alunosDoCursoTblMouseClicked

    /**
     * <b>Listener do botão de deletar aluno do curso.</b>
     * <p>chama o método da camada de controle que exclui curso/aluno baseado nas variáveis codigoAluno e codigoCurso(inicio da classe)
     * atualiza a tabela de alunos,
     * desabilita o botão de deletar aluno do curso.</p>
     * @param evt 
     */
    private void deletaAlunoDoCursoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaAlunoDoCursoBtnActionPerformed

        CursoAlunoController.excluiCursoAlunoController(codigoAluno, codigoCurso);

        retornaTabelaAlunosForaDoCurso(codigoCurso);
        retornaTabelaAlunosDoCurso(codigoCurso);

        deletaAlunoDoCursoBtn.setEnabled(false);
    }//GEN-LAST:event_deletaAlunoDoCursoBtnActionPerformed

    /**
     * <b>Método main.</b>
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlunosDoCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlunosDoCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlunosDoCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlunosDoCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Cria e mostra o frame. */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlunosDoCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton addAlunoAoCursoBtn;
    javax.swing.JTable alunosDoCursoTbl;
    javax.swing.JTable alunosForaDoCursoTbl;
    javax.swing.JTable cursoTbl;
    javax.swing.JButton deletaAlunoDoCursoBtn;
    // End of variables declaration//GEN-END:variables
}
