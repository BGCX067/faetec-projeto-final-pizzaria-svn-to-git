package pizzaria.visao;

import pizzaria.modeloDao.EntregadorDao;
import javax.swing.JOptionPane;
import pizzaria.modelo.Entregador;
import pizzaria.modelo.Funcionario;
import pizzaria.modeloDao.FuncionarioDao;

public class JFCadFuncionario extends javax.swing.JFrame {

    private Funcionario funcionario; // Representa os objetos que serão manipulados pela interface "Tela".
    private FuncionarioDao funcionarioDao; // Representa as operações da tabela junt ao Banco de Dados.
    private JDCnsFuncionario jdconsulta;
    private boolean novo = true; // Monitorar a inclusão = true ou alteração = false do registro. Flag que indicará ao botão Gravar se os Dados representam uma nova ficha "incluir", ou uma ficha já existente "alterar/excluir".

    /** Creates new form JFCadEntregador */
    public JFCadFuncionario() {
        initComponents();
        funcionarioDao = new FuncionarioDao();
        habilitaBotao();
        
        setLocationRelativeTo(null);
    }

    private void limpar() {
        txtId.setText("");
        txtNome.setText("");
        ftxtTelefone.setText("");
    }

    private void exibir() {
        if (funcionario != null) {
            txtId.setText("" + funcionario.getFun_mat());
            txtNome.setText(funcionario.getFun_nome());
            ftxtTelefone.setText(funcionario.getFun_tel());
            novo = false;
        } else {
            limpar();
            novo = true;
        }
        habilitaBotao();
        txtId.requestFocus();
    }

    private void habilitaBotao() {
        if (funcionario == null || novo) {
            btnExcluir.setEnabled(false);
            btnAlterar.setEnabled(false);
        } else if (funcionario != null) {
            btnExcluir.setEnabled(true);
            btnAlterar.setEnabled(true);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jpnlTitulo = new javax.swing.JPanel();
        jlbCadastrodeFuncionario = new javax.swing.JLabel();
        jlbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jlbTelefone = new javax.swing.JLabel();
        ftxtTelefone = new javax.swing.JFormattedTextField();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnProcurar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlbId.setText("Matricula:");

        txtId.setEnabled(false);

        jpnlTitulo.setBackground(new java.awt.Color(204, 0, 0));
        jpnlTitulo.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 0, 0)));
        jpnlTitulo.setForeground(new java.awt.Color(0, 51, 153));
        jpnlTitulo.setToolTipText("Cadastro de Entregador");

        jlbCadastrodeFuncionario.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jlbCadastrodeFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        jlbCadastrodeFuncionario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbCadastrodeFuncionario.setText("    Cadastro de Funcionário");
        jlbCadastrodeFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jpnlTituloLayout = new javax.swing.GroupLayout(jpnlTitulo);
        jpnlTitulo.setLayout(jpnlTituloLayout);
        jpnlTituloLayout.setHorizontalGroup(
            jpnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlTituloLayout.createSequentialGroup()
                .addComponent(jlbCadastrodeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jpnlTituloLayout.setVerticalGroup(
            jpnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlTituloLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlbCadastrodeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jlbNome.setText("Nome");

        jlbTelefone.setText("Telefone");

        try {
            ftxtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbNome)
                    .addComponent(jlbTelefone)
                    .addComponent(jlbId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProcurar))
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnGravar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jpnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnExcluir, btnGravar, btnNovo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcurar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTelefone)
                    .addComponent(ftxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnExcluir)
                    .addComponent(btnGravar)
                    .addComponent(btnCancelar)
                    .addComponent(btnAlterar))
                .addGap(29, 29, 29))
        );

        getAccessibleContext().setAccessibleName("Cadastro de Entregador");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
// TODO add your handling code here:
    try {
        if (novo) // Incluir
        {
            funcionario = new Funcionario();

        } else {
            funcionario.setFun_mat(Integer.parseInt(txtId.getText()));
        }

        funcionario.setFun_nome(txtNome.getText());
        funcionario.setFun_tel(ftxtTelefone.getText());


        if (JOptionPane.showConfirmDialog(null, "Gravar Dados do Funcionário ?", "Confirme",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                == JOptionPane.YES_OPTION) {

            if (novo) {
                funcionarioDao.incluir(funcionario);
            } else {
                funcionarioDao.alterar(funcionario);
            }
            novo = false;
            exibir();
            JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso !", "Funcionário",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btnGravarActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        // TODO add your handling code here:
        if (jdconsulta == null) {
            jdconsulta = new JDCnsFuncionario(this, true);
        }
        Funcionario tmp = jdconsulta.exibir();
        if (tmp != null) {
            funcionario = tmp;
            exibir();
        }
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Excluir Funcionario ?", "Confirme",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

            try {
                funcionarioDao.excluir(funcionario);
                funcionario = null;
                exibir();
                JOptionPane.showMessageDialog(null, "Funcionário excluído com Sucesso !", "Funcionário",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        novo = true;
        limpar();
        habilitaBotao();
        txtId.setEnabled(false);
        txtNome.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        exibir();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        try {
            if (novo) // Incluir
            {
                funcionario = new Funcionario();

            } else {
                funcionario.setFun_mat(Integer.parseInt(txtId.getText()));
            }

            funcionario.setFun_nome(txtNome.getText());
            funcionario.setFun_tel(ftxtTelefone.getText());

           Funcionario func = funcionarioDao.selecionarPorCod(Integer.parseInt(txtId.getText()));
            
            if (txtNome.getText().equals(func.getFun_nome()) && (ftxtTelefone.getText().equals(func.getFun_tel()))) {
                JOptionPane.showMessageDialog(null, "Os campos permanecem os mesmos !", "Entregador",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {

                if (JOptionPane.showConfirmDialog(null, "Alterar Dados do Entregador ?", "Confirme",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                        == JOptionPane.YES_OPTION) {

                    funcionarioDao.alterar(funcionario);
                    novo = false;
                    exibir();
                    JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso !", "Entregador",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    /**
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
            java.util.logging.Logger.getLogger(JFCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFCadFuncionario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JFormattedTextField ftxtTelefone;
    private javax.swing.JLabel jlbCadastrodeFuncionario;
    private javax.swing.JLabel jlbId;
    private javax.swing.JLabel jlbNome;
    private javax.swing.JLabel jlbTelefone;
    private javax.swing.JPanel jpnlTitulo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
