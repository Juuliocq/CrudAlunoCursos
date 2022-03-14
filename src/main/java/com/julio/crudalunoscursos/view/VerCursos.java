package com.julio.crudalunoscursos.view;

import com.julio.crudalunoscursos.controller.CursoController;
import com.julio.crudalunoscursos.model.Curso;
import com.julio.crudalunoscursos.validation.Alertas;
import static com.julio.crudalunoscursos.validation.Alertas.alertaDesejaDeletarCurso;
import com.julio.crudalunoscursos.validation.Validacao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * <b>Tela ver todos os cursos</b>
 * @version 1.0
 * @author julio
 */
public final class VerCursos extends javax.swing.JFrame {

     /**
     * <b>Variável que salva o código do curso clicado na tabela de alunos.</b>
     */
    int codigoSelecionado;

     /**
     * <b>Construtor, inicia os componentes e atualiza a tabela de cursos.</b>
     */
    public VerCursos() {
        initComponents();

        retornaTabelaCursos();
    }

    /**
     * <b>Método responsável por retornar a tabela de cursos.</b>
     * <p>Converte a tabela de cursos em um modelo de tabela padrão, 
     * adiciona a ordenação na tabela, 
     * reseta a quantidade de linhas da tabela para não mostrar linhas duplicadas, 
     * chama o método de listar todos os cursos da camada controladora de cursos e
     * e insere na tabela usando o fluxo ForEach.</p>
     */
    public void retornaTabelaCursos() {

        DefaultTableModel modelo = (DefaultTableModel) verCursosTbl.getModel();

        verCursosTbl.setRowSorter(new TableRowSorter(modelo));

        modelo.setRowCount(0);

        ArrayList<Curso> listaCurso = CursoController.retornaTodosOsCursosController();

        listaCurso.forEach(a -> {
            modelo.addRow(new Object[]{
                a.getCodigo(),
                a.getDescricao(),
                a.getEmenta()}
            );
        });
    }

     /**
     * <b>Método que instancia todos os componentes da tela.</b>
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane verCursosTblScroll = new javax.swing.JScrollPane();
        verCursosTbl = new javax.swing.JTable();
        verCursosDescricaoTxt = new javax.swing.JTextField();
        verCursosAlterarBtn = new javax.swing.JButton();
        verCursosDeletarBtn = new javax.swing.JButton();
        verCursosSalvarBtn = new javax.swing.JButton();
        javax.swing.JButton verCursosVoltarBtn = new javax.swing.JButton();
        javax.swing.JLabel verCursosDescricaoLbl = new javax.swing.JLabel();
        javax.swing.JLabel verCursosEmentaBtn = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        verCursosEmentaTxtField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizar Cursos");

        verCursosTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        verCursosTbl.setToolTipText("");
        verCursosTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        verCursosTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        verCursosTbl.getTableHeader().setReorderingAllowed(false);
        verCursosTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verCursosTblMouseClicked(evt);
            }
        });
        verCursosTblScroll.setViewportView(verCursosTbl);
        if (verCursosTbl.getColumnModel().getColumnCount() > 0) {
            verCursosTbl.getColumnModel().getColumn(0).setPreferredWidth(1);
            verCursosTbl.getColumnModel().getColumn(1).setResizable(false);
            verCursosTbl.getColumnModel().getColumn(2).setMinWidth(0);
            verCursosTbl.getColumnModel().getColumn(2).setPreferredWidth(0);
            verCursosTbl.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        verCursosDescricaoTxt.setEditable(false);

        verCursosAlterarBtn.setText("Alterar");
        verCursosAlterarBtn.setEnabled(false);
        verCursosAlterarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCursosAlterarBtnActionPerformed(evt);
            }
        });

        verCursosDeletarBtn.setText("Excluir");
        verCursosDeletarBtn.setEnabled(false);
        verCursosDeletarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCursosDeletarBtnActionPerformed(evt);
            }
        });

        verCursosSalvarBtn.setText("Salvar");
        verCursosSalvarBtn.setEnabled(false);
        verCursosSalvarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCursosSalvarBtnActionPerformed(evt);
            }
        });

        verCursosVoltarBtn.setText("Voltar");
        verCursosVoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCursosVoltarBtnActionPerformed(evt);
            }
        });

        verCursosDescricaoLbl.setText("Descrição:");

        verCursosEmentaBtn.setText("Ementa:");

        verCursosEmentaTxtField.setEditable(false);
        verCursosEmentaTxtField.setColumns(20);
        verCursosEmentaTxtField.setRows(5);
        jScrollPane2.setViewportView(verCursosEmentaTxtField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(verCursosTblScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(verCursosDescricaoLbl)
                        .addComponent(verCursosDescricaoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(verCursosEmentaBtn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(verCursosAlterarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(verCursosSalvarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(verCursosDeletarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(verCursosVoltarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verCursosDescricaoLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verCursosDescricaoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verCursosEmentaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(verCursosAlterarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verCursosDeletarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(verCursosSalvarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verCursosVoltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verCursosTblScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     /**
     * <b>Listener da tabela de cursos, click do mouse.</b>
     * <p>Transforma a tabela em um modelo padrão de tabela, 
     * atribui à variável codigoString o codigo do curso clicado na tabela, 
     * converte em int e salva na variável codigoSelecionado(inicio da classe), 
     * atribui à variável descricaoString a descricao do curso clicado na tabela, 
     * atribui ao campo de descricao o texto da variável descricaoString, 
     * atribui à variável ementaString a ementa do curso clicado na tabela(coluna invisível), 
     * atribui ao campo de ementa o texto da variável ementaString, 
     * desabilita a edição do campo de descrição e ementa do curso, 
     * habilita o botão de alterar curso, 
     * habilita o botão de deletar curso.</p>
     * @param evt 
     */
    private void verCursosTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verCursosTblMouseClicked

