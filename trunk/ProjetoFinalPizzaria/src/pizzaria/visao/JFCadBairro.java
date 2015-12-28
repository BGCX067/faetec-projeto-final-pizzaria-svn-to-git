package pizzaria.visao;

import javax.swing.JOptionPane;
import pizzaria.modelo.Bairro;
import pizzaria.modelo.Cidade;
import pizzaria.modeloDao.BairroDAO;
import pizzaria.modeloDao.CidadeDAO;

public class JFCadBairro extends javax.swing.JFrame {

    private BairroDAO bairrodao;
    private Bairro bairro;
    private Cidade cidade;
    private CidadeDAO cidadedao;
    private boolean novo = true;
    private JDCnsBairro jdbairro;
    private JDCnsCidade jdcidade;

    // private JDCnsBairro jdBairro;
    /** Classe Construtora **/
    public JFCadBairro() {
        initComponents();
        bairrodao = new BairroDAO();
        cidadedao = new CidadeDAO();
        limpar();
    }

    /**  Construtor da Tela **/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtNome = new javax.swing.JTextField();
        btProcura = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btConCid = new javax.swing.JButton();
        jtCidNome = new javax.swing.JTextField();
        jtEstado = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btCanc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Bairro");

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Cadastro de Bairro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setLayout(null);

        jLabel2.setText("ID:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 0, 15, 14);

        jLabel3.setText("Nome:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 50, 40, 14);

        jtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtIdKeyTyped(evt);
            }
        });
        jPanel2.add(jtId);
        jtId.setBounds(40, 20, 40, 20);
        jPanel2.add(jtNome);
        jtNome.setBounds(40, 70, 220, 20);

        btProcura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizzaria/icons/find2_16.png"))); // NOI18N
        btProcura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcuraActionPerformed(evt);
            }
        });
        jPanel2.add(btProcura);
        btProcura.setBounds(90, 20, 50, 20);

        jLabel4.setText("UF:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(340, 100, 17, 14);

        jtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtCidadeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCidadeKeyTyped(evt);
            }
        });
        jPanel2.add(jtCidade);
        jtCidade.setBounds(40, 120, 70, 20);

        jLabel5.setText("Cidade:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(40, 100, 50, 14);

        btConCid.setText("...");
        btConCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConCidActionPerformed(evt);
            }
        });
        jPanel2.add(btConCid);
        btConCid.setBounds(120, 120, 30, 23);
        jPanel2.add(jtCidNome);
        jtCidNome.setBounds(160, 120, 170, 20);
        jPanel2.add(jtEstado);
        jtEstado.setBounds(340, 120, 70, 20);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btCanc.setText("Cancelar");
        btCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGravar)
                .addGap(18, 18, 18)
                .addComponent(btCanc)
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btExcluir)
                    .addComponent(btGravar)
                    .addComponent(btCanc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-463)/2, (screenSize.height-347)/2, 463, 347);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        novo = true;
        limpar();
        mudaEstado();
        jtNome.requestFocus();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        try {
            if (novo) // Incluir
            {
                bairro = new Bairro();
                if (!jtId.getText().isEmpty()) {
                  bairro.setBai_Id(Integer.parseInt(jtId.getText()));
                }
            }

            bairro.setBai_Nome(jtNome.getText());
            bairro.setCidade(cidade);

            if (JOptionPane.showConfirmDialog(null, "Gravar dados de Bairro ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                if (novo) {
                    bairrodao.incluir(bairro);
                } else {
                    bairrodao.alterar(bairro);
                }
                novo = false;
                exibir();
                JOptionPane.showMessageDialog(null, "Dados salvos com Sucesso !", "Bairro", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btGravarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Excluir Bairro ?", "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                bairrodao.excluir(bairro);
                bairro = null;
                exibir();
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancActionPerformed
        exibir();
    }//GEN-LAST:event_btCancActionPerformed

    private void jtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtIdKeyTyped
        if (!jtId.getText().isEmpty() && evt.getKeyChar() == '\n') {
            try {
                bairro = bairrodao.selecionarPorId(Integer.parseInt(jtId.getText()));
                if (bairro == null) {
                    cidade = null;
                    JOptionPane.showMessageDialog(null, "Bairro não Cadastrado !", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else {
                    cidade = bairro.getCidade();
                }
                exibir();
                jtId.selectAll();

            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO:", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtIdKeyTyped

    private void btProcuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcuraActionPerformed
        if (jdbairro == null) {
            jdbairro = new JDCnsBairro(this, true);
        }

        bairro = jdbairro.exibeConsulta();
        if (bairro != null) {
            exibir();
        }
}//GEN-LAST:event_btProcuraActionPerformed

    private void btConCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConCidActionPerformed
        if (jdcidade == null) {
            jdcidade = new JDCnsCidade(this, true);
        }

        cidade = jdcidade.exibeConsulta();
        if (cidade != null) {
            exibirCidade();
        }

    }//GEN-LAST:event_btConCidActionPerformed

    private void jtCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCidadeKeyTyped

    }//GEN-LAST:event_jtCidadeKeyTyped

    private void jtCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCidadeKeyReleased
        try {
            if (jtCidade.getText().isEmpty()) {
                cidade = null;
            } else {
                cidade = cidadedao.selecionarPorId(Integer.parseInt(jtCidade.getText()));
            }
        } catch (Exception ex) {
        }
        exibirCidade();
    }//GEN-LAST:event_jtCidadeKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFCadBairro().setVisible(true);
            }
        });
    }

    private void limpar() {
        jtId.setText("");
        jtNome.setText("");
        jtEstado.setText("");
        jtCidNome.setText("");
        jtCidade.setText("");
    }

    private void exibir() {
        if (bairro != null) {
            jtId.setText("" + bairro.getBai_Id());
            jtNome.setText(bairro.getBai_Nome());
            cidade=bairro.getCidade();
            exibirCidade();
            novo = false;
        } else {
            limpar();
            novo = true;
        }
        mudaEstado();
        jtId.requestFocus();
    }

    private void mudaEstado() {
        if (bairro == null || novo) {
            btExcluir.setEnabled(false);
        } else if (bairro != null) {
            btExcluir.setEnabled(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCanc;
    private javax.swing.JButton btConCid;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btProcura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jtCidNome;
    private javax.swing.JTextField jtCidade;
    private javax.swing.JTextField jtEstado;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNome;
    // End of variables declaration//GEN-END:variables

    private void exibirCidade() {
        if (cidade != null) {
            jtCidade.setText("" + cidade.getCid_id());
            jtCidNome.setText(cidade.getCid_nome());
            jtEstado.setText(cidade.getEstado().getEst_uf());
        } else {
            jtCidNome.setText("");
            jtEstado.setText("");
        }
    }



}
