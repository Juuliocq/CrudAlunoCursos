package com.julio.crudalunoscursos.view;

import com.julio.crudalunoscursos.dao.AlunoDAO;
import com.julio.crudalunoscursos.dao.CursoAlunoDAO;
import com.julio.crudalunoscursos.dao.GerenciadorConexao;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * <b>Tela que mostra os cursos de determinado aluno.</b>
 * @author julio
 */
public final class CursosDoAluno extends javax.swing.JFrame {

    /**
     * <b>Salva o codigo do aluno que foi clicado na tabela de aluno.</b>
     */
    private int codigoAluno;
    
     /**
     * <b>Salva o código do curso clicado nas duas tabelas de cursos.</b>
     */
    private int codigoCurso;

     /**
     * <b>Construtor, inicia os componentes da tela e atualiza a tabela de alunos.</b>
     */
    public CursosDoAluno() {
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

        DefaultTableModel modelo = (DefaultTableModel) alunoTbl.getModel();
        alunoTbl.setRowSorter(new TableRowSorter(modelo));

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
     * <b>Método responsável por retornar a tabela de cursos que o aluno faz.</b>
     * <p>Converte a tabela de cursos que o aluno faz em um modelo de tabela padrão,
     * adiciona a ordenação na tabela,
     * reseta a quantidade de linhas da tabela para não mostrar linhas duplicadas,
     * conecta com o banco de dados,
     * busca todos os cursos que o aluno faz na tabela curso_aluno no banco de dados,
     * insere na tabela usando o fluxo ForEach.</p>
     * @param codigo int - Código do aluno a set consultado.
     */
    public void retornaTabelaCursosDoAluno(int codigo) {

        DefaultTableModel modelo = (DefaultTableModel) cursosQueAlunoFazTbl.getModel();

        cursosQueAlunoFazTbl.setRowSorter(new TableRowSorter(modelo));

        modelo.setRowCount(0);

        AlunoDAO alunoDao = new AlunoDAO(GerenciadorConexao.connect());

        alunoDao.buscaCursosAluno(codigo)
                .getListaDeCursosDoAluno()
                .forEach(a -> {

                    modelo.addRow(new Object[]{
                        a.getCodigo(),
                        a.getDescricao(),}
                    );
                });
    }

         /**
     * <b>Método responsável por retornar a tabela de cursos que o aluno não faz.</b>
     * <p>Converte a tabela de cursos que o aluno não faz em um modelo de tabela padrão,
     * adiciona a ordenação na tabela,
     * reseta a quantidade de linhas da tabela para não mostrar linhas duplicadas,
     * conecta com o banco de dados,
     * busca todos os que o aluno não faz na tabela curso_aluno no banco de dados,
     * insere na tabela usando o fluxo ForEach.</p>
     * @param codigo int - Código do curso a set consultado.
     */
    public void retornaTabelaCursosQueAlunoNaoFaz(int codigo) {

        DefaultTableModel modelo = (DefaultTableModel) cursosQueAlunoNaoFazTbl.getModel();

        cursosQueAlunoNaoFazTbl.setRowSorter(new TableRowSorter(modelo));

        modelo.setRowCount(0);

        AlunoDAO alunoDao = new AlunoDAO(GerenciadorConexao.connect());

        alunoDao.buscaCursosAlunoNaoFaz(codigo)
                .getListaDeCursosQueAlunoNaoFaz()
                .forEach(a -> {

                    modelo.addRow(new Object[]{
                        a.getCodigo(),
                        a.getDescricao(),}
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
        alunoTbl = new javax.swing.JTable();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        cursosQueAlunoFazTbl = new javax.swing.JTable();
        javax.swing.JLabel cursosDoAlunoLbl = new javax.swing.JLabel();
        javax.swing.JLabel cursosNaoDoAlunoLbl = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane3 = new javax.swing.JScrollPane();
        cursosQueAlunoNaoFazTbl = new javax.swing.JTable();
        deletaCursoDoAlunoBtn = new javax.swing.JButton();
        addCursoDoAluno = new javax.swing.JButton();
        javax.swing.JButton voltaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cursos do Aluno");

        alunoTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        alunoTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        alunoTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        alunoTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alunoTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(alunoTbl);
        if (alunoTbl.getColumnModel().getColumnCount() > 0) {
            alunoTbl.getColumnModel().getColumn(0).setResizable(false);
            alunoTbl.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        cursosQueAlunoFazTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cursosQueAlunoFazTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cursosQueAlunoFazTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cursosQueAlunoFazTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cursosQueAlunoFazTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cursosQueAlunoFazTbl);
        if (cursosQueAlunoFazTbl.getColumnModel().getColumnCount() > 0) {
            cursosQueAlunoFazTbl.getColumnModel().getColumn(0).setMinWidth(0);
            cursosQueAlunoFazTbl.getColumnModel().getColumn(0).setPreferredWidth(0);
            cursosQueAlunoFazTbl.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        cursosDoAlunoLbl.setText("Cursos que o aluno faz:");

        cursosNaoDoAlunoLbl.setText("Cursos que o aluno não faz:");

        cursosQueAlunoNaoFazTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cursosQueAlunoNaoFazTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cursosQueAlunoNaoFazTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cursosQueAlunoNaoFazTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cursosQueAlunoNaoFazTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(cursosQueAlunoNaoFazTbl);
        if (cursosQueAlunoNaoFazTbl.getColumnModel().getColumnCount() > 0) {
            cursosQueAlunoNaoFazTbl.getColumnModel().getColumn(0).setMinWidth(0);
            cursosQueAlunoNaoFazTbl.getColumnModel().getColumn(0).setPreferredWidth(0);
            cursosQueAlunoNaoFazTbl.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        deletaCursoDoAlunoBtn.setText("Excluir");
        deletaCursoDoAlunoBtn.setEnabled(false);
        deletaCursoDoAlunoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletaCursoDoAlunoBtnActionPerformed(evt);
            }
        });

        addCursoDoAluno.setText("Adicionar");
        addCursoDoAluno.setEnabled(false);
        addCursoDoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCursoDoAlunoActionPerformed(evt);
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
                                .addComponent(cursosNaoDoAlunoLbl)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addCursoDoAluno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deletaCursoDoAlunoBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(voltaBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(cursosDoAlunoLbl))
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
                        .addComponent(cursosDoAlunoLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deletaCursoDoAlunoBtn)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cursosNaoDoAlunoLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addCursoDoAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(voltaBtn)))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     /**
     * <b>Listener da tabela de alunos, click do mouse.</b>
     * <p>Transforma a tabela de alunos em um modelo de tabela padrão,
     * salva o codigo do aluno na variável codigoAluno(começo da classe),
     * chama os métodos para atualizar as tabelas de cursos.</p>
     * @param evt 
     */
    private void alunoTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alunoTblMouseClicked

        DefaultTableModel modeloTbl = (DefaultTableModel) alunoTbl.getModel();

        codigoAluno = Integer.parseInt(modeloTbl.
                getValueAt(alunoTbl.getSelectedRow(), 0).toString());

        retornaTabelaCursosQueAlunoNaoFaz(codigoAluno);
        retornaTabelaCursosDoAluno(codigoAluno);
    }//GEN-LAST:event_alunoTblMouseClicked

    /**
     * <b>Listener do botão de voltar</b>
     * <p>Fecha o frame</p>
     * @param evt 
     */
    private void voltaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltaBtnActionPerformed

        dispose();
    }//GEN-LAST:event_voltaBtnActionPerformed