        DefaultTableModel modeloTbl = (DefaultTableModel) verCursosTbl.getModel();

        String codigoString = modeloTbl.getValueAt(verCursosTbl.getSelectedRow(), 0)
                                 .toString();
        codigoSelecionado = Integer.parseInt(codigoString);

        String descricaoString = modeloTbl.getValueAt(verCursosTbl.getSelectedRow(), 1)
                                 .toString();
        verCursosDescricaoTxt.setText(descricaoString);

        String ementaString = modeloTbl.getValueAt(verCursosTbl.getSelectedRow(), 2)
                              .toString();
        verCursosEmentaTxtField.setText(ementaString);
        
        verCursosDescricaoTxt.setEditable(false);
        verCursosEmentaTxtField.setEditable(false);

        verCursosAlterarBtn.setEnabled(true);
        verCursosDeletarBtn.setEnabled(true);
    }//GEN-LAST:event_verCursosTblMouseClicked

     /**
     * <b>Listener do botão de alterar curso.</b>
     * <p>Habilita a edição do campo de descrição e puxa o cursos de edição, 
     * habilita a edição do campo de ementa do curso, 
     * habilita o botão de salvar curso, 
     * desabilita os botões de alterar e deletar curso. 
     * @param evt 
     */
    private void verCursosAlterarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCursosAlterarBtnActionPerformed
        // TODO add your handling code here:

        verCursosDescricaoTxt.setEditable(true);
        verCursosDescricaoTxt.requestFocusInWindow();
        
        verCursosEmentaTxtField.setEditable(true);

        verCursosSalvarBtn.setEnabled(true);
        verCursosAlterarBtn.setEnabled(false);
        verCursosDeletarBtn.setEnabled(false);
    }//GEN-LAST:event_verCursosAlterarBtnActionPerformed

     /**
     * <b>Listener do botão de salvar curso.</b>
     * <p>Atribui a variável descricao e ementa o texto do campo de descricao e ementa do curso, 
     * chama o método de validação para ver se descricao != "" ou nulo, 
     * se for válido, chama o método de alterar curso da camada de controle
     * e salva o status (V/F) na variável booleana sucesso, 
     * chama o alerta de sucesso ao alterar o curso, 
     * se não for válido, exibe um ShowMessageDialog falando que a descrição é vazia, 
     * limpa o campo de descrição e ementa do curso, 
     * desabilita os botões de salvar e deletar curso.
     * @param evt 
     */
    private void verCursosSalvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCursosSalvarBtnActionPerformed
        // TODO add your handling code here:

        String descricao = verCursosDescricaoTxt.getText();
        String ementa = verCursosEmentaTxtField.getText();

        boolean eValido = Validacao.validaSeEstaVazio(descricao);

        if (eValido == true) {

            boolean sucesso = CursoController.alteraCursoController(codigoSelecionado, descricao, ementa);

            Alertas.alertaAlterarCurso(sucesso, descricao);

        } else {
            JOptionPane.showMessageDialog(null, "A descrição está vazia! Insira uma descrição válida.");
        }

        verCursosDescricaoTxt.setText("");
        verCursosEmentaTxtField.setText("");

        verCursosSalvarBtn.setEnabled(false);
        verCursosDeletarBtn.setEnabled(false);

        retornaTabelaCursos();

    }//GEN-LAST:event_verCursosSalvarBtnActionPerformed

     /**
     * <b>Listener do botão de deletar curso.</b>
     * <p>Atribui a variável descricao o texto do campo de descrição do curso, 
     * chama o alerta para verificar se quer realmente excluir o curso, 
     * se sim, conecta ao banco de dados, se não, não faz nada, 
     * chama o método de excluir curso da classe controladora de curso
     * e salva o status na variável booleana sucesso, 
     * exibe o alerta indicando o status da query, 
     * limpa o campo de descrição e ementa do curso, 
     * desabilita os botões de alterar e deletar curso
     * atualiza a tabela de alunos.</p>
     * @param evt 
     */
    private void verCursosDeletarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCursosDeletarBtnActionPerformed

        String descricao = verCursosDescricaoTxt.getText();
        
        int desejaExcluir = alertaDesejaDeletarCurso(descricao);
        
        if(desejaExcluir == 0){

        boolean sucesso = CursoController.excluiCursoController(codigoSelecionado);

        Alertas.alertaDeletarCurso(sucesso, descricao);
        
        verCursosDescricaoTxt.setText("");
        verCursosEmentaTxtField.setText("");

        verCursosAlterarBtn.setEnabled(false);
        verCursosDeletarBtn.setEnabled(false);

        retornaTabelaCursos();
        }
    }//GEN-LAST:event_verCursosDeletarBtnActionPerformed

    /**
     * <b>Listener do botão de voltar.</b>
     * <p>Fecha o frame.</p>
     * @param evt 
     */
    private void verCursosVoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCursosVoltarBtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_verCursosVoltarBtnActionPerformed

    /**
     * <b>Método main.</b>
     * @param args
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
            java.util.logging.Logger.getLogger(VerCursos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerCursos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerCursos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerCursos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Cria e mostra o frame. */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton verCursosAlterarBtn;
    javax.swing.JButton verCursosDeletarBtn;
    javax.swing.JTextField verCursosDescricaoTxt;
    javax.swing.JTextArea verCursosEmentaTxtField;
    javax.swing.JButton verCursosSalvarBtn;
    javax.swing.JTable verCursosTbl;
    // End of variables declaration//GEN-END:variables
}
