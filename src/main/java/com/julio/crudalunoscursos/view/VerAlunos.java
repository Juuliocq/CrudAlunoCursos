/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.julio.crudalunoscursos.view;

import com.julio.crudalunoscursos.dao.AlunoDAO;
import com.julio.crudalunoscursos.dao.GerenciadorConexao;
import com.julio.crudalunoscursos.validation.Alertas;
import static com.julio.crudalunoscursos.validation.Alertas.alertaDesejaDeletarAluno;
import com.julio.crudalunoscursos.validation.Validacao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * <b>Tela ver todos os alunos</b>
 * @version 1.0
 * @author julio
 */
public final class VerAlunos extends javax.swing.JFrame {
    
    /**
     * <b>Variável que salva o código do aluno clicado na tabela de alunos.</b>
     */
    int codigoSelecionado;
    
    /**
     * <b>Construtor, inicia os componentes e atualiza a tabela de alunos.</b>
     */
    public VerAlunos() {
        initComponents();

        retornaTabelaAlunos();
    }

     /**
     * <b>Método responsável por retornar a tabela de alunos.</b>
     * <p>Converte a tabela de alunos em um modelo de tabela padrão,
     * adiciona a ordenação na tabela,
     * reseta a quantidade de linhas da tabela para não mostrar linhas duplicadas,
     * conecta com o banco de dados,
     * busca todos os alunos do banco de dados e insere na tabela usando o fluxo ForEach.</p>
     */
    public void retornaTabelaAlunos() {
        
        DefaultTableModel modelo = (DefaultTableModel) verAlunosTbl.getModel();
        verAlunosTbl.setRowSorter(new TableRowSorter(modelo));
        
        modelo.setRowCount(0);
        
        AlunoDAO alunoDao = new AlunoDAO(GerenciadorConexao.connect());

        alunoDao.buscaTodosAlunos().forEach(a -> {
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

        javax.swing.JScrollPane verAlunosTblScroll = new javax.swing.JScrollPane();
        verAlunosTbl = new javax.swing.JTable();
        verAlunosNomeTxt = new javax.swing.JTextField();
        verAlunosAlterarBtn = new javax.swing.JButton();
        verAlunosDeletarBtn = new javax.swing.JButton();
        verAlunosSalvarBtn = new javax.swing.JButton();
        javax.swing.JButton verAlunosVoltarBtn = new javax.swing.JButton();
        javax.swing.JLabel verAlunosNomeLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizar Alunos");

        verAlunosTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        verAlunosTbl.setToolTipText("");
        verAlunosTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        verAlunosTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        verAlunosTbl.getTableHeader().setReorderingAllowed(false);
        verAlunosTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verAlunosTblMouseClicked(evt);
            }
        });
        verAlunosTblScroll.setViewportView(verAlunosTbl);
        if (verAlunosTbl.getColumnModel().getColumnCount() > 0) {
            verAlunosTbl.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        verAlunosNomeTxt.setEditable(false);

        verAlunosAlterarBtn.setText("Alterar");
        verAlunosAlterarBtn.setEnabled(false);
        verAlunosAlterarBtn.setMaximumSize(new java.awt.Dimension(74, 24));
        verAlunosAlterarBtn.setMinimumSize(new java.awt.Dimension(74, 24));
        verAlunosAlterarBtn.setPreferredSize(new java.awt.Dimension(74, 24));
        verAlunosAlterarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAlunosAlterarBtnActionPerformed(evt);
            }
        });

        verAlunosDeletarBtn.setText("Excluir");
        verAlunosDeletarBtn.setEnabled(false);
        verAlunosDeletarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAlunosDeletarBtnActionPerformed(evt);
            }
        });

        verAlunosSalvarBtn.setText("Salvar");
        verAlunosSalvarBtn.setEnabled(false);
        verAlunosSalvarBtn.setMaximumSize(new java.awt.Dimension(74, 24));
        verAlunosSalvarBtn.setMinimumSize(new java.awt.Dimension(74, 24));
        verAlunosSalvarBtn.setPreferredSize(new java.awt.Dimension(74, 24));
        verAlunosSalvarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAlunosSalvarBtnActionPerformed(evt);
            }
        });

        verAlunosVoltarBtn.setText("Voltar");
        verAlunosVoltarBtn.setMaximumSize(new java.awt.Dimension(74, 24));
        verAlunosVoltarBtn.setMinimumSize(new java.awt.Dimension(74, 24));
        verAlunosVoltarBtn.setPreferredSize(new java.awt.Dimension(74, 24));
        verAlunosVoltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAlunosVoltarBtnActionPerformed(evt);
            }
        });

        verAlunosNomeLbl.setText("Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(verAlunosTblScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verAlunosNomeLbl)
                            .addComponent(verAlunosNomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(verAlunosSalvarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(verAlunosAlterarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(verAlunosDeletarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(verAlunosVoltarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(verAlunosNomeLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verAlunosNomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(verAlunosAlterarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verAlunosDeletarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(verAlunosVoltarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verAlunosSalvarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(verAlunosTblScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <b>Listener da tabela de alunos, click do mouse.</b>
     * <p>Transforma a tabela em um modelo padrão de tabela,
     * atribui à variável nomeString o nome do aluno clicado na tabela,
     * atribui ao campo de nome do aluno o texto da variável nomeString,
     * atribui à variável codigoTblString o código do aluno clicado na tabela,
     * atribui à variável codigoSelecionado(inicio da classe) o valor da variável codigoTblString,
     * desabilita a edição do campo de nome do aluno,
     * habilita o botão de alterar aluno,
     * habilita o botão de deletar aluno.</p>
     * @param evt 
     */
    private void verAlunosTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verAlunosTblMouseClicked

        DefaultTableModel modeloTbl = (DefaultTableModel)
                verAlunosTbl.getModel();

        String nomeString = modeloTbl.getValueAt(verAlunosTbl.getSelectedRow(), 1)
                            .toString();
        
        verAlunosNomeTxt.setText(nomeString);

        String codigoTblString = modeloTbl.getValueAt(verAlunosTbl.getSelectedRow(), 0)
                                 .toString();
        
        codigoSelecionado = Integer.parseInt(codigoTblString);
        
        verAlunosNomeTxt.setEditable(false);
        verAlunosAlterarBtn.setEnabled(true);
        verAlunosDeletarBtn.setEnabled(true);
    }//GEN-LAST:event_verAlunosTblMouseClicked

    /**
     * <b>Listener do botão de alterar aluno.</b>
     * <p>Habilita a edição do campo de nome do aluno,
     * foca o cursor de edição no campo de nome do aluno,
     * habilita o botão de salvar aluno,
     * desabilita os botões de alterar e deletar aluno.
     * @param evt 
     */
    private void verAlunosAlterarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAlunosAlterarBtnActionPerformed
        
        verAlunosNomeTxt.setEditable(true);
        verAlunosNomeTxt.requestFocusInWindow();
        
        verAlunosSalvarBtn.setEnabled(true);
        verAlunosAlterarBtn.setEnabled(false);
        verAlunosDeletarBtn.setEnabled(false);
    }//GEN-LAST:event_verAlunosAlterarBtnActionPerformed

    /**
     * <b>Listener do botão de salvar aluno.</b>
     * <p>Atribui a variável nome o texto do campo de nome do aluno,
     * chama o método de validação para ver se nome != "" ou nulo,
     * se for válido, conecta ao banco de dados e salva o status (V/F) na variável booleana sucesso,
     * chama o alerta de sucesso ao alterar o aluno,
     * se não for válido, exibe um ShowMessageDialog falando que o nome é vazio,
     * limpa o campo de nome do aluno,
     * desabilita os botões de salvar e deletar aluno,
     * Atualiza a tabela de alunos.</p>
     * @param evt 
     */
    private void verAlunosSalvarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAlunosSalvarBtnActionPerformed
        
        String nome = verAlunosNomeTxt.getText();
        boolean eValido = Validacao.validaSeEstaVazio(nome);
        
        if(eValido == true){
            
        AlunoDAO alunoDAO = new AlunoDAO(GerenciadorConexao.connect());
        boolean sucesso = alunoDAO.alteraAluno(codigoSelecionado, nome);

        Alertas.alertaAlterarAluno(sucesso, nome);
        
        } else {
            JOptionPane.showMessageDialog(null, "O nome está vazio! Insira um nome válido.");
        }
        
        verAlunosNomeTxt.setText("");
        
        verAlunosSalvarBtn.setEnabled(false);
        verAlunosDeletarBtn.setEnabled(false);
        
        retornaTabelaAlunos();
        
    }//GEN-LAST:event_verAlunosSalvarBtnActionPerformed

    /**
     * <b>Listener do botão de deletar aluno.</b>
     * <p>Atribui a variável nome o texto do campo de nome do aluno,
     * chama o alerta para verificar se quer realmente excluir o aluno,
     * se sim, conecta ao banco de dados, se não, não faz nada
     * executa o método de deletar aluno e salva o status na variável booleana sucesso,
     * exibe o alerta indicando o status da query,
     * limpa o campo de nome do aluno,
     * desabilita os botões de alterar e deletar aluno.
     * Atualiza a tabela de alunos</p>
     * @param evt 
     */
    private void verAlunosDeletarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAlunosDeletarBtnActionPerformed
        
        String nome = verAlunosNomeTxt.getText();
        
        int desejaExcluir = alertaDesejaDeletarAluno(nome);
        
        if(desejaExcluir == 0){
            
        AlunoDAO alunoDAO = new AlunoDAO(GerenciadorConexao.connect());
        
        boolean sucesso = alunoDAO.excluiAluno(codigoSelecionado);

        Alertas.alertaDeletarAluno(sucesso, nome);
        
        verAlunosNomeTxt.setText("");
        verAlunosAlterarBtn.setEnabled(false);
        verAlunosDeletarBtn.setEnabled(false);
        
        retornaTabelaAlunos();
        }
    }//GEN-LAST:event_verAlunosDeletarBtnActionPerformed

    /**
     * <b>Listener do botão de voltar</b>
     * <p>Fecha o frame.</p>
     * @param evt 
     */
    private void verAlunosVoltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAlunosVoltarBtnActionPerformed

        dispose();
    }//GEN-LAST:event_verAlunosVoltarBtnActionPerformed
        
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
            java.util.logging.Logger.getLogger(VerAlunos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerAlunos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerAlunos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerAlunos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Cria e mostra o frame. */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerAlunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton verAlunosAlterarBtn;
    javax.swing.JButton verAlunosDeletarBtn;
    javax.swing.JTextField verAlunosNomeTxt;
    javax.swing.JButton verAlunosSalvarBtn;
    javax.swing.JTable verAlunosTbl;
    // End of variables declaration//GEN-END:variables
}