     /**
     * <b>Listener do botão de adicionar curso ao aluno.</b>
     * <p>Cria conexão com o banco de dados,
     * chama o método para adicionar um registro de curso_aluno baseado nas variáveis codigoAluno e codigoCurso(inicio da classe),
     * atualiza as tabelas de curso,
     * desabilita o botão de adicionar curso ao aluno.</p>
     * @param evt 
     */
    private void addCursoDoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCursoDoAlunoActionPerformed

        CursoAlunoDAO cursoAlunoDao = new CursoAlunoDAO(GerenciadorConexao.connect());

        cursoAlunoDao.adicionarCursoAluno(codigoAluno, codigoCurso);

        retornaTabelaCursosQueAlunoNaoFaz(codigoAluno);
        retornaTabelaCursosDoAluno(codigoAluno);

        addCursoDoAluno.setEnabled(false);
    }//GEN-LAST:event_addCursoDoAlunoActionPerformed

     /**
     * <b>Listener da tabela de cursos que o aluno não faz, click na tabela.</b>
     * <p>Transforma a tabela em um modelo de tabela,
     * salva o código do curso clicado na variável codigoCurso(inicio da classe),
     * habilita o botão adicionar curso ao aluno.</p>
     * @param evt 
     */
    private void cursosQueAlunoNaoFazTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosQueAlunoNaoFazTblMouseClicked

        DefaultTableModel modeloTbl = (DefaultTableModel) cursosQueAlunoNaoFazTbl.getModel();

        codigoCurso = Integer.parseInt(modeloTbl.
                getValueAt(cursosQueAlunoNaoFazTbl.getSelectedRow(), 0).toString());

        addCursoDoAluno.setEnabled(true);
    }//GEN-LAST:event_cursosQueAlunoNaoFazTblMouseClicked

     /**
     * <b>Listener da tabela de cursos que o aluno faz, mouse click.</b>
     * <p>Transforma a tabela em um modelo de tabela padrão,
     * salva o código do curso clicado na variável codigoCurso(inicio da classe),
     * habilita o botão de deletar curso do aluno.</p>
     * @param evt 
     */
    private void cursosQueAlunoFazTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cursosQueAlunoFazTblMouseClicked

        DefaultTableModel modeloTbl = (DefaultTableModel) cursosQueAlunoFazTbl.getModel();

        codigoCurso = Integer.parseInt(modeloTbl.
                getValueAt(cursosQueAlunoFazTbl.getSelectedRow(), 0).toString());

        deletaCursoDoAlunoBtn.setEnabled(true);
    }//GEN-LAST:event_cursosQueAlunoFazTblMouseClicked

     /**
     * <b>Listener do botão de deletar curso do aluno.</b>
     * <p>Conecta com o banco de dados, 
     * chama o método de excluir registro curso_aluno,
     * atualiza a tabela de cursos,
     * desabilita o botão de deletar curso do aluno.</p>
     * @param evt 
     */
    private void deletaCursoDoAlunoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaCursoDoAlunoBtnActionPerformed

        CursoAlunoDAO cursoAlunoDao = new CursoAlunoDAO(GerenciadorConexao.connect());

        cursoAlunoDao.excluirCursoAluno(codigoAluno, codigoCurso);

        retornaTabelaCursosQueAlunoNaoFaz(codigoAluno);
        retornaTabelaCursosDoAluno(codigoAluno);

        deletaCursoDoAlunoBtn.setEnabled(false);
    }//GEN-LAST:event_deletaCursoDoAlunoBtnActionPerformed

    /**
     * <b>Método main</b>
     * @param args
     */
    public static void main(String args[]) {

        /* Cria e mostra o frame. */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CursosDoAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton addCursoDoAluno;
    javax.swing.JTable alunoTbl;
    javax.swing.JTable cursosQueAlunoFazTbl;
    javax.swing.JTable cursosQueAlunoNaoFazTbl;
    javax.swing.JButton deletaCursoDoAlunoBtn;
    // End of variables declaration//GEN-END:variables
}
